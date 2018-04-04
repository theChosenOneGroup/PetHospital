package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.MessagePacker;
import base.controller.pack.ResponsePacker;
import base.dao.UserDao;
import base.model.Page;
import base.model.User;
import base.model.response.ResponseWrapper;
import base.util.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author long
 * @since 18-3-31
 */
@RestController
public class UserController {

  private static Logger logger = LoggerFactory.getLogger(UserController.class);

  private UserDao userDao;

  private ResponsePacker packer;

  private MessagePacker messagePacker;

  @Autowired
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  @Autowired
  public void setPacker(ResponsePacker packer) {
    this.packer = packer;
  }

  @Autowired
  public void setMessagePacker(MessagePacker messagePacker) {
    this.messagePacker = messagePacker;
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseWrapper retrieveUser(@RequestParam Integer page,
      @RequestParam Integer pageSize) {
    Page range = new Page(page, pageSize);
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute() {
        return userDao.retrieve(range);
      }
    };
    return packer.pack(JsonUtil.toMap("page", page, "pageSize", pageSize),
        dataRequest);
  }

  @RequestMapping(value = "/user", method = RequestMethod.PUT)
  public ResponseWrapper updateUser(@RequestBody User user) {
    DataRequest request = new DataRequest() {
      @Override
      public List<?> execute() {
        if (userDao.update(user) == 0) {
          throw new RuntimeException("Update is failed");
        }
        return null;
      }
    };
    return messagePacker.pack(JsonUtil.toMap(user), request);
  }

  @RequestMapping(value = "/user", method = RequestMethod.DELETE)
  public ResponseWrapper deleteUser(@RequestParam Long id) {
    DataRequest request = new DataRequest() {
      @Override
      public List<?> execute() {
        if (userDao.delete(id) == 0) {
          throw new RuntimeException("Deletion is failed");
        }
        return null;
      }
    };
    return messagePacker.pack(JsonUtil.toMap("id", id), request);
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public ResponseWrapper createUser(@RequestBody User user) {
    DataRequest request = new DataRequest() {
      @Override
      public List<?> execute() {
        if (userDao.create(user) == 0) {
          throw new RuntimeException("Create user is failed");
        }
        return null;
      }
    };
    return messagePacker.pack(JsonUtil.toMap(user), request);
  }


  @RequestMapping(value = "/user/count", method = RequestMethod.GET)
  public ResponseWrapper count() {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute() {
        List<Long> list = new ArrayList<>(1);
        list.add(userDao.count());
        return list;
      }
    };
    return packer.pack(null, dataRequest);
  }
}
