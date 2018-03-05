package base.model.response;

import java.util.Map;

/**
 * @author long
 * @since 18-3-4
 */
public class BaseWrapper implements ResponseWrapper {

  private int code;
  private Map<String, Object> requestParams;

  public BaseWrapper(int code, Map<String, Object> requestParams) {
    this.code = code;
    this.requestParams = requestParams;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public void setRequestParams(Map<String, Object> requestParams) {

  }

  public Map<String, Object> getRequestParams() {
    return requestParams;
  }

  public void addRequestParam(String key, String value) {
    this.requestParams.put(key, value);
  }
}
