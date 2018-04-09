package base.dao.impl;

import base.dao.BaseDao;
import base.model.Exam;
import base.model.Examinee;
import base.model.User;

/**
 * @author long
 * @since 18-4-9
 */
interface ExamineeDao extends BaseDao<Examinee> {
  int deleteByExam(Exam exam);

  int deleteByUser(User use);
}
