package com.wjt.crud.service;

import com.wjt.crud.bean.Employee;
import com.wjt.crud.bean.EmployeeExample;
import com.wjt.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public  Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    public List<Employee> getAll() {
        EmployeeExample example = new EmployeeExample();
        example.setOrderByClause("emp_id");
        List<Employee> employees = employeeMapper.selectByExampleWithDept(example);
        return employees;
    }

    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }

    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmp(Integer id) {
        // TODO Auto-generated method stub
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        // TODO Auto-generated method stub
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andEmpIdIn(ids);
        employeeMapper.deleteByExample(example);
    }
}
