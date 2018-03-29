package base.service;

import base.model.QuestionInfo;

import java.util.List;

public interface QuestionManageService {
    public List<QuestionInfo> searchQuestion(QuestionInfo questionInfo);
    public int addQuestion(QuestionInfo questionInfo);
    public int delete(QuestionInfo questionInfo);
    public int update(QuestionInfo questionInfo);
    public List<QuestionInfo> searchAll();
    public List<QuestionInfo> searchQuestionByType(QuestionInfo questionInfo);
    public List<QuestionInfo> searchFromAll();
}
