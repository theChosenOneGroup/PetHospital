package base.dao.impl;
import base.dao.OfficeDao;
import base.model.OfficeInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private String namespace = "com.pethospital.base.dao.OfficeDao";

    public List<OfficeInfo> search(String officeName) {
        String stat = namespace + ".select";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String nameKey = "%" + officeName.trim() + "%";
            List<OfficeInfo> result = session.selectList(stat, nameKey);
            session.commit();
            return result;
        }
    }

    public int add(OfficeInfo officeInfo){
        String stat = namespace + ".insert";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.insert(stat, officeInfo);
            session.commit();
            return num;
        }
    }
    public int delete(OfficeInfo officeInfo){
        String stat = namespace + ".delete";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.delete(stat, officeInfo);
            session.commit();
            return num;
        }
    }

    public int update(OfficeInfo officeInfo){
        String stat = namespace + ".update";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.update(stat, officeInfo);
            session.commit();
            return num;
        }
    }
    public List<OfficeInfo> searchAll(){
        String stat = namespace + ".selectAll";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<OfficeInfo> result = session.selectList(stat);
            session.commit();
            return result;
        }
    }
}
