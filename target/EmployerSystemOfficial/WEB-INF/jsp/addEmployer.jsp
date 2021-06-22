<%--
  Created by IntelliJ IDEA.
  User: MX
  Date: 2021/6/9
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新员工</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>添加新员工</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="/employer/add" method="post">
        <div class="form-group">
            <label for="employerName">员工姓名</label>
            <input type="text" class="form-control" id="employerName" name="employerName">
        </div>

        <div class="form-group">
            <label for="employerPhone">员工电话</label>
            <input type="text" class="form-control" id="employerPhone" name="employerPhone">
        </div>

        <div class="form-group">
            <label for="employerDept">员工部门</label>
            <input type="text" class="form-control" id="employerDept" name="employerDept">
        </div>

        <div class="form-group">
            <label for="employerPosition">员工职位</label>
            <input type="text" class="form-control" id="employerPosition" name="employerPosition">
        </div>

        <div class="from-group">
            <label for="employerSalary">员工薪水</label>
            <input type="text" class="form-control" id="employerSalary" name="employerSalary">
        </div>
        <button type="submit" class="btn btn-default">确定</button>
    </form>
</div>
</body>
</html>
