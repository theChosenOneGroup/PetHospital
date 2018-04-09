package base.model;

import java.util.Random;

/**
 * @author long
 * @since 18-4-8
 */
public class Job{

  private static int range=1000;

  private Long id;

  private String name;

  private String description;

  private Position position;

  private Long createdTime;

  private Short rand;

  public void setRand(Short rand) {
    this.rand = rand;
  }

  public Short getRand() {
    return rand;
  }

  public Long getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Long createdTime) {
    this.createdTime = createdTime;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Position getPosition() {
    return position;
  }

  public void flip() {
    id = id + new Random().nextInt(range);
  }
}
