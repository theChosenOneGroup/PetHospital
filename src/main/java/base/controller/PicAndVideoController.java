package base.controller;

import base.controller.pack.DataRequest;
import base.controller.pack.ResponsePacker;
import base.model.PicAndVideoInfo;
import base.model.response.ResponseWrapper;
import base.service.PicAndVideoService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/picnvideo")
public class PicAndVideoController {

  private PicAndVideoService picAndVideoService;
  private ResponsePacker responsePacker = new ResponsePacker();

  @Autowired
  public void setPicAndVideoService(PicAndVideoService picAndVideoService) {
    this.picAndVideoService = picAndVideoService;
  }

  @RequestMapping(value = "/addVideo", method = RequestMethod.POST)
  public ResponseWrapper addVideo(@RequestBody PicAndVideoInfo picAndVideoInfo) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<Integer>(1);
        result.add(picAndVideoService.saveVideo(picAndVideoInfo));
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }

  @RequestMapping(value = "/addPicture", method = RequestMethod.POST)
  public ResponseWrapper addPicture(@RequestBody PicAndVideoInfo picAndVideoInfo) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<Integer>(1);
        result.add(picAndVideoService.savePicture(picAndVideoInfo));
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }

  @RequestMapping(value = "/select", method = RequestMethod.GET)
  public ResponseWrapper selectPicOrVideo(
      @RequestParam(value = "name", required = false) String name) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<PicAndVideoInfo>(1);
        if (name == null) {
          result.add(picAndVideoService.selectAll());
        } else {
          result.add(picAndVideoService.select(name));
        }
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }

  @RequestMapping(value = "screenShot", method = RequestMethod.GET)
  public ResponseWrapper screenShotPic(
      @RequestParam(value = "path", required = true) String srcPath,
      @RequestParam(value = "offset") double offset) {
    DataRequest dataRequest = new DataRequest() {
      @Override
      public List<?> execute(Map<String, Object> params) {
        List result = new ArrayList<PicAndVideoInfo>(1);
        result.add(picAndVideoService.screenShot(srcPath, offset));
        return result;
      }
    };
    return responsePacker.pack(null, dataRequest);
  }

}
