package base.model.response;

import java.util.Map;

/**
 * @author long
 * @since 18-3-4
 */
public interface ResponseWrapper {

  public int getCode();
  public Map<Object,Object> getRequestParams();
}
