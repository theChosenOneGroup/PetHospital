package base.controller;

import base.dao.ExamDao;
import base.model.Exam;
import base.model.Page;
import base.model.Question;
import base.model.User;
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
public class ExamController extends BaseController{

  private ExamDao examDao;

  @Autowired
  public void setExamDao(ExamDao examDao) {
    this.examDao = examDao;
  }

  @PostMapping("/exam")
  public ResponseWrapper create(@RequestBody Exam exam) {
    return responsePacker.pack(
        JsonUtil.toMap(exam),
        () -> {
          exam.setId(new Date().getTime());
          if (0 == examDao.create(exam)) {
            throw new RuntimeException("Creation is failed");
          }
          List<Exam> result = new ArrayList<>(1);
          result.add(exam);
          return result;
        });
  }

  @DeleteMapping("/exam/{examId}")
  public ResponseWrapper delete(@PathVariable Long examId) {
    return messagePacker.pack(
        null,
        () -> {
          Exam exam = new Exam();
          exam.setId(examId);
          if (0 == examDao.delete(exam)) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }

  @PutMapping("/exam")
  public ResponseWrapper update(@RequestBody Exam exam) {
    return messagePacker.pack(
        JsonUtil.toMap(exam),
        () -> {
          if (0 == examDao.update(exam)) {
            throw new RuntimeException("Update is failed");
          }
          return null;
        });
  }

  @GetMapping("/exam")
  public ResponseWrapper retrieve(@RequestParam Integer page, @RequestParam Integer pageSize) {
    return responsePacker.pack(
        JsonUtil.toMap("page", page, "pageSize", pageSize),
        () -> examDao.retrieve(new Page(page, pageSize)));
  }

  @GetMapping("/exam/count")
  public ResponseWrapper count() {
    return responsePacker.pack(
        null,
        () -> {
          List<Long> result = new ArrayList<>(1);
          result.add(examDao.count());
          return result;
        });
  }

  @GetMapping("/exam/questionnaire/{examId}")
  public ResponseWrapper questionnaire(@PathVariable Long examId) {
    return responsePacker.pack(
        null,
        () -> {
          Exam exam = new Exam();
          exam.setId(examId);
          return examDao.questionnaireOf(exam);
        });
  }

  @DeleteMapping("/exam/questionnaire/{examId}")
  public ResponseWrapper deleteQuestionnaire(@PathVariable Long examId) {
    return responsePacker.pack(
        null,
        () -> {
          Exam exam = new Exam();
          exam.setId(examId);
          if (0 == examDao.deleteQuestionnaire(exam)) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }

  @PostMapping("/exam/questionnaire/{examId}")
  public ResponseWrapper addQuestion(@PathVariable Long examId, @RequestBody Question question) {
    return messagePacker.pack(
        JsonUtil.toMap(question),
        () -> {
          Exam exam = new Exam();
          exam.setId(examId);
          if (0 == examDao.addQuestion(exam, question)) {
            throw new RuntimeException("Creation is failed");
          }
          return null;
        });
  }

  @DeleteMapping("/exam/questionnaire/{examId}/{questionId}")
  public ResponseWrapper deleteQuestion(@PathVariable Long examId, @PathVariable Long questionId) {
    return messagePacker.pack(
        null,
        () -> {
          Exam exam = new Exam();
          exam.setId(examId);
          Question question = new Question();
          question.setId(questionId);
          if (0 == examDao.deleteQuestion(exam, question)) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }

  @PostMapping("/exam/examinee/{examId}")
  public ResponseWrapper addExaminee(@PathVariable Long examId, @RequestBody User user) {
    return messagePacker.pack(
        JsonUtil.toMap(user),
        () -> {
          Exam exam = new Exam();
          exam.setId(examId);
          if (0 == examDao.addExaminee(exam, user)) {
            throw new RuntimeException("Creation is failed");
          }
          return null;
        });
  }

  @DeleteMapping("/exam/examinee/{examId}/{userId}")
  public ResponseWrapper deleteExaminee(@PathVariable Long examId, @PathVariable Long userId) {
    return messagePacker.pack(
        null,
        () -> {
          Exam exam = new Exam();
          exam.setId(examId);
          User user = new User();
          user.setId(userId);
          if (0 == examDao.deleteExaminee(exam, user)) {
            throw new RuntimeException("Deletion is failed");
          }
          return null;
        });
  }
}
