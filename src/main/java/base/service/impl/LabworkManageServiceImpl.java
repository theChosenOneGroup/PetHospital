package base.service.impl;

import base.dao.LabworkDao;
import base.model.LabworkInfo;
import base.service.LabworkManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabworkManageServiceImpl implements LabworkManageService {
    @Autowired
    private LabworkDao labworkDao;

    public List<LabworkInfo> searchLabwork(LabworkInfo labworkInfo) {
        List<LabworkInfo> labworkList= labworkDao.searchLabwork(labworkInfo.getLabworkName());
        return labworkList;
    }

    public int addLabwork(LabworkInfo labworkInfo) {
        int result = labworkDao.addLabwork(labworkInfo);
        return result;
    }
    public int delete(LabworkInfo labworkInfo){
        int result = labworkDao.delete(labworkInfo);
        return result;
    }
    public int update(LabworkInfo labworkInfo){
        int result= labworkDao.update(labworkInfo);
        return result;
    }

    public List<LabworkInfo> searchAll(){
        List<LabworkInfo> labworkList= labworkDao.searchAll();
        return labworkList;
    }
}
