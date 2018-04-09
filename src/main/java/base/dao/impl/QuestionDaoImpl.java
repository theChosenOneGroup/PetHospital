package base.dao.impl;

import base.dao.QuestionDao;
import base.model.Option;
import base.model.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-9
 */
@Repository
public class QuestionDaoImpl extends BaseDaoImp<Question> implements QuestionDao {

  private OptionDao optionDao;

  @Autowired
  public void setOptionDao(OptionDao optionDao) {
    this.optionDao = optionDao;
  }

  @Override
  protected String namespace() {
    return "base.dao.QuestionDao";
  }

  @Override
  public int delete(Question question) {
    if (0 == optionDao.deleteQuestion(question)) {
      throw new RuntimeException("Deletion is failed");
    }
    return super.delete(question);
  }

  @Override
  public int create(Question question) {
    if (question.getOptions() == null) {
      return super.create(question);
    } else {
      int created = super.create(question);
      if (created == 0) {
        throw new RuntimeException("Creation is failed");
      }
      for (Option option : question.getOptions()) {
        option.setQuestionId(question.getId());
        created += this.addOption(option);
      }
      // TODO handle exception occurred when adding option
      return created;
    }
  }

  public List<Option> optionOfQuestion(Question question) {
    return optionDao.optionOfQuestion(question);
  }

  public int addOption(Option option) {
    return optionDao.create(option);
  }

  public int deleteOption(Option option) {
    return optionDao.delete(option);
  }

  public int deleteQuestion(Question question) {
    return optionDao.deleteQuestion(question);
  }
}
