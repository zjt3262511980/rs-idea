package com.controller;

import com.domain.User;
import com.domain.Userrs;
import com.domain.Vx;
import com.service.UserService;
import com.service.UserrsService;
import com.service.VxService;
import com.util.MyConstants;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;


@Controller
@RequestMapping("Login")
@SessionAttributes(value = {MyConstants.USER,MyConstants.USERRS})
public class UserController {

    //微信
    @Autowired
    private UserService userService;

    private Userrs userrvx;
    //--微信
    @Autowired
    private VxService vxService;

    @Autowired
    private UserrsService userrsService;

    //微信
    @RequestMapping("login")
    public String Login(String code, Map map){
        User user = userService.Login(code);
       Vx vx=vxService.selectvx(user.getOpenid());
       Userrs userrs=userrsService.selectbyid(vx.getUserrsid());
        userrs=userrsService.denluuserrs(userrs.getUserName(),userrs.getUserPawd());

        map.put(MyConstants.USERRS,userrs);

        userrvx=userrs;
        return "redirect:http://localhost:70/#/Login";
    }

    @ResponseBody
    @RequestMapping("selectuserrs")
    public Userrs selectuserrs(Map map,HttpSession session){
        Userrs userrs = (Userrs)map.get(MyConstants.USERRS);

          userrs=userrvx;
        return userrs;
    }

    @RequestMapping("banden")
    public String banden(String code,Map map){
        User user = userService.Login(code);
        map.put(MyConstants.USER,user);
        return "redirect:http://localhost:70/#/index/vxbd";
    }

    @ResponseBody
    @RequestMapping("select")
    public User select(Map map){
        User user = (User) map.get(MyConstants.USER);
        return user;
    }
    //--微信


    @ResponseBody
    @RequestMapping("insetvx")
    public int insetvx(String appid,int userid){
        return vxService.insertvs(userid,appid);
    }


    @RequestMapping("logout")
    public String  logout(HttpSession session, SessionStatus sessionStatus) {
        session.invalidate();
        sessionStatus.setComplete();
        userrvx=null;
        return "注销成功";
    }
}
