package base.dao.impl;
import base.dao.LabworkDao;
import base.model.LabworkInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LabworkDaoImpl implements  LabworkDao{
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private String namespace = "com.pethospital.base.dao.LabworkDao";

    public List<LabworkInfo> searchLabwork(String labworkName) {
        String stat = namespace + ".selectLabwork";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String nameKey = "%" + labworkName.trim() + "%";
            List<LabworkInfo> result = session.selectList(stat, nameKey);
            session.commit();
            return result;
        }
    }

    public int addLabwork(LabworkInfo labworkInfo){
        String stat = namespace + ".insertLabwork";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.insert(stat, labworkInfo);
            session.commit();
            return num;
        }
    }
    public int delete(LabworkInfo labworkInfo){
        String stat = namespace + ".delete";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.delete(stat, labworkInfo);
            session.commit();
            return num;
        }
    }

    public int update(LabworkInfo labworkInfo){
        String stat = namespace + ".update";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.update(stat, labworkInfo);
            session.commit();
            return num;
        }
    }
    public List<LabworkInfo> searchAll(){
        String stat = namespace + ".selectAll";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<LabworkInfo> result = session.selectList(stat);
            session.commit();
            return result;
        }
    }
}
