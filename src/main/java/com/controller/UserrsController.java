package com.controller;


import com.domain.Userrs;
import com.service.EmployeeService;
import com.service.UserrsService;
import com.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("Loginrs")
@SessionAttributes(MyConstants.USERRS)
public class UserrsController {
    @Autowired
    private UserrsService userrsService;
    @Autowired
    private EmployeeService employeeService;

            /*zjt
            登录
            * */
    @RequestMapping("loginuserrs")
    public Userrs loginuserrs(String name, String pwd, ModelMap map, HttpSession session){
        if(name!=null&&pwd!=null){
        Userrs userrs=userrsService.denluuserrs(name,pwd);
        if(userrs.getEmployee().getEmpStatus().equals("在职")){
            map.put(MyConstants.USERRS,userrs);
            return userrs;
        }else{
            return null;
        }

        }else {
            return null;
        }
    }
                /*zjt
                查询empid
                * */
    @RequestMapping("cxempid")
    public int cxempid(String zsname,String zspwd){
        int i=employeeService.bynameIdentity(zsname,zspwd).getEmpId();
        if(userrsService.selectempid(i)==null){
            return i;
        }else {
            return 0;
        }

    }
                /*zjt
               添加urserrs
               * */
    @RequestMapping("tjuserrs")
    public int tjuserrs(@RequestBody Userrs userrs){
        if(userrsService.selectempid(userrs.getEmpId())==null){
            return userrsService.tianjianuserrs(userrs.getUserName(),userrs.getUserPawd(),userrs.getEmpId());
        }else {
            return 0;
        }

    }

    @RequestMapping("logout")
    public String  logout(HttpSession session,SessionStatus sessionStatus) {
        session.invalidate();
        sessionStatus.setComplete();
        return "注销成功";
    }

}
