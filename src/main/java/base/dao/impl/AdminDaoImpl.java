package base.dao.impl;
import base.dao.AdminDao;
import base.model.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminDaoImpl implements AdminDao {
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private String namespace = "com.pethospital.base.dao.AdminDao";

    public List<UserInfo> search(String userName) {
        String stat = namespace + ".select";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<UserInfo> result = session.selectList(stat, userName);
            session.commit();
            return result;
        }
    }

    public int add(UserInfo userInfo){
        String stat = namespace + ".insert";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.insert(stat, userInfo);
            session.commit();
            return num;
        }
    }
    public int delete(UserInfo userInfo){
        String stat = namespace + ".delete";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.delete(stat, userInfo);
            session.commit();
            return num;
        }
    }

    public int update(UserInfo userInfo){
        String stat = namespace + ".update";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.update(stat, userInfo);
            session.commit();
            return num;
        }
    }
    public List<UserInfo> searchAll(){
        String stat = namespace + ".selectAll";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<UserInfo> result = session.selectList(stat);
            session.commit();
            return result;
        }
    }
}
