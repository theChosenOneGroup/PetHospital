package base.model;

import java.util.Date;
import java.util.Random;

/**
 * @author long
 * @since 18-4-4
 */
public class Article {

  private static int range = 1000;

  private Long createdTime;

  private int rand;

  private String description;

  public Article() {
  }

  public Article(Long createdTime, Integer rand, String description) {
    this.createdTime = createdTime;
    this.rand = rand;
    this.description = description;
  }

  public Article(String description) {
    this.description = description;
    this.createdTime = new Date().getTime();
    this.rand = new Random().nextInt(range);
  }

  public Long getCreatedTime() {
    return createdTime;
  }

  public String getDescription() {
    return description;
  }

  public int getRand() {
    return rand;
  }

  public void flip() {
    rand = new Random().nextInt(range);
  }

  public void setCreatedTime(Long createdTime) {
    this.createdTime = createdTime;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRand(Integer rand) {
    this.rand = rand;
  }
}