package base.dao.impl;

import base.dao.BaseDao;
import base.model.Exam;
import base.model.Question;
import base.model.Questionnaire;
import java.util.List;

/**
 * @author long
 * @since 18-4-9
 */
interface QuestionnaireDao extends BaseDao<Questionnaire> {
  List<Question> questionnaire(Exam exam);

  int deleteQuestionnaire(Exam exam);
}
