package com.service;

import com.domain.Applyforcard;

import java.util.List;

public interface ApplyforcardService {
   int insertapp(Applyforcard applyforcard);
   Applyforcard selectappl(int empid,int beonid);
   List<Applyforcard> selectbyempid(int empid);
   int updateappl(int applid,String applyStatus,String day,int empid,int beonid);
}
