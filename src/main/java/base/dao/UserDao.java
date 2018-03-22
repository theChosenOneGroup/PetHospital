package base.dao;

import base.model.UserInfo;
import org.apache.ibatis.session.SqlSessionFactory;

public interface UserDao {

  public int insert(UserInfo userInfo);
  public int update(UserInfo userInfo);

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
}
