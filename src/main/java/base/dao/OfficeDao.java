package base.dao;

import base.model.OfficeInfo;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface OfficeDao {
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
    List<OfficeInfo> search(String officeName);
    public int add(OfficeInfo officeInfo);
    public int delete(OfficeInfo officeInfo);
    public int update(OfficeInfo officeInfo);
    public List<OfficeInfo> searchAll();
}
