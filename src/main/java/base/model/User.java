package base.model;

import base.util.JsonUtil;

/**
 * @author long
 * @since 18-3-31
 */
public class User {

  private Long id;

  private String name;

  private String mail;

  private Role role;

  private String address;

  private Boolean valid;

  private String password;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getMail() {
    return mail;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Role getRole() {
    return role;
  }

  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  public Boolean isValid() {
    return valid;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return JsonUtil.stringify(this);
  }
}
