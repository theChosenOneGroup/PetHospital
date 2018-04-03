package base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

/**
 * @author long
 * @since 18-3-31
 */
public class JsonUtil {

  private static ObjectMapper objectMapper = new ObjectMapper();

  public static String stringify(Object obj) {
    try {
      return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      return null;
    }
  }

  public static Map<String, Object> toMap(Object obj) {
    return objectMapper.convertValue(obj, Map.class);
  }

  public static Map<String, Object> toMap(String key, String value, String... pairs) {
    assert pairs.length % 2 == 0;
    Map<String, Object> map = new HashMap<>(pairs.length / 2 + 1);
    map.put(key, value);
    for (int i = 1; i < pairs.length; i += 2) {
      map.put(pairs[i - 1], pairs[i]);
    }
    return map;
  }

}
