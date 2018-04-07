package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.CaseInfo;
import base.model.response.ResponseWrapper;
import base.service.CaseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CaseManageController {

    private CaseManageService caseManageService;
    private ResponsePacker responsePacker = new ResponsePacker();

    @Autowired
    public void setCaseManageService(CaseManageService caseManageService) {
        this.caseManageService = caseManageService;
    }

    @RequestMapping(value = "/case/search", method = RequestMethod.POST)
    public ResponseWrapper search(@RequestBody CaseInfo caseInfo){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<CaseInfo>();
                result=caseManageService.search(caseInfo);
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/case/add", method = RequestMethod.POST)
    public ResponseWrapper add(@RequestBody CaseInfo caseInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(caseManageService.add(caseInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/case/delete", method = RequestMethod.POST)
    public ResponseWrapper delete(@RequestBody CaseInfo caseInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(caseManageService.delete(caseInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/case/update", method = RequestMethod.POST)
    public ResponseWrapper update(@RequestBody CaseInfo caseInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(caseManageService.update(caseInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/case/searchAll", method = RequestMethod.POST)
    public ResponseWrapper searchAll(){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<CaseInfo>();
                result=caseManageService.searchAll();
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/case/cost", method = RequestMethod.POST)
    public ResponseWrapper getCost(@RequestBody CaseInfo caseInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List list = new ArrayList<String>();
                String result = caseManageService.getCost(caseInfo);
                list.add(result);
                return list;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
}
