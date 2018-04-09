package base.controller;

import base.dao.QuestionDao;
import base.model.Option;
import base.model.Page;
import base.model.Question;
import base.model.response.ResponseWrapper;
import base.util.JsonUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author long
 * @since 18-4-9
 */
@RestController
public class QuestionController extends BaseController {

  private QuestionDao questionDao;

  @Autowired
  public void setQuestionDao(QuestionDao questionDao) {
    this.questionDao = questionDao;
  }

  @GetMapping("/question")
  public ResponseWrapper retrieve(@RequestParam Integer page, @RequestParam Integer pageSize) {
    return responsePacker.pack(
        JsonUtil.toMap("page", page, "pageSize", pageSize),
        () -> questionDao.retrieve(new Page(page, pageSize)));
  }

  @GetMapping("/question/{questionId}")
  public ResponseWrapper optionOfQuestion(@PathVariable Long questionId) {
    return responsePacker.pack(
        null,
        () -> {
          Question question = new Question();
          question.setId(questionId);
          return questionDao.optionOfQuestion(question);
        });
  }

  @PutMapping("/question")
  public ResponseWrapper update(@RequestBody Question question) {
    return messagePacker.pack(
        JsonUtil.toMap(question),
        () -> {
          if (0 == questionDao.update(question)) {
            throw new RuntimeException("Update is failed");
          }
          return null;
        });
  }

  @PostMapping("/question")
  public ResponseWrapper create(@RequestBody Question question) {
    return responsePacker.pack(
        JsonUtil.toMap(question),
        () -> {
          question.setId(new Date().getTime());
          if (0 == questionDao.create(question)) {
            throw new RuntimeException("Creation is failed");
          }
          List<Question> result = new ArrayList<>(1);
          result.add(question);
          return result;
        });
  }

  @PostMapping("/question/{questionId}")
  public ResponseWrapper addOption(@PathVariable Long questionId, @RequestBody Option option) {
    return messagePacker.pack(
        JsonUtil.toMap(option),
        () -> {
          option.setQuestionId(questionId);
          if (0 == questionDao.addOption(option)) {
            throw new RuntimeException("Addition is failed");
          }
          return null;
        });
  }

  @DeleteMapping("/question/{questionId}/{sequence}")
  public ResponseWrapper deleteQuestionOption(
      @PathVariable Long questionId, @PathVariable Byte sequence) {
    return messagePacker.pack(
        null,
        () -> {
          Option option = new Option();
          option.setQuestionId(questionId);
          option.setSequence(sequence);
          if (0 == questionDao.deleteOption(option)) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }

  @DeleteMapping("/question/{questionId}")
  public ResponseWrapper delete(@PathVariable Long questionId) {
    return messagePacker.pack(
        null,
        () -> {
          Question question = new Question();
          question.setId(questionId);
          if (0 == questionDao.delete(question)) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }
}
