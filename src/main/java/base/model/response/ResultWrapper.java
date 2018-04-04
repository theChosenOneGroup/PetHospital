package base.model.response;

import java.util.List;
import java.util.Map;

/**
 * @author long
 * @since 18-3-4
 */
public class ResultWrapper extends BaseWrapper {

  private List<?> result;

  public ResultWrapper(int code, Map<Object, Object> paras, List<?> result) {
    super(code, paras);
    this.result = result;
  }

  public void setResult(List<?> result) {
    this.result = result;
  }

  public List<?> getResult() {
    return result;
  }
}
