package base.dao;

import base.model.UserInfo;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface AdminDao {
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
    List<UserInfo> search(String userName);
    public int add(UserInfo userInfo);
    public int delete(UserInfo userInfo);
    public int update(UserInfo userInfo);
    public List<UserInfo> searchAll();
}
