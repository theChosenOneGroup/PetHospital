package base.model;

import java.sql.Timestamp;

/**
 * @author long
 * @since 18-4-7
 */
public class Department {

  private Short id;

  private String name;

  private Timestamp createTime;

  private Timestamp updateTime;

  private String category;

  public void setCreateTime(Timestamp createTime) {
    this.createTime = createTime;
  }

  public Timestamp getCreateTime() {
    return createTime;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setId(Short id) {
    this.id = id;
  }

  public Short getId() {
    return id;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }
}
