package base.controller;

import base.dao.DiseaseDao;
import base.model.Department;
import base.model.Disease;
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
public class DiseaseController extends BaseController {

  private DiseaseDao diseaseDao;

  @Autowired
  public void setDiseaseDao(DiseaseDao diseaseDao) {
    this.diseaseDao = diseaseDao;
  }

  @PutMapping("/disease")
  public ResponseWrapper update(@RequestBody Disease disease) {
    return messagePacker.pack(
        JsonUtil.toMap(disease),
        () -> {
          if (0 == diseaseDao.update(disease)) {
            throw new RuntimeException("Update is failed");
          }
          return null;
        });
  }

  @PostMapping("/disease")
  public ResponseWrapper create(@RequestBody Disease disease) {
    return messagePacker.pack(
        JsonUtil.toMap(disease),
        () -> {
          if (0 == diseaseDao.create(disease)) {
            throw new RuntimeException("Runtime Error");
          }
          return null;
        });
  }

  @GetMapping("/disease")
  public ResponseWrapper retrieve(@RequestParam Integer page, @RequestParam Integer pageSize) {
    return responsePacker.pack(
        JsonUtil.toMap("page", page, "pageSize", pageSize),
        () -> diseaseDao.retrieve(new Page(page, pageSize)));
  }

  @DeleteMapping("/disease/{id}")
  public ResponseWrapper delete(@PathVariable Integer id) {
    return messagePacker.pack(
        null,
        () -> {
          Disease disease = new Disease();
          disease.setId(id);
          if (0 == diseaseDao.delete(disease)) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }

  @GetMapping("/disease/count")
  public ResponseWrapper count() {
    return responsePacker.pack(
        null,
        () -> {
          List<Long> result = new ArrayList<>(1);
          result.add(diseaseDao.count());
          return result;
        });
  }

  @GetMapping("/disease/categorylist")
  public ResponseWrapper categoryOfDisease() {
    return responsePacker.pack(null, () -> diseaseDao.categoryOfDisease());
  }

  @GetMapping("/disease/category")
  public ResponseWrapper diseaseOfCategory(@RequestParam String category) {
    return responsePacker.pack(
        JsonUtil.toMap("category", category), () -> diseaseDao.diseaseOfCategory(category));
  }
}
