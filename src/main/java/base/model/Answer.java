package base.model;

/**
 * @author long
 * @since 18-4-9
 */
public class Answer {
  private Long userId;

  private Long examId;

  private Long questionId;

  private Byte sequence;

  private String phrase;

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setExamId(Long examId) {
    this.examId = examId;
  }

  public Long getExamId() {
    return examId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setSequence(Byte sequence) {
    this.sequence = sequence;
  }

  public Byte getSequence() {
    return sequence;
  }

  public void setPhrase(String phrase) {
    this.phrase = phrase;
  }

  public String getPhrase() {
    return phrase;
  }
}
