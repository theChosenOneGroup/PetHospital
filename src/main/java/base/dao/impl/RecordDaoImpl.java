package base.dao.impl;

import base.dao.RecordDao;
import base.model.Article;
import base.model.Page;
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

  public int create(Record record) {
    return (int) execute((session) -> session.insert(namespace + ".create", record));
  }

  public int update(Record record) {
    return (int) execute((session) -> session.update(namespace + ".update", record));
  }

  public int delete(Record record) {
    return (int) execute((session) -> session.delete(namespace + ".delete", record));
  }

  public List<Record> retrieve(Page page) {
    return (List<Record>) execute((session) -> session.selectList(namespace + ".retrieve", page));
  }

  public long count() {
    return (long) execute((session) -> session.selectOne(namespace + ".count"));
  }

  public List<Record> retrieveArticle(Article article) {
    return (List<Record>) execute(
        (session) -> session.selectList(namespace + ".retrieveArticle", article));
  }

  public int deleteArticle(Article article) {
    return (int) execute((session) -> session.delete(namespace + ".deleteArticle", article));
  }
}
