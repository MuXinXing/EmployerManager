<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mx.entity.Employer" %>
<%@ page import="com.mx.dao.EmployerDao" %>
<%@ page import="com.mx.entity.EmployerLeave" %>
<%@ page import="com.mx.dao.EmployerLeaveDao" %>
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
        EmployerLeaveDao employerLeaveDao=new EmployerLeaveDao();
        List<EmployerLeave> leaveList= employerLeaveDao.showLeaves();
        session.setAttribute("leaveList",leaveList);
    %>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>显示所有员工请假申请</small>
                </h1>
            </div>
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
                    <th>请假理由</th>
                </tr>
                </thead>
                <c:forEach var="list" items="${leaveList}">
                    <tbody>
                    <tr>
                        <td>${list.getEmployerId()}</td>
                        <td>${list.getEmployerName()}</td>
                        <td>${list.getEmployerPhone()}</td>
                        <td>${list.getEmployerDept()}</td>
                        <td>${list.getEmployerPosition()}</td>
                        <td>${list.getEmployerLeave()}</td>
                        <td>
                            <a href="/leaves/agree?employerId=${list.getEmployerId()}">同意</a>
                            |
                            <a href="/leave/refuse?employerId=${list.getEmployerId()}">拒绝</a>
                            |
                            <a href="#">下载请假文件</a>

                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
