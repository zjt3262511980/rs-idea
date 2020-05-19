package com.controller;

import com.domain.Applyforcard;
import com.service.ApplyforcardService;
import com.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("appl")
public class ApplyforcardController {
    @Autowired
    private ApplyforcardService applyforcardService;

    @RequestMapping("insertapp")
    public int insertapp(String applyCause,int appempid,int beonid) {
        Applyforcard applyforcard=new Applyforcard();
        applyforcard.setBeonId(beonid);
        applyforcard.setApplyCause(applyCause);
        applyforcard.setEmpId(MyConstants.EMPID);
        applyforcard.setApplyDate(new Date());
        applyforcard.setApplyStatus("待处理");
        applyforcard.setApplyEmpId(appempid);
        return applyforcardService.insertapp(applyforcard);
    }

    @RequestMapping("selectbyempidbeonid")
    public Applyforcard selectbyempidbeonid(int appempid,int beonid) {
        return applyforcardService.selectappl(appempid,beonid);
    }
    @RequestMapping("selectbyempid")
    public List<Applyforcard> selectbyempid(int appempid) {
        return applyforcardService.selectbyempid(appempid);
    }

    @RequestMapping("updatestarts")
    public int updatestarts(int appempid,String starts,String day,int empid,int beonid) {
        return applyforcardService.updateappl(appempid,starts,day,empid,beonid);
    }


}
