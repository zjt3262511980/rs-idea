package com.controller;

import com.domain.Beonduty;
import com.domain.Checkingin;
import com.domain.Employee;
import com.service.CkeckinginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("check")
public class CheckingController {
    @Autowired
    private CkeckinginService ckeckinginService;

    @RequestMapping("selectckeck")
    public List<Checkingin> selectmonth(int year,int month){
        return ckeckinginService.selectckeck(year,month);
    }

    @RequestMapping("selectbynotempid")
    public List<Employee> selectbynotempid(String month){
        return ckeckinginService.selectbymoth(month);
    }
    @RequestMapping("insertckeck")
    public int insertckeck(@RequestBody Checkingin checkingin){
        return ckeckinginService.insertmoth(checkingin);
    }

    @RequestMapping("jskq")
    public Checkingin jskq(int empid,int moth){
        return  ckeckinginService.jscs(empid,moth);
    }


}
