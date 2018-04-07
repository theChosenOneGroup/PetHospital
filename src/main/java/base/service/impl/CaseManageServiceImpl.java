package base.service.impl;

import base.dao.CaseDao;
import base.model.CaseInfo;
import base.service.CaseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseManageServiceImpl implements CaseManageService {
    @Autowired
    private CaseDao caseDao;

    public List<CaseInfo> search(CaseInfo caseInfo) {
        List<CaseInfo> vaccineList= caseDao.search(caseInfo.getCaseName());
        return vaccineList;
    }

    public int add(CaseInfo caseInfo) {
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
