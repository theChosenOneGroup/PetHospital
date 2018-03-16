package base.service.impl;

import base.model.UserStatus;
import base.model.UserRole;

import base.service.UserIdentifyService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 * @author long
 * @since 18-3-4
 */
@Service
public class UserIdentifyServiceImpl implements UserIdentifyService {

  public UserStatus retrieveUserStatus(HttpServletRequest request) {
    UserStatus userStatus = new UserStatus();
    String user = request.getRemoteUser();
    if (user == null) {
      userStatus.setIdentified(false);
      return userStatus;
    }
    userStatus.setIdentified(true);

    //TODO a user may has multi roles
    if (request.isUserInRole(UserRole.ADMIN.toString())) {
      userStatus.setRole(UserRole.ADMIN);
    } else if (request.isUserInRole(UserRole.USER.toString())) {
      userStatus.setRole(UserRole.USER);
    }
    return userStatus;
  }
}
