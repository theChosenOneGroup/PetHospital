package base.service.impl;

import base.dao.OfficeDao;
import base.model.OfficeInfo;
import base.service.OfficeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeManageServiceImpl implements OfficeManageService {
    @Autowired
    private OfficeDao officeDao;

    public List<OfficeInfo> search(OfficeInfo officeInfo) {
        List<OfficeInfo> vaccineList= officeDao.search(officeInfo.getOfficeName());
        return vaccineList;
    }

    public int add(OfficeInfo officeInfo) {
        int result = officeDao.add(officeInfo);
        return result;
    }
    public int delete(OfficeInfo officeInfo){
        int result = officeDao.delete(officeInfo);
        return result;
    }
    public int update(OfficeInfo officeInfo){
        int result= officeDao.update(officeInfo);
        return result;
    }

    public List<OfficeInfo> searchAll(){
        List<OfficeInfo> officeList= officeDao.searchAll();
        return officeList;
    }
}
