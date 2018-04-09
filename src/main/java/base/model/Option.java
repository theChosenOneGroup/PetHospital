package base.model;

/**
 * @author long
 * @since 18-4-9
 */
public class Option {
  private Long questionId;

  private Byte sequence;

  private String description;

  private Boolean valid;

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setSequence(Byte sequence) {
    this.sequence = sequence;
  }

  public Byte getSequence() {
    return sequence;
  }

  public void setValid(Boolean valid) {
    this.valid = valid;
  }

  public Boolean getValid() {
    return valid;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Long getQuestionId() {
    return questionId;
  }
}
