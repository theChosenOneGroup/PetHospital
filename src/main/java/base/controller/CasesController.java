package base.controller;

import base.dao.CasesDao;
import base.model.Cases;
import base.model.response.ResponseWrapper;
import base.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author long
 * @since 18-4-7
 */
@RestController
public class CasesController extends BaseController {
  private CasesDao casesDao;

  @Autowired
  public void setCasesDao(CasesDao casesDao) {
    this.casesDao = casesDao;
  }

  @PostMapping("/cases")
  public ResponseWrapper create(@RequestBody Cases cases) {
    return messagePacker.pack(
        JsonUtil.toMap(cases),
        () -> {
          if (0 == casesDao.create(cases)) {
            throw new RuntimeException("Creation is failed");
          }
          return null;
        });
  }

  @DeleteMapping("/cases/{diseaseId}/{createdTime}/{rand}")
  public ResponseWrapper delete(
      @PathVariable Integer diseaseId, @PathVariable Long createdTime, @PathVariable Integer rand) {
    return messagePacker.pack(
        null,
        () -> {
          if (0 == casesDao.delete(new Cases(diseaseId, createdTime, rand))) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }

  @GetMapping("/cases/article/{diseaseId}")
  public ResponseWrapper retrieveArticle(@PathVariable Integer diseaseId) {
    return responsePacker.pack(
        null, () -> casesDao.retrieveArticle(new Cases(diseaseId, null, null)));
  }
}
