package base.dao.impl;

import base.dao.DepartmentDao;
import base.model.Department;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @since 18-4-7
 */
@Repository
public class DepartmentDaoImpl extends BaseDaoImp<Department> implements DepartmentDao {

  private static String namespace = "base.dao.DepartmentDao";

  @Override
  protected String namespace() {
    return namespace;
  }
}
