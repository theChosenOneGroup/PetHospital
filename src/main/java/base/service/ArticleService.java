package base.service;

import base.model.Article;
import base.model.Record;
import java.util.List;

/**
 * @author long
 * @since 18-4-5
 */
public interface ArticleService {

  void delete(Article article);

  List<Record> retrieve(Article article);
}
