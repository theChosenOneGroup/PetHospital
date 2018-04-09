package base.controller;

import base.dao.JobDao;
import base.model.Job;
import base.model.Page;
import base.model.Position;
import base.model.response.ResponseWrapper;
import base.util.JsonUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author long
 * @since 18-4-8
 */
@RestController
public class JobController extends BaseController {

  private JobDao jobDao;

  @Autowired
  public void setJobDao(JobDao jobDao) {
    this.jobDao = jobDao;
  }

  @GetMapping("/job")
  public ResponseWrapper retrieve(@RequestParam Integer page, @RequestParam Integer pageSize) {
    return responsePacker.pack(
        JsonUtil.toMap("page", page, "pageSize", pageSize),
        () -> jobDao.retrieve(new Page(page, pageSize)));
  }

  @GetMapping("/job/{position}")
  public ResponseWrapper jobOfPosition(@PathVariable Position position) {
    return responsePacker.pack(
        null,
        () -> {
          Job job = new Job();
          job.setPosition(position);
          return jobDao.jobOfPosition(job);
        });
  }

  @GetMapping("/job/count")
  public ResponseWrapper count() {
    return responsePacker.pack(
        null,
        () -> {
          List<Long> result = new ArrayList<>(1);
          result.add(jobDao.count());
          return result;
        });
  }

  @PostMapping("/job")
  public ResponseWrapper create(@RequestBody Job job) {
    return responsePacker.pack(
        JsonUtil.toMap(job),
        () -> {
          job.setId(new Date().getTime());
          if (!thriceCreate(job)) {
            throw new RuntimeException("Creation is failed");
          }
          List<Job> result = new ArrayList<>(1);
          result.add(job);
          return result;
        });
  }

  private boolean thriceCreate(Job job) {
    for (int i = 0; i < 3; i++) {
      if (0 != jobDao.create(job)) {
        return true;
      } else {
        job.flip();
      }
    }
    return false;
  }

  @PutMapping("/job")
  public ResponseWrapper update(@RequestBody Job job) {

    return messagePacker.pack(
        JsonUtil.toMap(job),
        () -> {
          if (0 == jobDao.update(job)) {
            throw new RuntimeException("Update is failed");
          }
          return null;
        });
  }

  @DeleteMapping("/job/{id}")
  public ResponseWrapper delete(@PathVariable Long id) {
    return messagePacker.pack(
        null,
        () -> {
          Job job = new Job();
          job.setId(id);
          if (0 == jobDao.delete(job)) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }
}
