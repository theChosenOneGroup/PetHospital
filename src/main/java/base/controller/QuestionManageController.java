package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.QuestionInfo;
import base.model.response.ResponseWrapper;
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
public class QuestionManageController {

    private QuestionManageService questionManageService;
    private ResponsePacker responsePacker = new ResponsePacker();

    @Autowired
    public void setUserManageService(QuestionManageService questionManageService) {
        this.questionManageService = questionManageService;
    }

    @RequestMapping(value = "/question/search", method = RequestMethod.POST)
    public ResponseWrapper questionSearch(@RequestBody QuestionInfo questionInfo){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<QuestionInfo>();
                result=questionManageService.searchQuestion(questionInfo);
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/question/add", method = RequestMethod.POST)
    public ResponseWrapper addQuestion(@RequestBody QuestionInfo questionInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(questionManageService.addQuestion(questionInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/question/delete", method = RequestMethod.POST)
    public ResponseWrapper delete(@RequestBody QuestionInfo questionInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(questionManageService.delete(questionInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/question/update", method = RequestMethod.POST)
    public ResponseWrapper update(@RequestBody QuestionInfo questionInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(questionManageService.update(questionInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/question/searchAll", method = RequestMethod.POST)
    public ResponseWrapper searchAll(){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<QuestionInfo>();
                result=questionManageService.searchAll();
                return result;
            }
        };

        return responsePacker.pack(null, dataRequest);
    }
    @RequestMapping(value = "/question/searchFromAll", method = RequestMethod.POST)
    public ResponseWrapper searchFromAll() {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<QuestionInfo>();
                result = questionManageService.searchFromAll();
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
    @RequestMapping(value = "/question/searchByType", method = RequestMethod.POST)
    public ResponseWrapper searchQuestionByType(@RequestBody QuestionInfo questionInfo){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<QuestionInfo>();
                result=questionManageService.searchQuestionByType(questionInfo);
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
}
