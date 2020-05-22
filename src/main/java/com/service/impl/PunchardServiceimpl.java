package com.service.impl;

import com.dao.BeondutyDao;
import com.dao.PunchcardDao;
import com.domain.Beonduty;
import com.domain.Employee;
import com.domain.Punchcard;
import com.service.BeondutyService;
import com.service.PunchardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PunchardServiceimpl implements PunchardService {
    @Autowired
    private PunchcardDao punchcardDao;


    @Override
    public List<Punchcard> listpunchard(int empid, int month) {
        return  punchcardDao.listpunchard(empid,month);
    }

    @Override
    public Punchcard selectbytime(int beondutyid, int empid) {
        Example example=new Example(Punchcard.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("beondutyId",beondutyid);
        criteria.andEqualTo("empId",empid);
        return punchcardDao.selectOneByExample(example);
    }

    @Override
    public int intsertpuchcard(int empid, int beondutyid) {
        Punchcard punchcard=new Punchcard();
                punchcard.setEmpId(empid);
                punchcard.setBeondutyId(beondutyid);
                punchcard.setPunchStatusDate(new Timestamp(new Date().getTime()));
        return punchcardDao.insertSelective(punchcard);
    }

    @Override
    public int updatepuchcard(Punchcard punchcard) {
        return punchcardDao.updateByPrimaryKeySelective(punchcard);
    }

    @Override
    public List<Punchcard> list(int empid, int month) {
        return punchcardDao.listbyempidmonth(empid,month);
    }


}
