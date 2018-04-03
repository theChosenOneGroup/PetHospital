package base.dao.impl;

import base.dao.PicAndVideoDao;
import base.model.PicAndVideoInfo;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PicAndVideoDaoImpl implements PicAndVideoDao {

  private SqlSessionFactory sqlSessionFactory;

  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  private String namespace = "com.pethospital.base.dao.PicAndVideoDao";

  public int insert(PicAndVideoInfo picAndVideoInfo) {
    String stat = namespace + ".insertPicAndVideo";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      int num = session.insert(stat, picAndVideoInfo);
      session.commit();
      return num;
    }
  }

  public List<PicAndVideoInfo> select(String name) {
    String stat = namespace + ".selectByName";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      List<PicAndVideoInfo> picAndVideoInfoList = session.selectList(stat, name);
      session.commit();
      return picAndVideoInfoList;
    }
  }

  public List<PicAndVideoInfo> selectAll() {
    String stat = namespace + ".selectAll";
    try (SqlSession session = sqlSessionFactory.openSession()) {
      List<PicAndVideoInfo> picAndVideoInfoList = session.selectList(stat);
      session.commit();
      return picAndVideoInfoList;
    }
  }
}
