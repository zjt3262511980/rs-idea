package com.dao;

import com.domain.Punchcard;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface PunchcardDao extends Mapper<Punchcard> {
    @Results(id = "punchard_beonduty",value = {
            @Result(column = "Beonduty_day",property = "beonduty.beondutyDay"),
            @Result(column = "Beonduty_month",property = "beonduty.beondutyMonth")
    })
    @Select("select a.*,b.Beonduty_day,Beonduty_month from punchcard a,beonduty b where a.Beonduty_id=b.Beonduty_id and a.emp_id=#{empid} and b.Beonduty_month=#{month}")
    List<Punchcard> listpunchard(int empid, int month);
    @Results(value = {
            @Result(column = "emp_name",property = "employee.empName"),
            @Result(column = "Beonduty_day",property = "beonduty.beondutyDay"),
    })
    @Select("select a.*,e.emp_name,b.Beonduty_day from punchcard a,employee e,beonduty b where a.emp_id=e.emp_id and a.Beonduty_id=b.Beonduty_id and e.emp_id=#{empid} and b.Beonduty_month=#{month} ")
    List<Punchcard> listbyempidmonth(int empid, int month);
}
