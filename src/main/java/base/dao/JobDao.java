package base.dao;

import base.model.Job;
import java.util.List;

/**
 * @author long
 * @since 18-4-8
 */
public interface JobDao extends BaseDao<Job> {
  List<Job> jobOfPosition(Job job);
}
