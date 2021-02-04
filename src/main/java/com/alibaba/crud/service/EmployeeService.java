package com.alibaba.crud.service;

import com.alibaba.crud.bean.Employee;
import com.alibaba.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAll(){
        List<Employee> employees = employeeMapper.selectAllWithDept();
        return employees;
    }

    /**
     * 保存员工
     * @param employee
     */
    public void saveEmp(Employee employee){
        employeeMapper.insert(employee);
    }

    /**
     * 检验用户名是否可用
     * @param empName
     * @return
     */
    public boolean checkUser(String empName){
        employeeMapper.
        return false;
    }
}
