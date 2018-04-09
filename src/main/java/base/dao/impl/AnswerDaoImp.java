package base.dao.impl;

import base.model.Answer;
import base.model.Examinee;
import base.model.Page;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-9
 */
@Repository
class AnswerDaoImp extends BaseDaoImp<Answer> implements AnswerDao {

  public String namespace() {
    return "base.dao.impl.AnswerDao";
  }

  public List<Answer> answerOfExaminee(Examinee examinee) {
    return (List<Answer>)
        execute((session) -> session.selectList(namespace() + ".answerOfExaminee", examinee));
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Answer> retrieve(Page page) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int update(Answer answer) {
    throw new UnsupportedOperationException();
  }
}
