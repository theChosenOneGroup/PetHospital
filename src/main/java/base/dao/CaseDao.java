package base.dao;

import base.model.CaseInfo;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface CaseDao {
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
    List<CaseInfo> search(String caseName);
    public int add(CaseInfo caseInfo);
    public int delete(CaseInfo caseInfo);
    public int update(CaseInfo caseInfo);
    public List<CaseInfo> searchAll();
    public String getCost(String caseName);
}
