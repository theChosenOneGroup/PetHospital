package base.controller;

import base.dao.RecordDao;
import base.model.Page;
import base.model.Record;
import base.model.response.ResponseWrapper;
import base.service.FileStore;
import base.service.Uniqueness;
import base.util.JsonUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author long
 * @since 18-4-4
 */
@RestController
public class RecordController extends BaseController {

  private static final String TEXT_PLAIN = "text/plain";

  private RecordDao recordDao;

  private FileStore fileStore;

  @Autowired
  public void setRecordDao(RecordDao recordDao) {
    this.recordDao = recordDao;
  }

  @Autowired
  public void setFileStore(FileStore fileStore) {
    this.fileStore = fileStore;
  }

  @GetMapping(value = "/record")
  public ResponseWrapper retrieve(@RequestParam Integer page,
      @RequestParam Integer pageSize) {
    return responsePacker.pack(JsonUtil.toMap("page", page, "pageSize", pageSize),
        () -> recordDao.retrieve(new Page(page, pageSize)));
  }

  @GetMapping(value = "/record/count")
  public ResponseWrapper count() {
    return responsePacker.pack(null, () -> {
      List<Long> result = new ArrayList<>(1);
      result.add(recordDao.count());
      return result;
    });
  }

  @PutMapping(value = "/record")
  public ResponseWrapper update(@RequestBody Record record) {
    return messagePacker.pack(JsonUtil.toMap(record), () -> {
      if (0 == recordDao.update(record)) {
        throw new RuntimeException("Update is failed");
      }
      return null;
    });
  }

  @PostMapping(value = "/record")
  public ResponseWrapper upload(@RequestParam Long createdTime,
      @RequestParam Integer rand,
      @RequestParam String description,
      @RequestParam(required = false) String content,
      @RequestParam(required = false) MultipartFile file) {
    return responsePacker.pack(JsonUtil.toMap("createdTime", createdTime, "rand", rand,
        "description", description), () -> {
      Record record = new Record(createdTime, rand,
          content == null ? file.getContentType() : TEXT_PLAIN, description);
      if (!thriceCreate(record)) {
        throw new RuntimeException("Creation is failed");
      }
      //TODO write file to disk
      try {
        if (content != null) {
          fileStore.store(content.getBytes(), Uniqueness.toUniqueness(record));
        } else {
          fileStore.store(file.getInputStream(), Uniqueness.toUniqueness(record));
        }
      } catch (IOException e) {
        recordDao.delete(record);
        throw new RuntimeException("Creation is failed");
      }

      List<Record> result = new ArrayList<>(1);
      result.add(record);
      return result;
    });
  }

  private boolean thriceCreate(Record record) {
    for (int i = 0; i < 3; i++) {
      try {
        if (0 != recordDao.create(record)) {
          return true;
        }
      } catch (Exception e) {
      }
      record.flip();
    }
    return false;
  }

  @GetMapping(value = "/record/download")
  public void download(@RequestParam Long createdTime, @RequestParam Integer rand,
      @RequestParam Integer sequence, @RequestParam String contentType,
      HttpServletResponse response) {
    Record record = new Record(createdTime, rand, sequence, contentType, null);
    InputStream in = null;
    OutputStream out = null;
    try {
      in = fileStore.retrieve(Uniqueness.toUniqueness(record));
      response.setHeader("Content-Type", contentType);
      out = response.getOutputStream();
      byte[] bytes = new byte[4096];
      int count;
      while (-1 != (count = in.read(bytes))) {
        out.write(bytes, 0, count);
      }
      out.flush();
    } catch (IOException e) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return;
    } finally {
      try {
        if (in != null) {
          in.close();
        }
        if (out != null) {
          out.close();
        }
      } catch (IOException ex) {
      }
    }
  }

  @DeleteMapping(value = "/record/{createdTime}/{rand}/{sequence}")
  public ResponseWrapper delete(@PathVariable Long createdTime,
      @PathVariable Integer rand, @PathVariable Integer sequence) {
    return messagePacker
        .pack(null, () -> {
          Record record = new Record(createdTime, rand, sequence, null, null);
          //TODO handle transaction
          if (0 == recordDao.delete(record)) {
            throw new RuntimeException("Deletion is failed");
          }
          try {
            fileStore.delete(Uniqueness.toUniqueness(record));
          } catch (IOException e) {
            throw new RuntimeException("Deletion of file entity is failed");
          }
          return null;
        });
  }
}
