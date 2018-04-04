package base.model.response;

import java.util.Map;

/**
 * @author long
 * @since 18-3-4
 */
public class BaseWrapper implements ResponseWrapper {

  private int code;
  private Map<Object, Object> requestParams;

  public BaseWrapper(int code, Map<Object, Object> requestParams) {
    this.code = code;
    this.requestParams = requestParams;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public void setRequestParams(Map<Object, Object> requestParams) {

  }

  public Map<Object, Object> getRequestParams() {
    return requestParams;
  }

  public void addRequestParam(Object key, String value) {
    this.requestParams.put(key, value);
  }
}
