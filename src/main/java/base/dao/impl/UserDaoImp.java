package base.dao.impl;

import base.dao.UserDao;
import base.model.Page;
import base.model.User;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-3-31
 */
@Repository
public class UserDaoImp extends BaseDaoImp<User> implements UserDao {

  private String namespace = "base.dao.UserDao";

  public List<User> retrieve(Page page) {
    return (List<User>) execute((session) -> session.selectList(namespace + ".retrieve", page));
  }

  public int update(User user) {
    return (int) execute((session) -> session.update(namespace + ".update", user));
  }

  public int delete(User user) {
    return (int) execute((session) -> session.delete(namespace + ".delete", user.getId()));
  }

  public int create(User user) {
    return (int) execute((session) -> session.delete(namespace + ".create", user));
  }

  public long count() {
    return (long) execute((session) -> session.selectOne(namespace + ".count"));
  }
}
