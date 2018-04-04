package base.dao;

import base.model.Page;
import java.util.List;

/**
 * @author long
 * @since 18-4-4
 */
public interface BaseDao<T> {

  public int create(T obj);

  public int delete(T obj);

  public List<T> retrieve(Page obj);

  public int update(T object);

  public long count();
}
