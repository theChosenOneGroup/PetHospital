package base.service.impl;

import base.dao.CaseDao;
import base.model.CaseInfo;
import base.model.PicAndVideoInfo;
import base.service.CaseManageService;
import base.service.PicAndVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseManageServiceImpl implements CaseManageService {
    @Autowired
    private CaseDao caseDao;
    @Autowired
    private PicAndVideoService picAndVideoService;

    public List<CaseInfo> search(CaseInfo caseInfo) {
        List<CaseInfo> vaccineList= caseDao.search(caseInfo.getCaseName());
        return vaccineList;
    }

    public  int add(CaseInfo caseInfo) {
        PicAndVideoInfo pI=new PicAndVideoInfo();
        pI.setType(1);
        pI.setPath(caseInfo.getCheckPic());
        int num= picAndVideoService.savePicture(pI);

        pI.setType(1);
        pI.setPath(caseInfo.getDiagnosePic());
        int num1= picAndVideoService.savePicture(pI);

        pI.setType(2);
        pI.setPath(caseInfo.getTreatVideo());
        int num2= picAndVideoService.saveVideo(pI);


        int result = caseDao.add(caseInfo);
        return result;
    }
    public int delete(CaseInfo caseInfo){
        int result = caseDao.delete(caseInfo);
        return result;
    }
    public int update(CaseInfo caseInfo){
        int result= caseDao.update(caseInfo);
        return result;
    }

    public List<CaseInfo> searchAll(){
        List<CaseInfo> caseList= caseDao.searchAll();
        return caseList;
    }

    public String getCost(CaseInfo caseInfo) {
        String cost=caseDao.getCost(caseInfo.getCaseName());
        return cost;
    }
}
