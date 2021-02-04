# SSM_CRUD简单整合

## 一、功能点

1. 分页

2. 数据校验

   ​	jQuery前端校验+JSR303后端校验

3. Ajax

4. Rest风格的URI：使用HTTP协议请求方式的动词，来表示对资源的操作(GET查询，POST新增，PUT修改，DELETE删除)。

## 二、技术点

- 基础框架-SSM
- 数据库-MySQL
- 前端框架-Bootstrap
- 项目的依赖管理-Maven
- 分页-pagehelper
- 逆向工程-MyBatis Generator

## 三、基础环境搭建

### 3.1、创建一个Maven工程

### 3.2、引入项目依赖的jar包

- spring
- springmvc
- mybatis
- 数据库连接池、驱动包
- 其它（jstl、servlet-api、junit）

### 3.3、引入bootstrap前端框架

### 3.4、编写ssm整合的配置文件

- web.xml
- spring-applicationContext.xml
- springmvc
- mybatis
- 使用mybatis的逆向工程生成对应的bean及mapper

### 3.5、测试mapper

## 四、查询

1. 访问index.jsp页面
2. index.jsp页面发送查询员工列表请求
3. EmployeeController接受请求，查出员工数据
4. 返回给list.jsp页面进行展示
5. URI：/emps

## 五、查询-Ajax

1. index.jsp页面直接发送ajax请求进行员工分页数据的查询
2. 服务器将查出的数据以json字符串的形式返还给浏览器
3. 浏览器收到json字符串，可以使用js对json进行解析，使用js通过dom增删改查改变页面
4. 返回json，实现客户端的无关性（Android、iOS、浏览器）

## 六、新增-Ajax

1. 在index.jsp页面中点击“新增”按钮
2. 弹出新增对话框
3. 部门信息去数据库查询部门列表，显示在对话框中
4. 用户输入数据完成保存

## 七、Rest风格URI

/emp/{id}	 	GET			  查询员工

/emp				POST	  	  保存员工

/emp/{id}	 	PUT			  修改员工

/emp/{id}	 	DELETE		删除员工