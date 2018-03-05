package base.model;

/**
 * @author long
 * @since 18-3-4
 */
public class UserStatus {

  private UserRole role;
  private boolean isIdentified;

  public void setIdentified(boolean identified) {
    isIdentified = identified;
  }

  public boolean isIdentified() {
    return isIdentified;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  public UserRole getRole() {
    return role;
  }
}
