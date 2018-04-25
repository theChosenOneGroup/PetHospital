package base.service;

import base.model.CaseInfo;

import java.util.List;

public interface CaseManageService {
    public List<CaseInfo> search(CaseInfo caseInfo);
    public int add(CaseInfo caseInfo);
    public int delete(CaseInfo caseInfo);
    public int update(CaseInfo caseInfo);
    public List<CaseInfo> searchAll();
    public String getCost(CaseInfo caseInfo);
}
