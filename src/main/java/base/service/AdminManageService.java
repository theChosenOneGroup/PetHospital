package base.service;

import base.model.UserInfo;

import java.util.List;

public interface AdminManageService {
    public List<UserInfo> search(UserInfo userInfo);
    public int add(UserInfo userInfo);
    public int delete(UserInfo userInfo);
    public int update(UserInfo userInfo);
    public List<UserInfo> searchAll();
}
