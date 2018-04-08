package base.dao;

import base.model.Department;
import base.model.Disease;
import java.util.List;

/**
 * @author long
 * @since 18-4-7
 */
public interface DiseaseDao extends BaseDao<Disease> {
  List<Disease> diseaseOfDepartment(Department department);
}
