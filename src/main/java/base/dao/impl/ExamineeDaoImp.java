package base.dao.impl;

import base.model.Exam;
import base.model.Examinee;
import base.model.Page;
import base.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-9
 */
@Repository
class ExamineeDaoImp extends BaseDaoImp<Examinee> implements ExamineeDao {
  public String namespace() {
    return "base.dao.impl.ExamineeDao";
  }

  public int deleteByExam(Exam exam) {
    return (int) execute((session) -> session.delete(namespace() + ".deleteByExam", exam));
  }

  public int deleteByUser(User user) {
    return (int) execute((session) -> session.delete(namespace() + ".deleteByUser", user));
  }

  @Override
  public int update(Examinee examinee) {
    throw new UnsupportedOperationException();
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<Examinee> retrieve(Page page) {
    throw new UnsupportedOperationException();
  }
}
