package base.dao;

import base.model.Article;
import base.model.Record;
import java.util.List;

/**
 * @author long
 * @since 18-4-4
 */
public interface RecordDao extends BaseDao<Record> {

  List<Record> retrieveArticle(Article article);

  int deleteArticle(Article article);
}
