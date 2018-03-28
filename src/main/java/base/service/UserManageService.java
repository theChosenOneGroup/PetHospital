<<<<<<< HEAD
package base.service;

import base.model.UserInfo;

public interface UserManageService {


  public UserInfo fixpassword(UserInfo userInfo);
  public int registerUser(UserInfo userInfo);

}
=======
package base.service;

import base.model.UserInfo;

public interface UserManageService {

  boolean userLogin(UserInfo userInfo);
  public int registerUser(UserInfo userInfo);

  public UserInfo fixpassword(UserInfo userInfo);

}
>>>>>>> temp1
