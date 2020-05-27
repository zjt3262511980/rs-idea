package com.service;

import com.domain.Employee;
import com.domain.Remuneration;

import java.util.Date;
import java.util.List;

public interface RemunerationService {
    List<Remuneration> selectbymoth(String date);
    List<Employee> selectempidtj(String date);
    Remuneration selecbyempid(int empid,String moth);
    int insertrem(Remuneration remuneration);
    List<Remuneration> zjltysq(String date);
    int updaterem(int remid,int zjlyj);
    List<Remuneration> cwtysq(String date);
    int updateremcw(int remid,int cwyj);
    List<Remuneration> rmeunbyempid(int empid,String date);
}
