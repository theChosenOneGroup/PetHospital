package base.dao.impl;

import base.dao.BaseDao;
import base.model.Option;
import base.model.Question;
import java.util.List;

/**
 * @author long
 * @since 18-4-9
 */
interface OptionDao extends BaseDao<Option> {
  List<Option> optionOfQuestion(Question question);
  int deleteQuestion(Question question);
}
