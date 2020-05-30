package com.service;

import com.domain.Beonduty;
import com.domain.Punchcard;

import java.util.Date;
import java.util.List;

public interface PunchardService {
    List<Punchcard>  listpunchard(int empid, int month);
    Punchcard selectbytime(int beondutyid, int empid);
    int intsertpuchcard(int empid,int beondutyid);
    int updatepuchcard(Punchcard punchcard);
    List<Punchcard> list(int empid,int month);
    List<String>  liststring(int empid, int month);
    List<String>  liststring2(int empid, int month);
}
