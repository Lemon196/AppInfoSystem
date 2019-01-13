package cn.appsys.dao;

import cn.appsys.pojo.DevUser;

import java.util.List;

public interface DevUserMapper {
    /*//开发者用户名ajax验证
    List<DevUser> ajaxDev(DevUser devUser);*/
    //开发者登录
    DevUser login(DevUser devUser);

}
