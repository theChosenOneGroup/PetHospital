package base.dao.impl;
import base.dao.VaccineDao;
import base.model.VaccineInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VaccineDaoImpl implements  VaccineDao{
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private String namespace = "com.pethospital.base.dao.VaccineDao";

    public List<VaccineInfo> searchVaccine(String vaccineName) {
        String stat = namespace + ".selectVaccine";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String nameKey = "%" + vaccineName.trim() + "%";
            List<VaccineInfo> result = session.selectList(stat, nameKey);
            session.commit();
            return result;
        }
    }

    public int addVaccine(VaccineInfo vaccineInfo){
        String stat = namespace + ".insertVaccine";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.insert(stat, vaccineInfo);
            session.commit();
            return num;
        }
    }
    public int delete(VaccineInfo vaccineInfo){
        String stat = namespace + ".delete";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.delete(stat, vaccineInfo);
            session.commit();
            return num;
        }
    }

    public int update(VaccineInfo vaccineInfo){
        String stat = namespace + ".update";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.update(stat, vaccineInfo);
            session.commit();
            return num;
        }
    }
    public List<VaccineInfo> searchAll(){
        String stat = namespace + ".selectAll";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<VaccineInfo> result = session.selectList(stat);
            session.commit();
            return result;
        }
    }
}
