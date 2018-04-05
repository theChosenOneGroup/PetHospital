package base.dao;

import base.model.Page;
import java.util.List;

/**
 * @author long
 * @since 18-4-4
 */
public interface BaseDao<T> {

  int create(T obj);

  int delete(T obj);

  List<T> retrieve(Page obj);

  int update(T object);

  long count();
}
