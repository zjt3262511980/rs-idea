package com.controller;

import com.domain.Beonduty;
import com.domain.Punchcard;
import com.dto.Pundto;
import com.service.BeondutyService;
import com.service.PunchardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("punzc")
public class PunchcardController {
    @Autowired
    private PunchardService punchardService;
    @Autowired
    private BeondutyService beondutyService;

    @RequestMapping("selectpun")
    public Punchcard selectpun(int empid,Date date){
            Beonduty beonduty=beondutyService.selectbydate(date);
            if(beonduty!=null){
                return punchardService.selectbytime(beonduty.getBeondutyId(),empid);
            }else {return null;}

    }

    @RequestMapping("insertpun")
    public int insertpun(int empid,int beondutyid){
     return punchardService.intsertpuchcard(empid,beondutyid);
    }
    @RequestMapping("updatepun")
    public int updatepun(Punchcard punchcard){
        punchcard.setPunchEndDate(new Timestamp(new Date().getTime()));
        return punchardService.updatepuchcard(punchcard);
    }
    @RequestMapping("sqpunchard")
    public List<Beonduty> sqpunchard(int empid, int month){
        List<Beonduty> list=beondutyService.listbeonduty(month);
        List<Beonduty> beolist=new ArrayList<Beonduty>();
        List<Punchcard> listun=punchardService.listpunchard(empid,month);
        Date date=new Date();
        for(int i=0;i<list.size();i++){
            int a=list.get(i).getBeondutyDay().getDate();
            if(date.getDate()>=a){
                int b=0;
                for(int j=0;j<listun.size();j++){
                    if(listun.get(j).getPunchEndDate()!=null&&listun.get(j).getPunchStatusDate()!=null) {
                        if (a == listun.get(j).getPunchEndDate().getDate() && a == listun.get(j).getPunchStatusDate().getDate()) {
                            b++;
                        }
                    }
                }
                if(b!=1){
                    beolist.add(list.get(i));
                }
            }
        }
        return beolist;
    }

    @RequestMapping("selectbybeoidempid")
    public Punchcard selectbybeoidempid(String beondutyId,int empid) {
        return punchardService.selectbytime(Integer.parseInt(beondutyId), empid);
    }

    @RequestMapping("listbyempidbymoth")
    public List<Punchcard> listbyempidbymoth(int empid, int month) {
        return punchardService.list(empid,month);
    }

}
