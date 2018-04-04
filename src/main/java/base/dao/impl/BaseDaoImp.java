package base.dao.impl;

import base.dao.BaseDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author long
 * @since 18-4-4
 */
public abstract class BaseDaoImp<T> implements BaseDao<T> {

  private SqlSessionFactory sqlSessionFactory;

  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  protected Object execute(Task task) {
    SqlSession session = sqlSessionFactory.openSession();
    try {
      return task.run(session);
    } finally {
      session.commit();
    }
  }

  protected interface Task {

    Object run(SqlSession session);
  }
}
