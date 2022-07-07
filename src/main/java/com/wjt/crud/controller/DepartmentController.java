package com.wjt.crud.controller;

import com.wjt.crud.bean.Department;
import com.wjt.crud.bean.Msg;
import com.wjt.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @ResponseBody
    @RequestMapping("depts")
    public Msg getDepts(){
        List<Department> list = departmentService.getAllDept();
        return Msg.success().add("depts",list);
    }
}
