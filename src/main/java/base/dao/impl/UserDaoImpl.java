package base.dao.impl;

import base.dao.UserDao;
import base.model.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private String namespace = "com.pethospital.base.dao.UserDao";

    public int insert(UserInfo userInfo){
        String stat = namespace + ".insertUser";
        try (SqlSession session = sqlSessionFactory.openSession()){
            int num = session.insert(stat, userInfo);
            session.commit();
            return num;
        }
    }

}
