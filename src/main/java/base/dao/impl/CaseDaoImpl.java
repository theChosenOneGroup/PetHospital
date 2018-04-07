package base.dao.impl;
import base.dao.CaseDao;
import base.model.CaseInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CaseDaoImpl implements CaseDao {
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private String namespace = "com.pethospital.base.dao.CaseDao";

    public List<CaseInfo> search(String caseName) {
        String stat = namespace + ".select";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String nameKey = "%" + caseName.trim() + "%";
            List<CaseInfo> result = session.selectList(stat, nameKey);
            session.commit();
            return result;
        }
    }

    public int add(CaseInfo caseInfo){
        String stat = namespace + ".insert";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.insert(stat, caseInfo);
            session.commit();
            return num;
        }
    }
    public int delete(CaseInfo caseInfo){
        String stat = namespace + ".delete";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.delete(stat, caseInfo);
            session.commit();
            return num;
        }
    }

    public int update(CaseInfo caseInfo){
        String stat = namespace + ".update";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.update(stat, caseInfo);
            session.commit();
            return num;
        }
    }
    public List<CaseInfo> searchAll(){
        String stat = namespace + ".selectAll";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<CaseInfo> result = session.selectList(stat);
            session.commit();
            return result;
        }
    }

    public String getCost(String caseName){
        String stat = namespace + ".cost";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String result = session.selectOne(stat, caseName);
            session.commit();
            return result;
        }
    }
}
