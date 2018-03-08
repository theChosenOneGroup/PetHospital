package base.dao.impl;

import base.dao.TestService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author long
 * @since 18-3-8
 */
@Service
public class TestServiceImpl implements TestService {

  private SqlSessionFactory sqlSessionFactory;

  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  private String namespace = "com.hypers.history.dao.HistoryStore";

  public int insert(int id) {

    String stat = namespace + ".insert";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      int num = session.insert(stat, id);
      session.commit();
      return num;
    }
  }

  public int test(int id) {
    try (SqlSession session = sqlSessionFactory.openSession()) {
      String stat = namespace + ".test";
      return session.selectOne(stat, id);
    }
  }
}
