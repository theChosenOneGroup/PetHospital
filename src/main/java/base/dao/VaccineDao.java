package base.dao;

import base.model.VaccineInfo;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface VaccineDao {
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
    List<VaccineInfo> searchVaccine(String vaccineName);
    public int addVaccine(VaccineInfo vaccineInfo);
    public int delete(VaccineInfo vaccineInfo);
    public int update(VaccineInfo vaccineInfo);
    public List<VaccineInfo> searchAll();
}
