package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.ExamInfo;
import base.model.response.ResponseWrapper;
import base.service.ExamManageService;
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

    private ExamManageService examManageService;
    private ResponsePacker responsePacker = new ResponsePacker();

    @Autowired
    public void setUserManageService(ExamManageService examManageService) {
        this.examManageService = examManageService;
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
}
