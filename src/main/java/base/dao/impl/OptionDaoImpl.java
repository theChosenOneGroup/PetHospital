package base.dao.impl;

import base.model.Option;
import base.model.Page;
import base.model.Question;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-9
 */
@Repository
public class OptionDaoImpl extends BaseDaoImp<Option> implements OptionDao {

  public String namespace() {
    return "base.dao.OptionDao";
  }

  public List<Option> optionOfQuestion(Question question) {
    return (List<Option>)
        execute((session) -> session.selectList(namespace() + ".optionOfQuestion", question));
  }

  public int deleteQuestion(Question question) {
    return (int) execute((session) -> session.delete(namespace() + ".deleteQuestion", question));
  }

  @Override
  public List<Option> retrieve(Page page) {
    throw new UnsupportedOperationException();
  }

  @Override
  public long count() {
    throw new UnsupportedOperationException();
  }

  @Override
  public int update(Option option) {
    throw new UnsupportedOperationException();
  }
}
