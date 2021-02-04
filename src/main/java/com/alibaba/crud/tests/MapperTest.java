package com.alibaba.crud.tests;

import com.alibaba.crud.bean.Department;
import com.alibaba.crud.bean.Employee;
import com.alibaba.crud.dao.DepartmentMapper;
import com.alibaba.crud.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 * 推荐spring的项目就使用spring的单元测试，可以自动注入我们需要的组件
 * 1、导入spring test模块
 * 2、使用注解@ContextConfiguration指定spring配置文件的位置
 * 3、@RunWith指定使用哪个单元测试
 * 4、直接Autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testCRUD(){
        //1、插入部门
        //departmentMapper.insert(new Department(1,"开发部"));
        //departmentMapper.insert(new Department(2,"测试部"));
        //departmentMapper.insert(new Department(3,"财务部"));
        //departmentMapper.insert(new Department(null,"人事部"));

        //2、删除部门
        //departmentMapper.deleteByPrimaryKey(2);

        //插入员工
        //employeeMapper.insert(new Employee(null,"贾宝玉","M","jiabaoyu@qq.com",1));

        //批量插入多个员工。批量，使用可以执行批量操作的sqlSession。
        EmployeeMapper mapper = sqlSessionTemplate.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insert(new Employee(null,uid,"M",uid+"@qq.com",1));
        }
        System.out.println("批量插入员工完成");
    }
}
