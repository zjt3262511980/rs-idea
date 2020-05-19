package com.controller;

import com.domain.Beonduty;
import com.domain.Dept;
import com.domain.Punchcard;
import com.domain.Userrs;
import com.dto.Pundto;
import com.service.BeondutyService;
import com.service.DeptService;
import com.service.PunchardService;
import com.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("beonzc")
//@SessionAttributes(MyConstants.USERRS)
public class BeondutyController {
    @Autowired
    private BeondutyService beondutyService;
    @Autowired
    private PunchardService punchardService;
    @RequestMapping("tianbeon")
    public int tianbeon(int year,int month,int[] value){
        return beondutyService.tjbeonduty(year,month,value);
    }

    @RequestMapping("selectmonth")
    public List<Beonduty> selectmonth(int month){
        return beondutyService.listbeonduty(month);
    }

    @RequestMapping("upbeonuty")
    public int upbeon(int year,int month,int[] value){
        return beondutyService.upbeonduty(year,month, value);
    }
    @RequestMapping("selectbeo")
    public List<Pundto> selectbeo(int month,int empid){
        List<Beonduty> list=beondutyService.listbeonduty(month);
        List<Pundto> punlist=new ArrayList<Pundto>();
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
                    if(b==1){
                        Pundto pundto=new Pundto(String.valueOf(a),new int[]{1});
                        punlist.add(pundto);
                    }else {
                        punlist.add(new Pundto(String.valueOf(a),new int[]{0,1}));
                    }
            }else {
                punlist.add(new Pundto(String.valueOf(a),new int[]{1}));
        }
        }
        return punlist;
    }

    @RequestMapping("selectcz")
    public Beonduty selectcz(Date date){
        return beondutyService.selectbydate(date);
    }
}
