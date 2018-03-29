package base.service;

import base.model.OfficeInfo;

import java.util.List;

public interface OfficeManageService {
    public List<OfficeInfo> search(OfficeInfo officeInfo);
    public int add(OfficeInfo officeInfo);
    public int delete(OfficeInfo officeInfo);
    public int update(OfficeInfo officeInfo);
    public List<OfficeInfo> searchAll();
}
