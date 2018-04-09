package base.dao.impl;

import base.dao.BaseDao;
import base.model.Answer;
import base.model.Examinee;
import java.util.List;

/**
 * @author long
 * @since 18-4-9
 */
interface AnswerDao extends BaseDao<Answer> {
  List<Answer> answerOfExaminee(Examinee examinee);
}
