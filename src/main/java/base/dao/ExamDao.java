package base.dao;

import base.model.Exam;
import base.model.Question;
import base.model.User;
import java.util.List;

/**
 * @author long
 * @since 18-4-9
 */
public interface ExamDao extends BaseDao<Exam> {
  List<Question> questionnaireOf(Exam exam);

  int deleteQuestionnaire(Exam exam);

  int addQuestion(Exam exam, Question question);

  int deleteQuestion(Exam exam, Question question);

  int addExaminee(Exam exam, User user);

  int deleteExaminee(Exam exam, User user);

  int deleteExaminee(Exam exam);

  int deleteExaminee(User user);
}
