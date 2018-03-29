package base.dao.impl;
import base.dao.QuestionDao;
import base.model.QuestionInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImpl implements  QuestionDao {
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private String namespace = "com.pethospital.base.dao.QuestionDao";

    public List<QuestionInfo> searchQuestion(String text) {
        String stat = namespace + ".selectQuestion";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String nameKey = "%" + text.trim() + "%";
            List<QuestionInfo> result = session.selectList(stat, nameKey);
            session.commit();
            return result;
        }
    }

    public int addQuestion(QuestionInfo questionInfo) {
        String stat = namespace + ".insertQuestion";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.insert(stat, questionInfo);
            session.commit();
            return num;
        }
    }

    public int delete(QuestionInfo questionInfo) {
        String stat = namespace + ".delete";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.delete(stat, questionInfo);
            session.commit();
            return num;
        }
    }

    public int update(QuestionInfo questionInfo) {
        String stat = namespace + ".update";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            int num = session.update(stat, questionInfo);
            session.commit();
            return num;
        }
    }

    public List<QuestionInfo> searchAll() {
        String stat = namespace + ".selectAll";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<QuestionInfo> result = session.selectList(stat);
            session.commit();
            return result;
        }
    }

    public List<QuestionInfo> searchFromAll() {
        String stat = namespace + ".selectFromAll";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            List<QuestionInfo> result = session.selectList(stat);
            session.commit();
            return result;
        }
    }
    public List<QuestionInfo> searchQuestionByType(String typeName) {
        String stat = namespace + ".selectQuestion";
        try (SqlSession session = sqlSessionFactory.openSession()) {
            String nameKey = "%" + typeName.trim() + "%";
            List<QuestionInfo> result = session.selectList(stat, nameKey);
            session.commit();
            return result;
        }
    }
}
