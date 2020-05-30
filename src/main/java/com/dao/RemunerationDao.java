package com.dao;

import com.domain.Employee;
import com.domain.Remuneration;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

public interface RemunerationDao extends Mapper<Remuneration> {
    @Results(id = "zwtj",value = {
            @Result(column = "emp_name",property = "employee.empName"),
            @Result(column = "emp_img",property = "employee.empImg"),
            @Result(column = "dep_department",property = "dept.depDepartment"),
            @Result(column = "tm_e_a_position",property = "tmExamdataAddition.tmEAPosition")
    }
    )
    @Select("select a.*,e.emp_name,e.Emp_img,d.Dep_department,t.Tm_e_a_position from remuneration a,employee e,dept d,tm_examdata_addition t where a.emp_id=e.emp_id and e.emp_dept =d.Dep_id and e.Emp_position=t.Tm_e_a_di and a.Rem_month=#{date}")
    List<Remuneration> selectbymoth(String date);

    @Results(value = {
            @Result(column = "Rem_id",property = "remuneration.remId"),
    })
    @Select("select e.*,a.* from employee e left join remuneration a on e.emp_id=a.emp_id and Rem_month=#{date}")
    List<Employee> selectbyemp(String date);

    @Select("select e.*,a.* from employee e,remuneration a where e.emp_id=a.emp_id and Rem_month=#{date} and a.Rem_zjl_yj=2 or a.Rem_cw_yj=2")
    List<Employee> selectbyempbenjujie(String date);

    @ResultMap("zwtj")
    @Select("select a.*,e.emp_name,e.Emp_img,d.Dep_department,t.Tm_e_a_position from remuneration a,employee e,dept d,tm_examdata_addition t where a.emp_id=e.emp_id and e.emp_dept =d.Dep_id and e.Emp_position=t.Tm_e_a_di and a.Rem_zjl_yj=1 and a.Rem_month=#{date}")
    List<Remuneration> senqinzjl(String date);

    @ResultMap("zwtj")
    @Select("select a.*,e.emp_name,e.Emp_img,d.Dep_department,t.Tm_e_a_position from remuneration a,employee e,dept d,tm_examdata_addition t where a.emp_id=e.emp_id and e.emp_dept =d.Dep_id and e.Emp_position=t.Tm_e_a_di and a.Rem_cw_yj=1 and a.Rem_zjl_yj=0 and a.Rem_month=#{date}")
    List<Remuneration> senqincw(String date);

    @ResultMap("zwtj")
    @Select("select a.*,e.emp_name,e.Emp_img,d.Dep_department,t.Tm_e_a_position from remuneration a,employee e,dept d,tm_examdata_addition t where a.emp_id=e.emp_id and e.emp_dept =d.Dep_id and e.Emp_position=t.Tm_e_a_di and a.Rem_cw_yj=0 and a.Rem_zjl_yj=0  and a.emp_id=#{empid} and a.Rem_month=#{date}")
    List<Remuneration> remunerbyempid(@Param("empid")int empid,@Param("date")String date);
}
