package base.service.impl;

import base.dao.ArticleDao;
import base.dao.RecordDao;
import base.model.Article;
import base.model.Record;
import base.service.ArticleService;
import base.service.FileStore;
import base.service.Uniqueness;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author long
 * @since 18-4-5
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  private FileStore fileStore;

  private ArticleDao articleDao;

  private RecordDao recordDao;

  @Autowired
  public void setArticleDao(ArticleDao articleDao) {
    this.articleDao = articleDao;
  }

  @Autowired
  public void setFileStore(FileStore fileStore) {
    this.fileStore = fileStore;
  }

  @Autowired
  public void setRecordDao(RecordDao recordDao) {
    this.recordDao = recordDao;
  }

  //TODO handle transaction
  public void delete(Article article) {
    for (Record record : recordDao.retrieveArticle(article)) {
      try {
        fileStore.delete(Uniqueness.toUniqueness(record));
      } catch (IOException e) {
        //TODO handle exception
      }
    }
    recordDao.deleteArticle(article);
    articleDao.delete(article);
  }
}
