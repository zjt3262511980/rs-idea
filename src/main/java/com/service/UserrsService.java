package com.service;

import com.domain.Userrs;

public interface UserrsService {
    Userrs denluuserrs(String name,String pwss);
    Userrs selectempid(int empid);
    int tianjianuserrs(String name,String pwss,int empId);
    Userrs selectbyid(int byuserid);

}
