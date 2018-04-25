package base.service.impl;

import base.dao.ExamDao;
import base.model.ExamInfo;
import base.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamManageServiceImpl implements ExamManageService {
    @Autowired
    private ExamDao examDao;

    public int delete(ExamInfo examInfo) {
        int result = examDao.delete(examInfo);
        return result;
    }

    public int update(ExamInfo examInfo) {
        int result = examDao.update(examInfo);
        return result;
    }
}

