package base.dao.impl;

import base.dao.CasesDao;
import base.model.Article;
import base.model.Cases;
import base.model.Page;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-7
 */
@Repository
public class CasesDaoImpl extends BaseDaoImp<Cases> implements CasesDao {

  private static String namespace = "base.dao.CasesDao";

  @Override
  protected String namespace() {
    return namespace;
  }

  @Override
  public int update(Cases cases) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Cases> retrieve(Page page) {
    throw new UnsupportedOperationException();
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException();
  }

  public List<Article> retrieveArticle(Cases cases) {
    return (List<Article>)
        execute((session) -> session.selectList(namespace() + ".retrieveArticle", cases));
  }
}
