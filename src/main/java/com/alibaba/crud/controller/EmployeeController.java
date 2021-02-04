package com.alibaba.crud.controller;

import com.alibaba.crud.bean.Employee;
import com.alibaba.crud.bean.Msg;
import com.alibaba.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理员工CRUD请求
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public Msg checkuser(String empName){

    }

    /**
     * 保存员工
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public Msg saveEmp(Employee employee){
        employeeService.saveEmp(employee);
        return Msg.success();
    }

    /**
     * 以json数据返回查询的员工
     * @return
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //分页查询，引入pageHelper
        PageHelper.startPage(pn,10);
        List<Employee> employees = employeeService.getAll();
        //使用pageinfo包装查询后的结果,封装了详细的分页信息
        PageInfo pageInfo = new PageInfo(employees,5);
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 查询员工数据（分页查询）
     * @return
     */
    //@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //分页查询，引入pageHelper
        PageHelper.startPage(pn,10);
        List<Employee> employees = employeeService.getAll();
        //使用pageinfo包装查询后的结果,封装了详细的分页信息
        PageInfo pageInfo = new PageInfo(employees,5);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}
