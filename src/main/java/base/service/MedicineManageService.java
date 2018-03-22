package base.service;

import base.model.MedicineInfo;
import java.util.List;

public interface MedicineManageService {

  public int addMedicine(MedicineInfo medicine);

  public int deleteMedicine(MedicineInfo medicine);

  public int updateMedicine(MedicineInfo medicine);

  public List<MedicineInfo> searchMedicine(MedicineInfo medicine);

  public List<MedicineInfo> searchAllMedicine();
}
