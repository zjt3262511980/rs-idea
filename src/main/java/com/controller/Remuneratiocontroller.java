package com.controller;

import com.domain.*;
import com.dto.Remlist;
import com.service.CompackService;
import com.service.RemunerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("remu")
public class Remuneratiocontroller {

    @Autowired
    private RemunerationService remunerationService;

    @Autowired
    private CompackService compackService;
    @RequestMapping("selectcompack")
    public Compack selectcompack(){
      return compackService.selectcompack();
    }

    @RequestMapping("updatecompack")
    public int updatecompack(@RequestBody Compack compack){
        return compackService.updatecomp(compack);
    }

    @RequestMapping("selectbyrem")
    public List<Remuneration> selectbyrem(Date date){
        date.setDate(1);
        date.setMonth(date.getMonth()-1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return remunerationService.selectbymoth(sdf.format(date));
    }
    @RequestMapping("selectlistemp")
    public List<Employee> selectlistemp(Date date){
        date.setDate(1);
        date.setMonth(date.getMonth()-1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return remunerationService.selectempidtj(sdf.format(date));
    }

    @RequestMapping("jisanrem")
    public Remuneration jisanrem(int empid,String moth){
        return remunerationService.selecbyempid(empid,moth);
}

    @RequestMapping("tianjian")
    public int tianjian(@RequestBody Remuneration remuneration){
        Date date=new Date();
        date.setDate(1);
        date.setMonth(date.getMonth()-1);
        remuneration.setRemMonth(date);
        return remunerationService.insertrem(remuneration);
    }

    @RequestMapping("zjlshenqin")
    public List<Remuneration> zjlshenqin(Date date){
        date.setDate(1);
        date.setMonth(date.getMonth()-1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return remunerationService.zjltysq(sdf.format(date));
    }

    @RequestMapping("zjlyj")
    public int  zjlyj(int remid,int yj){
       return remunerationService.updaterem(remid,yj);
    }

    @RequestMapping("cwshenqin")
    public List<Remuneration> cwshenqin(Date date){
        date.setDate(1);
        date.setMonth(date.getMonth()-1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return remunerationService.cwtysq(sdf.format(date));
    }
    @RequestMapping("cwyj")
    public int  cwyj(int remid,int yj){
        return remunerationService.updateremcw(remid,yj);
    }
    @RequestMapping("cwyjlist")
    public int  cwyjlist(@RequestBody Remlist list){
        for (int i=0;i<list.getList().size();i++){
            remunerationService.updateremcw(list.getList().get(i).getRemId(),list.getYj());
        }
        return 0;
    }
    @RequestMapping("remunbyid")
    public List<Remuneration>  remunbyid(int empid, Date date){
        date.setDate(1);
        date.setMonth(date.getMonth()-1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return remunerationService.rmeunbyempid(empid,sdf.format(date));
    }

}
