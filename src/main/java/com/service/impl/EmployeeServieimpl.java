package com.service.impl;

import com.dao.EmployeeDao;
import com.domain.Employee;
import com.domain.Userrs;
import com.dto.PageDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmployeeServieimpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public Employee bynameIdentity(String name, String empIdentity) {
        Example example=new Example(Employee.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("empName",name);
        criteria.andEqualTo("empIdentity",empIdentity);

        return employeeDao.selectOneByExample(example);
    }

    @Override
    public PageInfo<Employee> listpage(PageDto pageDto,String tj) {
        // 1.设置当前页和每页显示的条数
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        // 2.执行查询
        List list=employeeDao.listemployee(tj);
        // 3. 实例化PageInfo对象
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }
    @Override
    public PageInfo<Employee> listpagenot(PageDto pageDto,String tj) {
        // 1.设置当前页和每页显示的条数
        PageHelper.startPage(pageDto.getPage(), pageDto.getPageSize());
        // 2.执行查询
        List list=employeeDao.listemployeenot(tj);
        // 3. 实例化PageInfo对象
        PageInfo pageInfo=new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int insertemp(Employee employee) {
        return employeeDao.insertSelective(employee);
    }

    @Override
    public Employee byempid(int id) {
        Employee employee=employeeDao.byid(id);
        employee.setSuperior(employeeDao.byid(employee.getEmpSuperior()));
        return employee;
    }
}
