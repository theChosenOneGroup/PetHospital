package base.dao;

import base.model.LabworkInfo;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface LabworkDao {
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
    List<LabworkInfo> searchLabwork(String labworkName);
    public int addLabwork(LabworkInfo labworkInfo);
    public int delete(LabworkInfo labworkInfo);
    public int update(LabworkInfo labworkInfo);
    public List<LabworkInfo> searchAll();
}
