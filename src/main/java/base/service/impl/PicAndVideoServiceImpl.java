package base.service.impl;

import base.dao.PicAndVideoDao;
import base.model.PicAndVideoInfo;
import base.service.PicAndVideoService;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

@Service
public class PicAndVideoServiceImpl implements PicAndVideoService {

  private final String ffmpgePath = "tools/ffmpeg.exe";
  @Autowired
  private PicAndVideoDao picAndVideoDao;

  public int saveVideo(PicAndVideoInfo picAndVideoInfo) {
    String srcPath = picAndVideoInfo.getPath();
    String dstPath = srcPath.substring(0, srcPath.lastIndexOf(".")) + ".flv";
    picAndVideoInfo = videoConverAndWaterMark(srcPath, dstPath);
    int num = picAndVideoDao.insert(picAndVideoInfo);
    return num;
  }

  public int savePicture(PicAndVideoInfo picAndVideoInfo){
    int num = picAndVideoDao.insert(picAndVideoInfo);
    return num;
  }

  public List<PicAndVideoInfo> select(String name) {
    List<PicAndVideoInfo> picAndVideoInfoList = picAndVideoDao.select(name);
    return picAndVideoInfoList;
  }

  public List<PicAndVideoInfo> selectAll() {
    List<PicAndVideoInfo> picAndVideoInfoList = picAndVideoDao.selectAll();
    return picAndVideoInfoList;
  }

  //格式转换为flv
  // path example:"F:/Repository/Intellij IDEA/ffmpeg/test.mp4"
  private PicAndVideoInfo videoConverAndWaterMark(String srcPath, String dstPath) {
    boolean boo = true;      //格式不需要转换，直接copy文件
    if (!srcPath.isEmpty() && !dstPath.isEmpty()) {
      srcPath = srcPath.trim().replaceAll("//", "/");
      dstPath = dstPath.trim().replaceAll("//", "/");
      String srcFormatName = srcPath.substring(srcPath.lastIndexOf('.') + 1, srcPath.length());
      String dstFormatName = dstPath.substring(srcPath.lastIndexOf('.') + 1, dstPath.length());

      if (srcFormatName.toUpperCase().equals("FLV")) {
        try {
          if (!srcPath.equals(dstPath)) {
            FileCopyUtils.copy(new File(srcPath), new File(dstPath));
          }
        } catch (IOException e) {
          boo = false;
        }
      } else {
        List<String> command = new ArrayList<String>();
        command.add(ffmpgePath);
        command.add("-y");
        command.add("-i");
        command.add(srcPath);
        command.add("-vf");
        command.add("\"movie= tools/waterMark.png[watermark];[in][watermark]overlay=10:10[out]\"");
        command.add("-r");
        command.add("60");
        command.add(dstPath);
        try {
          ProcessBuilder builder = new ProcessBuilder();
          builder.command(command);
          builder.redirectErrorStream(true);
          Process p = builder.start();
          p.waitFor();
          p.destroy();
          System.out.println("format convert successfully.");
        } catch (Exception e) {
          System.out.println("format conver failed.");
          return null;
        }
      }
      PicAndVideoInfo picAndVideoInfo = new PicAndVideoInfo();
      picAndVideoInfo.setType(PicAndVideoInfo.VIDEO);
      picAndVideoInfo.setPath(dstPath);
      return picAndVideoInfo;
    }
    System.out.println("path is empty.");
    return null;
  }

  public PicAndVideoInfo screenShot(String srcPath, double offset) {
    if (!srcPath.isEmpty()) {
      srcPath = srcPath.trim().replaceAll("//", "/");
      String dstPath = srcPath.substring(0, srcPath.lastIndexOf('.')) + ".jpg";
      StringBuilder sbPath = new StringBuilder(dstPath);
      int videoindex = sbPath.indexOf("video");
      dstPath = sbPath.replace(videoindex, videoindex+5,"picture").toString();

      List<String> command = new ArrayList<String>();
      command.add(ffmpgePath);
      command.add("-y");
      command.add("-i");
      command.add(srcPath);
      command.add("-f");
      command.add("image2");
      command.add("-ss");
      command.add(offset + "");
      command.add("-t");
      command.add("0.001");
      command.add(dstPath);
      try {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(command);
        Process p = builder.start();
        p.waitFor();
        p.destroy();
        System.out.println("video screenshot succeed.");

      } catch (Exception e) {
        System.out.println("video screenshot failed.");
        return null;
      }
      PicAndVideoInfo picAndVideoInfo = new PicAndVideoInfo();
      picAndVideoInfo.setType(PicAndVideoInfo.PICTURE);
      picAndVideoInfo.setPath(dstPath);
      savePicture(picAndVideoInfo);
      return picAndVideoInfo;
    }
    System.out.println("path is empty.");
    return null;
  }

}
