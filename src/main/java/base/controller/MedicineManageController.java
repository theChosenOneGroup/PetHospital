package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.MedicineInfo;
import base.model.response.ResponseWrapper;
import base.service.MedicineManageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicineManageController {

  private MedicineManageService medicineManageService;
  private ResponsePacker responsePacker = new ResponsePacker();

  @Autowired
  public MedicineManageService getMedicineManageService(
      MedicineManageService medicineManageService) {
    return this.medicineManageService = medicineManageService;
  }

  @RequestMapping(value = "medicine/add", method = RequestMethod.POST)
  public ResponseWrapper addMedicine(@RequestBody MedicineInfo medicine) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<Integer>(1);
        result.add(medicineManageService.addMedicine(medicine));
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }

  @RequestMapping(value = "medicine/delete", method = RequestMethod.POST)
  public ResponseWrapper deleteMedicine(@RequestBody MedicineInfo medicine) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<Integer>(1);
        result.add(medicineManageService.deleteMedicine(medicine));
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }

  @RequestMapping(value = "medicine/update", method = RequestMethod.POST)
  public ResponseWrapper updateMedicine(@RequestBody MedicineInfo medicine) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<Integer>(1);
        result.add(medicineManageService.updateMedicine(medicine));
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }

  @RequestMapping(value = "medicine/search", method = RequestMethod.POST)
  public ResponseWrapper searchMedicine(@RequestBody MedicineInfo medicine) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<MedicineInfo>();
        result = medicineManageService.searchMedicine(medicine);
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }

  @RequestMapping(value = "medicine/searchAll", method = RequestMethod.GET)
  public ResponseWrapper searchAllMedicine() {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<MedicineInfo>();
        result = medicineManageService.searchAllMedicine();
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }
}
