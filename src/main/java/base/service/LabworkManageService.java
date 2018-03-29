package base.service;

import base.model.LabworkInfo;

import java.util.List;

public interface LabworkManageService {
    public List<LabworkInfo> searchLabwork(LabworkInfo labworkInfo);
    public int addLabwork(LabworkInfo labworkInfo);
    public int delete(LabworkInfo labworkInfo);
    public int update(LabworkInfo labworkInfo);
    public List<LabworkInfo> searchAll();
}
