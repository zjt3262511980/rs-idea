package com.service.impl;

import com.dao.EmployeeDao;
import com.dao.UserrsDao;
import com.domain.Employee;
import com.domain.User;
import com.domain.Userrs;
import com.service.UserService;
import com.service.UserrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class UserrsServiceimpl implements UserrsService {

    @Autowired
    private UserrsDao userrsDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Userrs denluuserrs(String name, String pwss) {
        Example example=new Example(Userrs.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("userName",name);
        criteria.andEqualTo("userPawd",pwss);
        Userrs userrs=userrsDao.selectOneByExample(example);
        if(userrs!=null){
            Employee employee=employeeDao.byid(userrs.getEmpId());
            if(!employee.getEmpStatus().equals("离职")){
                userrs.setEmployee(employee);
                return userrs;
            }else {
                return null;
            }
        }else {
            return null;
        }

    }

    @Override
    public Userrs selectempid(int empid) {
        Example example=new Example(Userrs.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("empId",empid);
        return userrsDao.selectOneByExample(example);
    }

    @Override
    public int tianjianuserrs(String name, String pwss,int empId) {
        Userrs userrs=new Userrs();
        userrs.setUserName(name);
        userrs.setUserPawd(pwss);
        userrs.setEmpId(empId);
        userrs.setUserSalt("");
        userrs.setUserDate(new Timestamp((new Date()).getTime()));
        int i=userrsDao.insertSelective(userrs);
        return i;
    }

    @Override
    public Userrs selectbyid(int byuserid) {
        return userrsDao.selectByPrimaryKey(byuserid);
    }
}
