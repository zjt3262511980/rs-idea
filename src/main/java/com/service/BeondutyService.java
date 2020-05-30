package com.service;

import com.domain.Beonduty;

import java.util.Date;
import java.util.List;

public interface BeondutyService {
    int tjbeonduty(int year,int month,int [] day);
    List<Beonduty> listbeonduty(int month);
    int upbeonduty(int year,int month,int [] day);
    Beonduty selectbydate(Date date);
    List<String> listbeondutystring(int month);
}
