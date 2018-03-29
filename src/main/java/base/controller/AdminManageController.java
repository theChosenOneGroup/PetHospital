package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.UserInfo;
import base.model.response.ResponseWrapper;
import base.service.AdminManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class AdminManageController {

    private AdminManageService adminManageService;
    private ResponsePacker responsePacker = new ResponsePacker();

    @Autowired
    public void setUserManageService(AdminManageService adminManageService) {
        this.adminManageService = adminManageService;
    }

    @RequestMapping(value = "/admin/search", method = RequestMethod.POST)
    public ResponseWrapper search(@RequestBody UserInfo userInfo){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<UserInfo>();
                result=adminManageService.search(userInfo);
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ResponseWrapper add(@RequestBody UserInfo userInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(adminManageService.add(userInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ResponseWrapper delete(@RequestBody UserInfo userInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(adminManageService.delete(userInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ResponseWrapper update(@RequestBody UserInfo userInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(adminManageService.update(userInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/admin/searchAll", method = RequestMethod.POST)
    public ResponseWrapper searchAll(){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<UserInfo>();
                result=adminManageService.searchAll();
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
}
