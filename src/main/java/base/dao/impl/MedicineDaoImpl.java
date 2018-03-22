package base.dao.impl;

import base.dao.MedicineDao;
import base.model.MedicineInfo;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedicineDaoImpl implements MedicineDao {

  private SqlSessionFactory sqlSessionFactory;

  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  private String namespace = "com.pethospital.base.dao.MedicineDao";

  public int insert(MedicineInfo medicine) {
    String stat = namespace + ".insertMedicine";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      int num = session.insert(stat, medicine);
      session.commit();
      return num;
    }
  }

  public int delete(MedicineInfo medicine) {
    String stat = namespace + ".deleteMedicine";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      int num = session.delete(stat, medicine);
      session.commit();
      return num;
    }
  }

  public int update(MedicineInfo medicine) {
    String stat = namespace + ".updateMedicine";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      int num = session.update(stat, medicine);
      session.commit();
      return num;
    }
  }

  public List<MedicineInfo> search(String medicineName) {
    String stat = namespace + ".selectMedicine";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      String nameKey = "%" + medicineName.trim() + "%";
      List<MedicineInfo> result = session.selectList(stat, nameKey);
      session.commit();
      return result;
    }
  }

  public List<MedicineInfo> searchAll() {
    String stat = namespace + ".selectAllMedicine";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      List<MedicineInfo> result = session.selectList(stat);
      session.commit();
      return result;
    }
  }
}
