package base.controller;

import base.model.UserStatus;
import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.response.ResponseWrapper;
import base.service.UserIdentifyService;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author long
 * @since 18-3-4
 */
@RestController
public class UserIdentifyController {

  private UserIdentifyService userIdentifyService;
  private ResponsePacker responsePacker = new ResponsePacker();

  @Autowired
  public void setUserIdentifyService(UserIdentifyService identifyService) {
    this.userIdentifyService = identifyService;
  }

  @RequestMapping(value = "/identify", method = RequestMethod.GET)
  public ResponseWrapper identifyUser(HttpServletRequest request) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute() {
        List result = new ArrayList<UserStatus>(1);
        result.add(userIdentifyService.retrieveUserStatus(request));
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }
}
