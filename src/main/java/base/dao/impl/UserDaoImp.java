package base.dao.impl;

import base.dao.UserDao;
import base.model.Page;
import base.model.User;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-3-31
 */
@Repository
public class UserDaoImp implements UserDao {

  private SqlSessionFactory sqlSessionFactory;

  private String namespace = "base.dao.UserDao";

  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<User> retrieve(Page page) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      List<User> users = session.selectList(namespace + ".retrieve", page);
      return users;
    }
  }

  public int update(User user) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      int updated = session.update(namespace + ".update", user);
      session.commit();
      return updated;
    }
  }

  public int delete(Long id) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      int deleted = session.delete(namespace + ".delete", id);
      session.commit();
      return deleted;
    }
  }

  public int create(User user) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      int created = session.delete(namespace + ".create", user);
      session.commit();
      return created;
    }
  }

  public long count() {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      Long count = session.selectOne(namespace + ".count");
      return count;
    }
  }
}
