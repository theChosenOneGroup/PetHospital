package base.service;

import base.model.UserStatus;
import javax.servlet.http.HttpServletRequest;

/**
 * @author long
 * @since 18-3-4
 */
public interface UserIdentifyService {

  UserStatus retrieveUserStatus(HttpServletRequest request);
}
