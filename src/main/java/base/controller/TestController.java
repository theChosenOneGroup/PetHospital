package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.dao.TestService;
import base.model.response.ResponseWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author long
 * @since 18-3-8
 */
@RestController
public class TestController {

  private TestService testService;
  private ResponsePacker responsePacker = new ResponsePacker();

  @Autowired
  public void setTestService(TestService testService) {
    this.testService = testService;
  }

  @RequestMapping("/dao/test")
  public ResponseWrapper test(Integer id) {
    DataRequest request = new DataRequest() {
      @Override
      public List<?> execute() {
        List<Integer> result = new ArrayList<>(1);
        result.add(testService.test(id));
        return result;
      }
    };
    return responsePacker.pack(null, request);
  }
}
