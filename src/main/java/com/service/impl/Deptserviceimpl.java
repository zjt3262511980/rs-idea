package com.service.impl;

import com.dao.DeptDao;
import com.domain.Dept;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Deptserviceimpl implements DeptService {

    @Autowired
    private DeptDao deptDao;
    @Override
    public List<Dept> deptlist() {
        return deptDao.selectAll();
    }
}
