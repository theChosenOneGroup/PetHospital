package base.controller;

import base.controller.pack.MessagePacker;
import base.controller.pack.ResponsePacker;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author long
 * @since 18-4-4
 */
public class BaseController {

  protected ResponsePacker responsePacker;
  protected MessagePacker messagePacker;

  @Autowired
  public void setResponsePacker(ResponsePacker responsePacker) {
    this.responsePacker = responsePacker;
  }

  @Autowired
  public void setMessagePacker(MessagePacker messagePacker) {
    this.messagePacker = messagePacker;
  }
}
