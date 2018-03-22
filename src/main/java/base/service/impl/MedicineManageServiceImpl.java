package base.service.impl;

import base.dao.MedicineDao;
import base.model.MedicineInfo;
import base.service.MedicineManageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineManageServiceImpl implements MedicineManageService {

  @Autowired
  private MedicineDao medicineDao;

  public int addMedicine(MedicineInfo medicine) {
    int result = medicineDao.insert(medicine);
    return result;
  }

  public int deleteMedicine(MedicineInfo medicine) {
    int result = medicineDao.delete(medicine);
    return result;
  }

  public int updateMedicine(MedicineInfo medicine) {
    int result = medicineDao.update(medicine);
    return result;
  }

  public List<MedicineInfo> searchMedicine(MedicineInfo medicine) {
    List<MedicineInfo> result = medicineDao.search(medicine.getMedicineName());
    return result;
  }

  public List<MedicineInfo> searchAllMedicine() {
    List<MedicineInfo> result = medicineDao.searchAll();
    return result;
  }
}
