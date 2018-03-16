package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.UserInfo;
import base.model.UserStatus;
import base.model.response.ResponseWrapper;
import base.service.UserManageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManageController {

  private UserManageService userManageService;
  private ResponsePacker responsePacker = new ResponsePacker();

  @Autowired
  public void setUserManageService(UserManageService userManageService) {
    this.userManageService = userManageService;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public ResponseWrapper registerUser(@RequestBody UserInfo userInfo) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<UserStatus>(1);
        result.add(userManageService.registerUser(userInfo));
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }
}
