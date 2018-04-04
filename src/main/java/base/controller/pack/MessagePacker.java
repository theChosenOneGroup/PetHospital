package base.controller.pack;

import base.model.response.MessageWrapper;
import base.model.response.ResponseWrapper;
import base.model.response.StatusCode;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author long
 * @since 18-4-2
 */
@Component
public class MessagePacker extends ResponsePacker {

  @Override
  public ResponseWrapper pack(Map<Object, Object> paras, DataRequest task) {
    try {
      task.execute();
    } catch (Exception e) {
      return new MessageWrapper(StatusCode.ERROR, paras, e.getMessage());
    }
    return new MessageWrapper(StatusCode.SUCCESS, paras, null);
  }
}
