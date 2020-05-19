package com.controller;

import com.domain.Employee;
import com.dto.PageDto;
import com.github.pagehelper.PageInfo;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("empcz")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("pageemp")
    public PageInfo<Employee> pageemp(PageDto pageDto,String tj,Integer radio){
        if(radio==1){
            return employeeService.listpage(pageDto,"%"+tj+"%");
        }else if(radio==2){
            return employeeService.listpagenot(pageDto,"%"+tj+"%");
        }else {
            return null;
        }

    }
    @RequestMapping("insertemp")
    public int insertemp(@RequestBody Employee employee){
        employee.setEmpPosition(4);
        employee.setEmpStatus("在职");
        return employeeService.insertemp(employee);
    }

    @RequestMapping("byidemp")
    public Employee byidemp(int id){
       return employeeService.byempid(id);
    }


    @RequestMapping("upload")
    public String save(MultipartFile img, HttpSession session) throws Exception {
        if (img != null && !"".equals(img.getOriginalFilename())) {
            //文件上传处理
            String oldName = img.getOriginalFilename();
            //得到源文件的扩展名
            String ext = oldName.substring(oldName.lastIndexOf("."));
            //得新的名称
            String newName = UUID.randomUUID() + ext;
            //自己增加，每天上传的文件，对应一个文件夹2020-2-21
            //实际应用中，要考虑各种情况，本次例子中只讲了最简单的情况

            //得到绝对路径
            String realpath = session.getServletContext().getRealPath("/imgurl/") + "/" + newName;
            img.transferTo(new File(realpath));

            return newName;

        } else {
            return "";
        }
    }
}
