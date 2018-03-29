package base.service.impl;

import base.dao.AdminDao;
import base.model.UserInfo;
import base.service.AdminManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminManageServiceImpl implements AdminManageService {
    @Autowired
    private AdminDao adminDao;

    public List<UserInfo> search(UserInfo userInfo) {
        List<UserInfo> vaccineList= adminDao.search(userInfo.getUserName());
        return vaccineList;
    }

    public int add(UserInfo userInfo) {
        int result = adminDao.add(userInfo);
        return result;
    }
    public int delete(UserInfo userInfo){
        int result = adminDao.delete(userInfo);
        return result;
    }
    public int update(UserInfo userInfo){
        int result= adminDao.update(userInfo);
        return result;
    }

    public List<UserInfo> searchAll(){
        List<UserInfo> userList= adminDao.searchAll();
        return userList;
    }
}
