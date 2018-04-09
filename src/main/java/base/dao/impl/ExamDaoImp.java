package base.dao.impl;

import base.dao.ExamDao;
import base.model.Answer;
import base.model.Exam;
import base.model.Examinee;
import base.model.Question;
import base.model.Questionnaire;
import base.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-9
 */
@Repository
public class ExamDaoImp extends BaseDaoImp<Exam> implements ExamDao {

  private QuestionnaireDao questionnaireDao;

  private ExamineeDao examineeDao;

  private AnswerDao answerDao;

  @Autowired
  public void setQuestionnaireDao(QuestionnaireDao questionnaireDao) {
    this.questionnaireDao = questionnaireDao;
  }

  @Autowired
  public void setExamineeDao(ExamineeDao examineeDao) {
    this.examineeDao = examineeDao;
  }

  @Autowired
  public void setAnswerDao(AnswerDao answerDao) {
    this.answerDao = answerDao;
  }

  public String namespace() {
    return "base.dao.ExamDao";
  }

  public List<Question> questionnaireOf(Exam exam) {
    return questionnaireDao.questionnaire(exam);
  }

  public int deleteQuestionnaire(Exam exam) {
    return questionnaireDao.deleteQuestionnaire(exam);
  }

  public int addQuestion(Exam exam, Question question) {
    return questionnaireDao.create(new Questionnaire(exam.getId(), question.getId()));
  }

  public int deleteQuestion(Exam exam, Question question) {
    return questionnaireDao.delete(new Questionnaire(exam.getId(), question.getId()));
  }

  public int addExaminee(Exam exam, User user) {
    return examineeDao.create(new Examinee(exam.getId(), user.getId()));
  }

  public int deleteExaminee(Exam exam, User user) {
    return examineeDao.delete(new Examinee(exam.getId(), user.getId()));
  }

  public int deleteExaminee(Exam exam) {
    return examineeDao.deleteByExam(exam);
  }

  public int deleteExaminee(User user) {
    return examineeDao.deleteByUser(user);
  }

  @Override
  public int delete(Exam exam) {
    if (0 == questionnaireDao.deleteQuestionnaire(exam) || 0 == examineeDao.deleteByExam(exam)) {
      throw new RuntimeException("Deletion is failed");
    }
    return super.delete(exam);
  }

  public int deleteAnswer(Answer answer) {
    return answerDao.delete(answer);
  }

  public int addAnswer(Answer answer) {
    return answerDao.create(answer);
  }

  public List<Answer> answerOf(Examinee examinee) {
    return answerDao.answerOfExaminee(examinee);
  }
}
