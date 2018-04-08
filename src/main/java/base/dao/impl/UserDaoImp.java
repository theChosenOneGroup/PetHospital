package base.dao.impl;

import base.dao.UserDao;
import base.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-3-31
 */
@Repository
public class UserDaoImp extends BaseDaoImp<User> implements UserDao {

  private String namespace = "base.dao.UserDao";

  protected String namespace() {
    return namespace;
  }
}
