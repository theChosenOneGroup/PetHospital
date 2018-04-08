package base.dao;

import base.model.Article;
import base.model.Cases;
import java.util.List;

/**
 * @author long
 * @since 18-4-7
 */
public interface CasesDao extends BaseDao<Cases> {
  List<Article> retrieveArticle(Cases cases);
}
