package base.service.impl;

import base.dao.UserDao;
import base.model.UserInfo;
import base.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManageServiceImpl implements UserManageService {

  @Autowired
  private UserDao userDao;

  public UserInfo registerUser(UserInfo userInfo) {
    userDao.insert(userInfo);
    return userInfo;
  }

}
