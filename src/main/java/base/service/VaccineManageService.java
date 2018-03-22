package base.service;

import base.model.VaccineInfo;

import java.util.List;

public interface VaccineManageService {
    public List<VaccineInfo> searchVaccine(VaccineInfo vaccineInfo);
    public int addVaccine(VaccineInfo vaccineInfo);
    public int delete(VaccineInfo vaccineInfo);
    public int update(VaccineInfo vaccineInfo);
    public List<VaccineInfo> searchAll();
}
