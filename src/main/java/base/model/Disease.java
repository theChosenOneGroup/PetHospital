package base.model;

import java.sql.Timestamp;

/**
 * @author long
 * @since 18-4-7
 */
public class Disease {

  private Integer id;

  private String name;

  private String category;

  private Timestamp createTime;

  private Timestamp updateTime;

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

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setUpdateTime(Timestamp updateTime) {
    this.updateTime = updateTime;
  }

  public Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCategory() {
    return category;
  }
}
