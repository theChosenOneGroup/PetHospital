package base.service.impl;

import base.dao.VaccineDao;
import base.model.VaccineInfo;
import base.service.VaccineManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccineManageServiceImpl implements VaccineManageService {
    @Autowired
    private VaccineDao vaccineDao;

    public List<VaccineInfo> searchVaccine(VaccineInfo vaccineInfo) {
        List<VaccineInfo> vaccineList= vaccineDao.searchVaccine(vaccineInfo.getVaccineName());
        return vaccineList;
    }

    public int addVaccine(VaccineInfo vaccineInfo) {
        int result = vaccineDao.addVaccine(vaccineInfo);
        return result;
    }
    public int delete(VaccineInfo vaccineInfo){
        int result = vaccineDao.delete(vaccineInfo);
        return result;
    }
    public int update(VaccineInfo vaccineInfo){
        int result= vaccineDao.update(vaccineInfo);
        return result;
    }

    public List<VaccineInfo> searchAll(){
        List<VaccineInfo> vaccineList= vaccineDao.searchAll();
        return vaccineList;
    }
}
