package base.dao.impl;

import base.dao.BaseDao;
import base.model.Page;
import java.util.List;
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

  public int update(T t) {
    return (int) execute((session) -> session.update(namespace() + ".update", t));
  }

  public int delete(T t) {
    return (int) execute((session) -> session.delete(namespace() + ".delete", t));
  }

  public int create(T t) {
    return (int) execute((session) -> session.insert(namespace() + ".create", t));
  }

  public List<T> retrieve(Page page) {
    return (List<T>) execute((session) -> session.selectList(namespace() + ".retrieve", page));
  }

  public long count() {
    return (long) execute((session) -> session.selectOne(namespace() + ".count"));
  }

  protected abstract String namespace();

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
