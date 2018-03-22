package base.service;

import base.model.UserInfo;

public interface UserManageService {


  public UserInfo fixpassword(UserInfo userInfo);
  public int registerUser(UserInfo userInfo);

}
