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
        Object employerId=session.getAttribute("employerId");
        EmployerLeaveDao employerLeaveDao=new EmployerLeaveDao();
        List<EmployerLeave> leaveList= employerLeaveDao.showMyLeave(String.valueOf(employerId));
        session.setAttribute("leaveList",leaveList);
    %>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>我的请假</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="guestMenu.jsp">主页</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>你的编号</th>
                    <th>你的姓名</th>
                    <th>你的电话</th>
                    <th>你的部门</th>
                    <th>你的职位</th>
                    <th>请假理由</th>
                    <th>是否批准</th>
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
                        <td>${list.getEmployerLeaveStatus()}</td>
                        <td>
                            <a href="/leave/delete?employerId=${list.getEmployerId()}">撤销</a>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
