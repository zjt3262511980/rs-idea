package com.service.impl;

import com.dao.RemunerationDao;
import com.domain.*;
import com.service.CkeckinginService;
import com.service.CompackService;
import com.service.RemunerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RemunerationServiceimpl implements RemunerationService{

    @Autowired
    private RemunerationDao remunerationDao;
    @Autowired
    private CkeckinginService ckeckinginService;
    @Autowired
    private CompackService compackService;

    @Override
    public List<Remuneration> selectbymoth(String date) {
        return remunerationDao.selectbymoth(date);
    }

    @Override
    public List<Employee> selectempidtj(String date) {
        List<Employee> list=remunerationDao.selectbyemp(date);
        List<Employee> list2=new ArrayList<Employee>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getRemuneration()==null){
                list2.add(list.get(i));
            }
        }
        //被拒觉
        List<Employee> listbjj=remunerationDao.selectbyempbenjujie(date);
        for (int i=0;i<listbjj.size();i++){
                list2.add(listbjj.get(i));
        }
        return list2;
    }

    @Override
    public Remuneration selecbyempid(int empid,String moth) {
        Compack compack=compackService.selectcompack();
       Checkingin checkingin=ckeckinginService.selectbyidmoth(empid,moth);
       if(checkingin==null){
           return null;
       }else {
           Remuneration remuneration=new Remuneration();
           //empid
           remuneration.setEmpId(empid);
         String a=checkingin.getEmployee().getTmExamdataAddition().getTmEAPosition();
         //基本工资
         if("员工".equals(a)){
           remuneration.setRemSalary(compack.getEmpSalary());
         }else if("主管".equals(a)){
             remuneration.setRemSalary(compack.getEmpChargeSalary());
         }else if("经理".equals(a)){
             remuneration.setRemSalary(compack.getEmpManagerSalary());
         }else if("总经理".equals(a)){
             remuneration.setRemSalary(compack.getEmpZongmanagerSalary());
         }
         //应出勤天数
         remuneration.setRemTiem(checkingin.getCheOut());
         //实际出勤天数
         remuneration.setRemOut(checkingin.getChePractical());
          //全勤
           if(checkingin.getCheOut()==checkingin.getChePractical()){
               remuneration.setRemPresent(0);
           }else {
               remuneration.setRemPresent(1);
           }

           //补伙食费
         remuneration.setRemMachin(compack.getComBoard());
         //公积金
          remuneration.setRemFund(remuneration.getRemSalary()*compack.getComAccumulation()/100);
          //社保扣款
           remuneration.setRemWithhold(remuneration.getRemSalary()*compack.getComSocial()/100);
           //扣款
           remuneration.setRemMoney(compack.getComLate()*(checkingin.getCheOut()-checkingin.getChePractical()));
           //应发工资
           if((checkingin.getCheOut()-checkingin.getChePractical())>0){
               remuneration.setRemUseSalary(remuneration.getRemSalary()+remuneration.getRemMachin()-remuneration.getRemFund()-remuneration.getRemWithhold()-remuneration.getRemMoney());
           }else {
               remuneration.setRemUseSalary(remuneration.getRemSalary()+remuneration.getRemMachin()-remuneration.getRemFund()-remuneration.getRemWithhold()+compack.getComAward());

           }
           remuneration.setRemNetPay(remuneration.getRemUseSalary());
           remuneration.setRemZjlYj(0);
           remuneration.setRemCwYj(0);
         return remuneration;
       }
    }

    @Override
    public int insertrem(Remuneration remuneration) {
        return remunerationDao.insertSelective(remuneration);
    }

    @Override
    public List<Remuneration> zjltysq(String date) {
        return remunerationDao.senqinzjl(date);
    }

    @Override
    public int updaterem(int remid,int zjlyj) {
        Remuneration remuneration=new Remuneration();
        remuneration.setRemId(remid);
        remuneration.setRemZjlYj(zjlyj);
        return remunerationDao.updateByPrimaryKeySelective(remuneration);
    }

    @Override
    public List<Remuneration> cwtysq(String date) {
        return remunerationDao.senqincw(date);
    }

    @Override
    public int updateremcw(int remid, int cwyj) {
        Remuneration remuneration=new Remuneration();
        remuneration.setRemId(remid);
        remuneration.setRemCwYj(cwyj);
        return remunerationDao.updateByPrimaryKeySelective(remuneration);
    }

    @Override
    public List<Remuneration> rmeunbyempid(int empid, String date) {
        return remunerationDao.remunerbyempid(empid,date);
    }


}
