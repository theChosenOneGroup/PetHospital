//package base.dao.impl;
//
//import base.dao.DepartmentDao;
//import base.model.Department;
//import java.util.List;
//import org.springframework.stereotype.Repository;
//
///**
// * @author long
// * @since 18-4-7
// */
//@Repository
//public class DepartmentDaoImpl extends BaseDaoImp<Department> implements DepartmentDao {
//
//  private static String namespace = "base.dao.DepartmentDao";
//
//  @Override
//  protected String namespace() {
//    return namespace;
//  }
//
//  public List<Department> departmentOfCategory(Department department) {
//    return (List<Department>)
//        execute((session) -> session.selectList(namespace() + ".departmentOfCategory", department));
//  }
//
//  public List<String> categoryList() {
//    return (List<String>) execute((session) -> session.selectList(namespace() + ".categoryList"));
//  }
//}
