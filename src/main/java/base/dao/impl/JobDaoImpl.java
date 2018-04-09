package base.dao.impl;

import base.dao.JobDao;
import base.model.Job;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-8
 */
@Repository
public class JobDaoImpl extends BaseDaoImp<Job> implements JobDao {

  @Override
  protected String namespace() {
    return "base.dao.JobDao";
  }

  public List<Job> jobOfPosition(Job job) {
    return (List<Job>)
        execute((session) -> session.selectList(namespace() + ".jobOfPosition", job));
  }
}
