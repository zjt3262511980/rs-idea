package com.dao;

import com.domain.Checkingin;
import com.domain.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CheckinginDao extends Mapper<Checkingin> {
    @Results(value={
        @Result(column = "emp_name",property = "employee.empName")
    }
    )
    @Select("select a.*,e.emp_name from checkingin a,employee e where a.emp_id=e.emp_id and che_moth=#{mothe}")
    List<Checkingin> selectcheck(String mothe);
}
