package com.controller;


import com.domain.Dept;
import com.service.DeptService;
import com.service.impl.Deptserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("deptzc")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("selectdeptlist")
    public List<Dept> selectdeptlist(){
        return deptService.deptlist();
    }
}
