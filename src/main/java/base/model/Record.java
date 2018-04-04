package base.model;

import java.util.Random;

/**
 * @author long
 * @since 18-4-4
 */
public class Record {

  private static int range = 1000;
  private Long createdTime;
  private Integer rand;
  private Integer sequence;
  private String description;
  private String contentType;

  public Record(Long createdTime, Integer rand, Integer sequence, String contentType,
      String description) {
    this.createdTime = createdTime;
    this.rand = rand;
    this.sequence = sequence;
    this.contentType = contentType;
    this.description = description;
  }

  public Record(Long createdTime, Integer rand, String contentType, String description) {
    this.createdTime = createdTime;
    this.rand = rand;
    this.sequence = new Random().nextInt(range);
    this.contentType = contentType;
    this.description = description;
  }

  public Record(Article article, String contentType, String description) {
    this.createdTime = article.getCreatedTime();
    this.rand = article.getRand();
    this.sequence = new Random().nextInt(range);
    this.description = description;
    this.contentType = contentType;
  }

  public Long getCreatedTime() {
    return createdTime;
  }

  public Integer getRand() {
    return rand;
  }

  public int getSequence() {
    return sequence;
  }

  public String getDescription() {
    return description;
  }

  public String getContentType() {
    return contentType;
  }

  public void flip() {
    sequence = new Random().nextInt(range);
  }
}
