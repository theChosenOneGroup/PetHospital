package base.dao;

import base.model.QuestionInfo;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public interface QuestionDao {
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
    List<QuestionInfo> searchQuestion(String text);
    public int addQuestion(QuestionInfo questionInfo);
    public int delete(QuestionInfo questionInfo);
    public int update(QuestionInfo questionInfo);
    public List<QuestionInfo> searchAll();
    public List<QuestionInfo> searchFromAll();
    List<QuestionInfo> searchQuestionByType(String type);
}
