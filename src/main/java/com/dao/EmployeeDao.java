package com.dao;

import com.domain.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Id;
import java.util.List;

public interface EmployeeDao extends Mapper<Employee> {
    @Results(id = "employe_dept_tm",value = {
            @Result(column = "dep_id",property = "dept.depId"),
            @Result(column = "dep_department",property = "dept.depDepartment"),
             @Result(column = "tm_e_a_di",property = "tmExamdataAddition.tmEADi"),
             @Result(column = "tm_e_a_position",property = "tmExamdataAddition.tmEAPosition"),
    })
    @Select("select a.*,d.*,t.* from employee a,dept d,tm_examdata_addition t where a.emp_dept=d.Dep_id and a.Emp_position=t.Tm_e_a_di and a.emp_id=#{id}")
    Employee byid(int id);
    @ResultMap("employe_dept_tm")
    @Select("select a.*,d.*,t.* from employee a,dept d,tm_examdata_addition t where a.emp_dept=d.Dep_id and a.Emp_position=t.Tm_e_a_di and (a.emp_name like #{tj} or a.emp_sex like #{tj} or d.Dep_department like #{tj or t.Tm_e_a_position like #{tj} or a.Emp_major like #{tj})")
    List<Employee> listemployee(String tj);
    @ResultMap("employe_dept_tm")
    @Select("select a.*,d.*,t.* from employee a,dept d,tm_examdata_addition t where a.emp_dept=d.Dep_id and a.Emp_position=t.Tm_e_a_di and (a.emp_name like #{tj} or a.emp_sex like #{tj} or d.Dep_department like #{tj or t.Tm_e_a_position like #{tj} or a.Emp_major like #{tj}) and a.Emp_status ='在职'")
    List<Employee> listemployeenot(String tj);
}
