package base.service.impl;

import base.dao.ExamDao;
import base.dao.QuestionDao;
import base.model.ExamInfo;
import base.model.QuestionInfo;
import base.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManageServiceImpl implements ExamManageService {
    @Autowired
    private ExamDao examDao;
    private QuestionDao questionDao;
    public int delete(ExamInfo examInfo) {
        int result = examDao.delete(examInfo);
        return result;
    }

    public int update(ExamInfo examInfo) {
        int result = examDao.update(examInfo);
        return result;
    }
    public int addExam(ExamInfo examInfo) {
        int result = examDao.addExam(examInfo);
        return result;
    }
    public List<ExamInfo> searchExam(ExamInfo examInfo)
    {
        List<ExamInfo> examList= examDao.searchExam(examInfo.getLabelType());
        return examList;
    }
}

