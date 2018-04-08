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

  protected String namespace() {
    return namespace;
  }
}
