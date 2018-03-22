package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.VaccineInfo;
import base.model.response.ResponseWrapper;
import base.service.VaccineManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class VaccineManageController {

    private VaccineManageService vaccineManageService;
    private ResponsePacker responsePacker = new ResponsePacker();

    @Autowired
    public void setUserManageService(VaccineManageService vaccineManageService) {
        this.vaccineManageService = vaccineManageService;
    }

    @RequestMapping(value = "/vaccine/search", method = RequestMethod.POST)
    public ResponseWrapper vaccineSearch(@RequestBody VaccineInfo vaccineInfo){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<VaccineInfo>();
                result=vaccineManageService.searchVaccine(vaccineInfo);
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/vaccine/add", method = RequestMethod.POST)
    public ResponseWrapper addVaccine(@RequestBody VaccineInfo vaccineInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(vaccineManageService.addVaccine(vaccineInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/vaccine/delete", method = RequestMethod.POST)
    public ResponseWrapper delete(@RequestBody VaccineInfo vaccineInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(vaccineManageService.delete(vaccineInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/vaccine/update", method = RequestMethod.POST)
    public ResponseWrapper update(@RequestBody VaccineInfo vaccineInfo) {
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<Integer>(1);
                result.add(vaccineManageService.update(vaccineInfo));
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }

    @RequestMapping(value = "/vaccine/searchAll", method = RequestMethod.POST)
    public ResponseWrapper searchAll(){
        DataRequest dataRequest = new DataRequest() {
            @Override
            public List<?> execute(Map<String, Object> params) {
                List result = new ArrayList<VaccineInfo>();
                result=vaccineManageService.searchAll();
                return result;
            }
        };
        return responsePacker.pack(null, dataRequest);
    }
}
