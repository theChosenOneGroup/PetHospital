package base.service;

import base.model.ExamInfo;
import base.model.QuestionInfo;

import java.util.List;

public interface ExamManageService {
    public int delete(ExamInfo examInfo);

    public int update(ExamInfo examInfo);

    public int addExam(ExamInfo examInfo);
}
