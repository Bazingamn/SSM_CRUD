package com.alibaba.crud.dao;

import com.alibaba.crud.bean.Employee;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    Employee selectByPrimaryKey(Integer empId);

    Employee selectByPrimaryKeyWithDept(Integer empId);

    List<Employee> selectAll();

    List<Employee> selectAllWithDept();

    int updateByPrimaryKey(Employee record);
}