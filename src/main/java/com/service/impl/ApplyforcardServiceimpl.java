package com.service.impl;

import com.dao.ApplyforcardDao;
import com.dao.BeondutyDao;
import com.dao.PunchcardDao;
import com.domain.Applyforcard;
import com.domain.Beonduty;
import com.domain.Punchcard;
import com.service.ApplyforcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ApplyforcardServiceimpl implements ApplyforcardService {
    @Autowired
    private ApplyforcardDao applyforcardDao;
    @Autowired
    private PunchcardDao punchcardDao;
    @Override
    public int insertapp(Applyforcard applyforcard) {
        return applyforcardDao.insertSelective(applyforcard);
    }

    @Override
    public Applyforcard selectappl(int empid, int beonid) {
        Example example=new Example(Applyforcard.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("applyEmpId",empid);
        criteria.andEqualTo("beonId",beonid);
        return applyforcardDao.selectOneByExample(example);
    }

    @Override
    public List<Applyforcard> selectbyempid(int empid) {
        return applyforcardDao.selectappbyempid(empid);
    }

    @Override
    public int updateappl(int applid, String applyStatus,String day,int empid,int beonid) {
        Applyforcard applyforcard=new Applyforcard();
        applyforcard.setApplyId(applid);
        applyforcard.setApplyStatus(applyStatus);
        if("同意".equals(applyStatus)){
            Example example=new Example(Punchcard.class);
            Example.Criteria criteria=example.createCriteria();
            criteria.andEqualTo("empId",empid);
            criteria.andEqualTo("beondutyId",beonid);
             List<Punchcard> list=punchcardDao.selectByExample(example);
            Punchcard punchcard=new Punchcard();
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


             if(list.size()>0){
                 //修改
                punchcard.setPunchId(list.get(0).getPunchId());
                if(list.get(0).getPunchStatusDate()==null){
                    String a=day+" 07:58:00";
                    try {
                        punchcard.setPunchStatusDate(new Timestamp(dateFormat.parse(a).getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if(list.get(0).getPunchEndDate()==null){
                    String a=day+" 13:58:00";
                    try {
                        punchcard.setPunchEndDate(new Timestamp(dateFormat.parse(a).getTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                 punchcardDao.updateByPrimaryKeySelective(punchcard);
             }else {
                 //添加

                 String a=day+" 07:58:00";
                 String b=day+" 13:58:00";
                 try {
                     punchcard.setPunchStatusDate(new Timestamp(dateFormat.parse(a).getTime()));
                     punchcard.setPunchEndDate(new Timestamp(dateFormat.parse(b).getTime()));
                 } catch (ParseException e) {
                     e.printStackTrace();
                 }
                 punchcard.setEmpId(empid);
                 punchcard.setBeondutyId(beonid);
                 punchcardDao.insertSelective(punchcard);
             }

        }
        return applyforcardDao.updateByPrimaryKeySelective(applyforcard);
    }
}
