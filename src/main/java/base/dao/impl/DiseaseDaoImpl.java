package base.dao.impl;

import base.dao.DiseaseDao;
import base.model.Department;
import base.model.Disease;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-7
 */
@Repository
public class DiseaseDaoImpl extends BaseDaoImp<Disease> implements DiseaseDao {

  private static String namespace = "base.dao.DiseaseDao";

  @Override
  protected String namespace() {
    return namespace;
  }

  public List<String> categoryOfDisease() {
    return (List<String>) execute((session) -> session.selectList(namespace() + ".categoryOfDisease"));
  }

  public List<Disease> diseaseOfCategory(String category) {
    return (List<Disease>)
        execute((session) -> session.selectList(namespace() + ".diseaseOfCategory", category));
  }
}
