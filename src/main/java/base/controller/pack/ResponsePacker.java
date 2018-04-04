package base.controller.pack;

import base.model.response.MessageWrapper;
import base.model.response.ResponseWrapper;
import base.model.response.ResultWrapper;
import base.model.response.StatusCode;
import java.util.List;
import java.util.Map;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author long
 * @since 18-3-4
 */
@Component
@Primary
public class ResponsePacker {

  public ResponseWrapper pack(Map<Object, Object> paras, DataRequest task) {
    List<?> result;
    try {
      result = task.execute();
    } catch (Exception e) {

      //TODO handle exception
      return new MessageWrapper(StatusCode.ERROR, paras, e.getMessage());
    }
    //TODO handle successful request
    return new ResultWrapper(StatusCode.SUCCESS, paras, result);
  }

}
