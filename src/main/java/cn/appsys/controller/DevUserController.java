package cn.appsys.controller;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.DevUserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/devLoginController")
public class DevUserController {
    @Resource
    private DevUserService devUserService;
    @RequestMapping("/login")
    public String login(){
        return "devlogin";
    }
    @RequestMapping("/logout")
    public String logout(){
        return "devlogin";
    }
    /*@RequestMapping(value = "/ajaxDev",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String ajaxDev(DevUser devUser){
        List<DevUser> devUsers=devUserService.ajaxDev(devUser);
        boolean result=false;
        if (devUsers.size()>0){
            result=true;
        }
        return JSON.toJSONString(result);
    }*/
    @RequestMapping("/devUserLogin")
    public String devUserLogin(HttpServletRequest request, DevUser devUser){
        DevUser resultDevUser=devUserService.login(devUser);
        if (resultDevUser!=null){
            request.getSession().setAttribute("devUserSession",resultDevUser);
            return "/developer/main";
        }
        request.setAttribute("message","用户名或密码错误！");
        return "devlogin";
    }
}
