package base.dao.impl;

import base.dao.ArticleDao;
import base.model.Article;
import base.model.Page;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-4
 */
@Repository
public class ArticleDaoImpl extends BaseDaoImp<Article> implements ArticleDao {

  private static String namespace = "base.dao.ArticleDao";

  public int create(Article article) {
    return (int) execute((session -> session.insert(namespace + ".create", article)));
  }

  public int delete(Article article) {
    return (int) execute((session) -> session.delete(namespace + ".delete", article));
  }

  public int update(Article article) {
    return (int) execute((session) -> session.update(namespace + ".update", article));
  }

  public List<Article> retrieve(Page page) {
    return (List<Article>) execute((session) -> session.selectList(namespace + ".retrieve", page));
  }

  public long count() {
    return (long) execute((session) -> session.selectOne(namespace + ".count"));
  }
}
