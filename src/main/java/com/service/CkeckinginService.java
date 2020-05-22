package com.service;

import com.domain.Checkingin;
import com.domain.Employee;

import java.util.List;

public interface CkeckinginService {
    List<Checkingin> selectckeck(int year,int moth);
    List<Employee> selectbymoth(String moth);
    int insertmoth(Checkingin checkingin);
    Checkingin jscs(int empid,int moth);
}
