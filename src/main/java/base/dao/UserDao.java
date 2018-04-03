package base.dao;

import base.model.Page;
import base.model.User;
import java.util.List;

/**
 * @author long
 * @since 18-3-31
 */
public interface UserDao {

  int update(User user);

  int create(User user);

  int delete(Long id);

  List<User> retrieve(Page page);

  long count();
}
