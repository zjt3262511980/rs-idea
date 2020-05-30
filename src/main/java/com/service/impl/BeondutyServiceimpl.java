package com.service.impl;

import com.dao.BeondutyDao;
import com.domain.Beonduty;
import com.domain.Employee;
import com.service.BeondutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BeondutyServiceimpl implements BeondutyService {
    @Autowired
    BeondutyDao beondutyDao;


    @Override
    public int tjbeonduty(int year,int month,int[] day) {
        List<Beonduty> list=this.listbeonduty(month);
        if(list.size()>0){
            return 0;
        }else {
            Beonduty beonduty=new Beonduty();
            beonduty.setBeondutyMonth(month);
            for(int i=0;i<day.length;i++){
                beonduty.setBeondutyDay(new Date(Date.UTC(year-1900,month-1,day[i],12,00,00)));
                beondutyDao.insertSelective(beonduty);
            }
            return 1;
        }
    }

    @Override
    public List<Beonduty> listbeonduty(int month) {
        Example example=new Example(Beonduty.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("beondutyMonth",month);
        return beondutyDao.selectByExample(example);
    }

    @Override
    public int upbeonduty(int year, int month, int[] day) {
        //删除本月今天以后的所有上班
        Date date=new Date();
        Example example=new Example(Beonduty.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("beondutyMonth",month);
        criteria.andGreaterThan("beondutyDay",date);
        beondutyDao.deleteByExample(example);
        //添加本月今天以后所有上班
        Beonduty beonduty=new Beonduty();
        beonduty.setBeondutyMonth(month);
        for(int i=0;i<day.length;i++){
            if(day[i]>date.getDate()){
                beonduty.setBeondutyDay(new Date(Date.UTC(year-1900,month-1,day[i],12,00,00)));
                beondutyDao.insertSelective(beonduty);
            }
        }
        return 1;
    }

    @Override
    public Beonduty selectbydate(Date date) {
        Example example=new Example(Beonduty.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("beondutyDay",new java.sql.Date(date.getTime()));
        return beondutyDao.selectOneByExample(example);
    }

    @Override
    public List<String> listbeondutystring(int month) {
        Example example=new Example(Beonduty.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("beondutyMonth",month);
        List<Beonduty> list=beondutyDao.selectByExample(example);
       List<String> liststring=new ArrayList<>();
       for(int i=0;i<list.size();i++){
           liststring.add(list.get(i).getBeondutyDaystring());
       };
       return liststring;
    }
}
