package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.OfficeInfo;
import base.model.response.ResponseWrapper;
import base.service.OfficeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OfficeManageController {

    private OfficeManageService officeManageService;
    private ResponsePacker responsePacker = new ResponsePacker();

    @Autowired
    public void setOfficeManageService(OfficeManageService officeManageService) {
        this.officeManageService = officeManageService;
    }

    @RequestMapping(value = "/office/search", method = RequestMethod.POST)
    public ResponseWrapper search(@RequestBody OfficeInfo officeInfo){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<OfficeInfo>();
                result=officeManageService.search(officeInfo);
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/office/add", method = RequestMethod.POST)
    public ResponseWrapper add(@RequestBody OfficeInfo officeInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(officeManageService.add(officeInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/office/delete", method = RequestMethod.POST)
    public ResponseWrapper delete(@RequestBody OfficeInfo officeInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(officeManageService.delete(officeInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/office/update", method = RequestMethod.POST)
    public ResponseWrapper update(@RequestBody OfficeInfo officeInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(officeManageService.update(officeInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/office/searchAll", method = RequestMethod.POST)
    public ResponseWrapper searchAll(){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<OfficeInfo>();
                result=officeManageService.searchAll();
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
}
