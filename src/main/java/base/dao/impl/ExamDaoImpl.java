package base.dao.impl;
import base.dao.ExamDao;
import base.model.ExamInfo;
import base.model.QuestionInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ExamDaoImpl implements  ExamDao{
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private String namespace = "com.pethospital.base.dao.ExamDao";

    public int delete(ExamInfo examInfo){
        String stat = namespace + ".delete";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.delete(stat, examInfo);
            session.commit();
            return num;
        }
    }
    public int update(ExamInfo examInfo){
        String stat = namespace + ".update";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.update(stat, examInfo);
            session.commit();
            return num;
        }
    }
    public int addExam(ExamInfo examInfo){
        String stat = namespace + ".insertExam";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.insert(stat, examInfo);
            session.commit();
            return num;
        }

    }
    public List<ExamInfo> searchExam(String labelType) {
        String stat = namespace + ".selectExam";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String nameKey = labelType.trim();
            List<ExamInfo> result = session.selectList(stat, nameKey);
            session.commit();
            return result;
        }
    }
}

