package base.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author long
 * @since 18-4-9
 */
public class Exam {

  private Long id;

  private String title;

  private Timestamp start;

  private Timestamp end;

  private Integer length;

  private List<Question> questions;

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setEnd(Timestamp end) {
    this.end = end;
  }

  public Timestamp getEnd() {
    return end;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public Integer getLength() {
    return length;
  }

  public void setStart(Timestamp start) {
    this.start = start;
  }

  public Timestamp getStart() {
    return start;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  public List<Question> getQuestions() {
    return questions;
  }
}
