package com.service.impl;

import com.dao.CheckinginDao;
import com.dao.EmployeeDao;
import com.dao.PunchcardDao;
import com.domain.*;
import com.service.BeondutyService;
import com.service.CkeckinginService;
import com.service.PunchardService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class CkeckingServiceimpl implements CkeckinginService {
    @Autowired
    private CheckinginDao checkinginDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private PunchcardDao punchcardDao;
    @Autowired
    private BeondutyService beondutyService;
    @Autowired
    private PunchardService punchardService;
    @Override
    public List<Checkingin> selectckeck(int year, int moth) {
        return checkinginDao.selectcheck(year+"/"+moth);
    }

    @Override
    public List<Employee> selectbymoth(String moth) {
        List<Employee> list=new ArrayList<Employee>();
        List<Employee> listemp=employeeDao.selectbymothnotemid(moth);
            for (int i=0;i<listemp.size();i++){
                if(listemp.get(i).getCheckingin()==null){
                    list.add(listemp.get(i));
                }
            }
            return list;
    }

    @Override
    public int insertmoth(Checkingin checkingin) {
        return checkinginDao.insertSelective(checkingin);
    }

    @Override
    public Checkingin jscs(int empid, int moth) {
        Checkingin checkingin=new Checkingin();
        List<Beonduty> listbeo=beondutyService.listbeonduty(moth);
        checkingin.setCheOut(listbeo.size());
        List<Punchcard> listpun= punchardService.list(empid,moth);
        checkingin.setChePractical(listpun.size());
        checkingin.setCheAbsenteeism(listbeo.size()-listpun.size());

        List<Punchcard> listpun2=punchcardDao.listbyempidmonth(empid,moth);
        int a=0,b=0;
        for(int i=0;i<listpun2.size();i++){
            if(listpun2.get(i).getPunchStatusDate()==null){
                a++;
            }
            if(listpun2.get(i).getPunchEndDate()==null){
                b++;
            }

        }
        checkingin.setCheLate(a);
        checkingin.setCheEarly(b);
        checkingin.setEmpId(empid);
        System.out.println(checkingin);
        return checkingin;
    }

    @Override
    public Checkingin selectbyidmoth(int empid,String moth) {
        Example example=new Example(Checkingin.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("empId",empid);
        criteria.andEqualTo("cheMoth",moth);
        Checkingin checkingin= checkinginDao.selectOneByExample(example);
        if(checkingin==null){
           return null;
        }else {
            checkingin.setEmployee(employeeDao.byid(checkingin.getEmpId()));
            return checkingin;
        }

    }

}
