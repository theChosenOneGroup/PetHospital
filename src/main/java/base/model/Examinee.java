package base.model;

/**
 * @author long
 * @since 18-4-9
 */
public class Examinee {
  private Long userId;

  private Long examId;

  private ExamineeStatus status;

  private Short score;

  public Examinee() {}

  public Examinee(Long examId, Long userId) {
    this.examId = examId;
    this.userId = userId;
  }

  public void setExamId(Long examId) {
    this.examId = examId;
  }

  public Long getExamId() {
    return examId;
  }

  public void setStatus(ExamineeStatus status) {
    this.status = status;
  }

  public ExamineeStatus getStatus() {
    return status;
  }

  public void setScore(Short score) {
    this.score = score;
  }

  public Short getScore() {
    return score;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getUserId() {
    return userId;
  }
}
