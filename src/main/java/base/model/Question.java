package base.model;

import java.util.List;

/**
 * @author long
 * @since 18-4-9
 */
public class Question {

  private Long id;

  private String description;

  private QuestionType type;

  private List<Option> options;

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setType(QuestionType type) {
    this.type = type;
  }

  public QuestionType getType() {
    return type;
  }

  public void setOptions(List<Option> options) {
    this.options = options;
  }

  public List<Option> getOptions() {
    return options;
  }
}
