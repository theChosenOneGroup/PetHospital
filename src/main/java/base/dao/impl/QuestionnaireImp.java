package base.dao.impl;

import base.dao.QuestionDao;
import base.model.Exam;
import base.model.Page;
import base.model.Question;
import base.model.Questionnaire;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-9
 */
@Repository
class QuestionnaireImp extends BaseDaoImp<Questionnaire> implements QuestionnaireDao {

  private QuestionDao questionDao;

  @Autowired
  public void setQuestionDao(QuestionDao questionDao){
    this.questionDao=questionDao;
  }

  public String namespace() {
    return "base.dao.impl.QuestionnaireDao";
  }

  public List<Question> questionnaire(Exam exam) {
    List<Long> questionId =
        (List<Long>) execute((session) -> session.selectList(namespace() + ".questionnaire", exam));
    List<Question> result = new ArrayList<>(questionId.size());
    Question question = new Question();
    for (Long id : questionId) {
      question.setId(id);
      result.add(questionDao.retrieveQuestion(question));
    }
    return result;
  }

  public int deleteQuestionnaire(Exam exam) {
    return (int) execute((session) -> session.delete(namespace() + ".deleteQuestionnaire", exam));
  }

  @Override
  public int update(Questionnaire questionnaire) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Questionnaire> retrieve(Page page) {
    throw new UnsupportedOperationException();
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException();
  }
}
