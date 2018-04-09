package base.model;

/**
 * @author long
 * @since 18-4-9
 */
public class Questionnaire {
  private Long examId;

  private Long questionId;

  public Questionnaire() {}

  public Questionnaire(Long examId, Long questionId) {
    this.examId = examId;
    this.questionId = questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setExamId(Long examId) {
    this.examId = examId;
  }

  public Long getExamId() {
    return examId;
  }
}
