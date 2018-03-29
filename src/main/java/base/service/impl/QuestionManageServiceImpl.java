package base.service.impl;

import base.dao.QuestionDao;
import base.model.QuestionInfo;
import base.service.QuestionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionManageServiceImpl implements QuestionManageService {
    @Autowired
    private QuestionDao questionDao;

    public List<QuestionInfo> searchQuestion(QuestionInfo questionInfo) {
        List<QuestionInfo> questionList= questionDao.searchQuestion(questionInfo.getText());
        return questionList;
    }

    public int addQuestion(QuestionInfo questionInfo) {
        int result = questionDao.addQuestion(questionInfo);
        return result;
    }
    public int delete(QuestionInfo questionInfo){
        int result = questionDao.delete(questionInfo);
        return result;
    }
    public int update(QuestionInfo questionInfo){
        int result= questionDao.update(questionInfo);
        return result;
    }

    public List<QuestionInfo> searchAll(){
        List<QuestionInfo> questionList= questionDao.searchAll();
        return questionList;
    }
    public List<QuestionInfo> searchQuestionByType(QuestionInfo questionInfo)
    {
        List<QuestionInfo> questionList= questionDao.searchQuestionByType(questionInfo.getTypeName());
        return questionList;
    }
    public List<QuestionInfo> searchFromAll(){
        List<QuestionInfo> questionList= questionDao.searchFromAll();
        return questionList;
    }
}
