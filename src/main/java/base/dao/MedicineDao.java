package base.dao;

import base.model.MedicineInfo;
import java.util.List;

public interface MedicineDao {

  public int insert(MedicineInfo medicine);

  public int delete(MedicineInfo medicine);

  public int update(MedicineInfo medicine);

  public List<MedicineInfo> search(String medicineName);

  public List<MedicineInfo> searchAll();
}
