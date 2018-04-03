package base.dao;

import base.model.PicAndVideoInfo;
import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;

public interface PicAndVideoDao {

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);

  public int insert(PicAndVideoInfo picAndVideoInfo);

  public List<PicAndVideoInfo> select(String name);

  public List<PicAndVideoInfo> selectAll();

}
