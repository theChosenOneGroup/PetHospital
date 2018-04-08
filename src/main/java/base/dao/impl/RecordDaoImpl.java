package base.dao.impl;

import base.dao.RecordDao;
import base.model.Article;
import base.model.Record;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-4
 */
@Repository
public class RecordDaoImpl extends BaseDaoImp<Record> implements RecordDao {

  private static String namespace = "base.dao.RecordDao";

  protected String namespace() {
    return namespace;
  }

  public List<Record> retrieveArticle(Article article) {
    return (List<Record>) execute(
        (session) -> session.selectList(namespace + ".retrieveArticle", article));
  }

  public int deleteArticle(Article article) {
    return (int) execute((session) -> session.delete(namespace + ".deleteArticle", article));
  }
}
