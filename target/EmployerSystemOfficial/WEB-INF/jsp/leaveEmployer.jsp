<%--
  Created by IntelliJ IDEA.
  User: MX
  Date: 2021/6/13
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请假申请</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>请假申请</small>
                </h1>
            </div>
        </div>
    </div>
    <form class="form-horizontal" action="" method="post">

        <input style="display:none" name="employerId" value="<%=request.getParameter("employerId")%>">

    <div class="form-group">
        <label for="employerLeaveReason" class="col-sm-2 control-label">请假缘由</label>
        <div class="col-sm-8">
            <input type="email" class="form-control" id="employerLeaveReason" placeholder="请假内容" name="employerLeaveReason">
        </div>
    </div>
    <br/>
    <div class="form-group">
        <label for="employerLeaveFile" class="col-sm-2 control-label">请假文件</label>
        <div class="col-sm-8">
            <input type="file" id="employerLeaveFile" name="employerLeaveFile">
            <p class="help-block">请假文件说明:纸质申请文件</p>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-8">
            <div class="checkbox">
                <label>
                    <input type="checkbox">我同意公司请假条例
                </label>
            </div>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">提交</button>
        </div>
    </div>
    </form>
</div>
</body>
</html>
