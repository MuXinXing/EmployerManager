<%--
  Created by IntelliJ IDEA.
  User: MX
  Date: 2021/6/10
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" href="../static/css/style.css">

<%--    <%
        String msg=(String)session.getAttribute("msg");
        if("".equals(msg)&&msg==null){
        } else{
    %>
    <script type="text/javascript">
        alert("<%=msg%>");
    </script>
        <%
        }
        %>--%>
</head>

<body>
<div class="dowebok">
    <div class="container">
        <div class="left">
            <div class="login">引力之舟</div>
            <div class="eula">欢迎光临，请输入您的员工账号和密码登录</div>
        </div>
        <div class="right">
            <svg viewBox="0 0 320 300">
                <defs>
                    <linearGradient inkscape:collect="always" id="linearGradient" x1="13" y1="193.49992" x2="307"
                                    y2="193.49992" gradientUnits="userSpaceOnUse">
                        <stop style="stop-color:#ff00ff;" offset="0" id="stop876" />
                        <stop style="stop-color:#ff0000;" offset="1" id="stop878" />
                    </linearGradient>
                </defs>
                <path d="m 40,120.00016 239.99984,-3.2e-4 c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35 -25.00016,35 h -239.99984 c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 h 215 c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 h -190 c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 h 168.57143" />
            </svg>
            <div class="form">
                <form action="/employer/employerLogin" method="post">
                    <label for="employerName">员工账号</label>
                    <input type="text" id="employerName" name="employerName">
                    <label for="employerPhone">密码</label>
                    <input type="password" id="employerPhone" name="employerPhone">
                    <input type="submit" id="submit" value="登陆">
                </form>
<%--                <div style="margin-bottom: 10px">
                    <a href="/jsp/bossLogin.jsp" class="btn btn-primary">老总登录</a>
                </div>--%>

                    <a href="/jsp/bossLogin.jsp">
                        老总登录
                    </a>
            </div>
        </div>
    </div>
</div>
<script src="../static/js/anime.min.js"></script>
<script src="../static/js/index.js"></script>
</body>
</html>
