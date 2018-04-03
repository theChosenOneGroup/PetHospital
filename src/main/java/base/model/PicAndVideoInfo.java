package base.model;

public class PicAndVideoInfo {

  public static final int PICTURE = 0;
  public static final int VIDEO = 1;

  private int id = 0;
  private int type;
  private String path;

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
