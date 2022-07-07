package com.wjt.crud.service;

import com.wjt.crud.bean.Department;
import com.wjt.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getAllDept() {
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }
}
