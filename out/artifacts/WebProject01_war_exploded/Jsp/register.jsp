<%--
  Created by IntelliJ IDEA.
  User: 33380
  Date: 2022/3/21
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>注册页面</title>
</head>
<body>
<form id="register" name="register" action="UserServlet?method=register" method="post">
    用户名：<input type="text" name="username" id="username"><br>
    密码：<input type="password" id="password" name="password"><br>
    <input type="submit" value="注册">

</form>
</body>
</html>
