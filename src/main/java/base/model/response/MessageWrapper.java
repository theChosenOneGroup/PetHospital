package base.model.response;

import java.util.Map;

/**
 * @author long
 * @since 18-3-4
 */
public class MessageWrapper extends BaseWrapper {

  private String message;

  public MessageWrapper(int code, Map<String, Object> paras, String message) {
    super(code, paras);
    this.message = message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
