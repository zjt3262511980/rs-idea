package com.service;

import com.domain.Employee;
import com.dto.PageDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    Employee bynameIdentity(String name, String empIdentity);
    PageInfo<Employee> listpage(PageDto pageDto,String tj);
    PageInfo<Employee> listpagenot(PageDto pageDto,String tj);
    int insertemp (Employee employee);
    Employee byempid(int id);
}
