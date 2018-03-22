package base.service;

import base.model.UserInfo;

public interface UserManageService {

  public UserInfo registerUser(UserInfo userInfo);
  public UserInfo fixpassword(UserInfo userInfo);

}
