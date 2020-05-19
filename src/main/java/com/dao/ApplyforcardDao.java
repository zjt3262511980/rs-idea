package com.dao;

import com.domain.Applyforcard;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ApplyforcardDao extends Mapper<Applyforcard> {
    @Results(id = "appl_emp_beon",value = {
            @Result(column = "Emp_img",property = "employee.empImg"),
            @Result(column = "emp_name",property = "employee.empName"),
            @Result(column = "Beonduty_day",property = "beonduty.beondutyDay")
    })
    @Select("select a.*,b.Beonduty_day,e.Emp_img,e.emp_name from applyforcard a,beonduty b,employee e where a.Beon_id=b.Beonduty_id and a.Apply_emp_id=e.emp_id and a.emp_id=#{empid} and a.Apply_status='待处理'")
    List<Applyforcard> selectappbyempid(int empid);
}
