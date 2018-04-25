package base.dao;

import base.model.ExamInfo;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface ExamDao {
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
    public int delete(ExamInfo examInfo);
    public int update(ExamInfo examInfo);

}
