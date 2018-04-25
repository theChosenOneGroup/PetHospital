package base.service;

import base.model.PicAndVideoInfo;
import java.util.List;

public interface PicAndVideoService {

  public  int saveVideo(PicAndVideoInfo picAndVideoInfo);

  public  int savePicture(PicAndVideoInfo picAndVideoInfo);

  public List<PicAndVideoInfo> select(String name);

  public List<PicAndVideoInfo> selectAll();

  public PicAndVideoInfo screenShot(String srcPath, double offset);
}
