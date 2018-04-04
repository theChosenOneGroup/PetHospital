package base.controller;

import base.dao.RecordDao;
import base.model.Page;
import base.model.Record;
import base.model.response.ResponseWrapper;
import base.util.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  private RecordDao recordDao;

  @Autowired
  public void setRecordDao(RecordDao recordDao) {
    this.recordDao = recordDao;
  }

  @GetMapping(value = "/record")
  public ResponseWrapper retrieve(@RequestParam Integer page,
      @RequestParam Integer pageSize) {
    return responsePacker.pack(JsonUtil.toMap("page", page, "pageSize", pageSize),
        () -> recordDao.retrieve(new Page(page, pageSize)));
  }

  @GetMapping(value = "/record/count")
  public ResponseWrapper count() {
    return messagePacker.pack(null, () -> {
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

  public ResponseWrapper create(@RequestParam Long createdTime,
      @RequestParam Integer rand,
      @RequestParam String description,
      @RequestParam MultipartFile file) {
    return responsePacker.pack(JsonUtil.toMap("createdTime", createdTime, "rand", rand,
        "description", description), () -> {
      Record record = new Record(createdTime, rand, file.getContentType(), description);
      if (!thriceCreate(record)) {
        throw new RuntimeException("Creation is failed");
      }
      //TODO write file to disk
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
}
