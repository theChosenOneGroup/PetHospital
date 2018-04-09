package base.dao;

import base.model.Option;
import base.model.Question;
import java.util.List;

/**
 * @author long
 * @since 18-4-9
 */
public interface QuestionDao extends BaseDao<Question> {
  List<Option> optionOfQuestion(Question question);

  int addOption(Option option);

  int deleteOption(Option option);

  int deleteQuestion(Question question);

  Question retrieveQuestion(Question question);
}
