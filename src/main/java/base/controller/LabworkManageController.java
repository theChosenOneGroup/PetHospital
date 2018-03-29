package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.LabworkInfo;
import base.model.response.ResponseWrapper;
import base.service.LabworkManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class LabworkManageController {

    private LabworkManageService labworkManageService;
    private ResponsePacker responsePacker = new ResponsePacker();

    @Autowired
    public void setUserManageService(LabworkManageService labworkManageService) {
        this.labworkManageService = labworkManageService;
    }

    @RequestMapping(value = "/labwork/search", method = RequestMethod.POST)
    public ResponseWrapper labworkSearch(@RequestBody LabworkInfo labworkInfo){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<LabworkInfo>();
                result=labworkManageService.searchLabwork(labworkInfo);
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/labwork/add", method = RequestMethod.POST)
    public ResponseWrapper addLabwork(@RequestBody LabworkInfo labworkInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(labworkManageService.addLabwork(labworkInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/labwork/delete", method = RequestMethod.POST)
    public ResponseWrapper delete(@RequestBody LabworkInfo labworkInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(labworkManageService.delete(labworkInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/labwork/update", method = RequestMethod.POST)
    public ResponseWrapper update(@RequestBody LabworkInfo labworkInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(labworkManageService.update(labworkInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/labwork/searchAll", method = RequestMethod.POST)
    public ResponseWrapper searchAll(){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<LabworkInfo>();
                result=labworkManageService.searchAll();
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
}
