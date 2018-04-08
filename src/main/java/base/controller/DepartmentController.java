package base.controller;

import base.dao.DepartmentDao;
import base.model.Department;
import base.model.Page;
import base.model.response.ResponseWrapper;
import base.util.JsonUtil;
import java.util.ArrayList;
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
 * @since 18-4-7
 */
@RestController
public class DepartmentController extends BaseController {

  private DepartmentDao departmentDao;

  @Autowired
  public void setDepartmentDao(DepartmentDao departmentDao) {
    this.departmentDao = departmentDao;
  }

  @PutMapping("/department")
  public ResponseWrapper update(@RequestBody Department department) {
    return messagePacker.pack(
        JsonUtil.toMap(department),
        () -> {
          if (0 == departmentDao.update(department)) {
            throw new RuntimeException("Update is failed");
          }
          return null;
        });
  }

  @GetMapping("/department")
  public ResponseWrapper retrieve(@RequestParam Integer page, @RequestParam Integer pageSize) {
    return responsePacker.pack(
        JsonUtil.toMap("page", page, "pageSize", pageSize),
        () -> departmentDao.retrieve(new Page(page, pageSize)));
  }

  @GetMapping("/department/count")
  public ResponseWrapper count() {
    return responsePacker.pack(
        null,
        () -> {
          List<Long> result = new ArrayList<>(1);
          result.add(departmentDao.count());
          return result;
        });
  }

  @DeleteMapping("/department/{id}")
  public ResponseWrapper delete(@PathVariable Short id) {
    return messagePacker.pack(
        null,
        () -> {
          Department department = new Department();
          department.setId(id);
          if (0 == departmentDao.delete(department)) {
            throw new RuntimeException("Delete is failed");
          }
          return null;
        });
  }

  @PostMapping("/department")
  public ResponseWrapper create(@RequestBody Department department) {
    return messagePacker.pack(
        JsonUtil.toMap(department),
        () -> {
          if (0 == departmentDao.create(department)) {
            throw new RuntimeException("Creation is failed");
          }
          return null;
        });
  }
}
