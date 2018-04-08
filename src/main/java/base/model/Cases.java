package base.model;

/**
 * @author long
 * @since 18-4-7
 */
public class Cases {

  private Integer diseaseId;

  private Long createdTime;

  private Integer rand;

  public Cases() {}

  public Cases(Integer diseaseId, Long createdTime, Integer rand) {
    this.diseaseId = diseaseId;
    this.createdTime = createdTime;
    this.rand = rand;
  }

  public void setCreatedTime(Long createdTime) {
    this.createdTime = createdTime;
  }

  public Long getCreatedTime() {
    return createdTime;
  }

  public void setRand(Integer rand) {
    this.rand = rand;
  }

  public Integer getRand() {
    return rand;
  }

  public void setDiseaseId(Integer diseaseId) {
    this.diseaseId = diseaseId;
  }

  public Integer getDiseaseId() {
    return diseaseId;
  }
}
