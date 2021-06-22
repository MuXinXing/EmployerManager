<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mx.entity.Employer" %>
<%@ page import="com.mx.dao.EmployerDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: MX
  Date: 2021/6/10
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>员工列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <%
        EmployerDao employerDao=new EmployerDao();
        List<Employer> employerList= employerDao.showAllEmployer();
        session.setAttribute("employerList",employerList);
    %>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>显示所有员工</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="addEmployer.jsp">添加新员工</a>
            <a class="btn btn-primary" href="showLeave.jsp">请假申请</a>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>员工编号</th>
                    <th>员工姓名</th>
                    <th>员工电话</th>
                    <th>员工部门</th>
                    <th>员工职位</th>
                    <th>员工薪水</th>
                    <th>员工请假状态</th>
                </tr>
                </thead>
                <c:forEach var="employerlist" items="${employerList}">
                <tbody>
                    <tr>
                        <td>${employerlist.getEmployerId()}</td>
                        <td>${employerlist.getEmployerName()}</td>
                        <td>${employerlist.getEmployerPhone()}</td>
                        <td>${employerlist.getEmployerDept()}</td>
                        <td>${employerlist.getEmployerPosition()}</td>
                        <td>${employerlist.getEmployerSalary()}</td>
                        <td>${employerlist.getEmployerLeave()}</td>
                        <td></td>
                        <td>
                            <a href="/jsp/updateEmployer.jsp?employerId=${employerlist.getEmployerId()}">更改</a>
                            &nbsp;|&nbsp;
                            <a href="/employer/delete?employerId=${employerlist.getEmployerId()}">开除</a>
                        </td>
                    </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
