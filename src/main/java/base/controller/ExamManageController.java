package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.ExamInfo;
import base.model.QuestionInfo;
import base.model.response.ResponseWrapper;
import base.service.ExamManageService;
import base.service.QuestionManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ExamManageController {
    private QuestionManageService questionManageService;
    private ExamManageService examManageService;
    private ResponsePacker responsePacker = new ResponsePacker();

    @Autowired
    public void setUserManageService(ExamManageService examManageService) {
        this.examManageService = examManageService;
    }
    @Autowired
    public void setUserManageService(QuestionManageService questionManageService) {
        this.questionManageService = questionManageService;
    }

    @RequestMapping(value = "/exam/delete", method = RequestMethod.POST)
    public ResponseWrapper delete(@RequestBody ExamInfo examInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(examManageService.delete(examInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/exam/update", method = RequestMethod.POST)
    public ResponseWrapper update(@RequestBody ExamInfo examInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(examManageService.update(examInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
    @RequestMapping(value = "/exam/add", method = RequestMethod.POST)
    public ResponseWrapper addExam(@RequestBody ExamInfo examInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                QuestionInfo questionInfo = new QuestionInfo();
                questionInfo.setTypeName(examInfo.getLabelType());
                List result1 = new ArrayList<QuestionInfo>();
                result1=questionManageService.searchQuestionByType(questionInfo);
                String s="";
                for(int i = 0;i<result1.size();i++)
                {
                    QuestionInfo temp = (QuestionInfo)result1.get(i);
                    if(i ==result1.size()-1)
                    {
                        s = s+temp.getQuestionId();
                        break;
                    }
                    s = s+temp.getQuestionId()+",";
                }
                examInfo.setQuestion_id(s);
                List result = new ArrayList<Integer>(1);
                result.add(examManageService.addExam(examInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
}
