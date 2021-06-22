<%@ page import="com.mx.entity.Employer" %>
<%@ page import="com.mx.dao.EmployerDao" %><%--
  Created by IntelliJ IDEA.
  User: MX
  Date: 2021/6/13
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <%
    %>
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>员工界面</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="leaveEmployer.jsp?employerId=<%=session.getAttribute("employerId")%>">请假</a>
            <a class="btn btn-primary" href="showMyLeave.jsp">我的请假</a>
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
                    <th>你的薪水</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><%=session.getAttribute("employerId")%></td>
                    <td><%=session.getAttribute("employerName")%></td>
                    <td><%=session.getAttribute("employerPhone")%></td>
                    <td><%=session.getAttribute("employerDept")%></td>
                    <td><%=session.getAttribute("employerPosition")%></td>
                    <td><%=session.getAttribute("employerSalary")%></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
