<%--
  Created by IntelliJ IDEA.
  User: jackson
  Date: 2022/9/29
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="login" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${msg} ${register_msg} ${login_msg}</div>
        <p>Username:<input id="username" name="username"
                           type="text" value="${cookie.c_username.value}"></p>

        <p>Password
            :<input id="password" name="password" type="password" value="${cookie.c_password.value}"></p>
        <p>Remember:<input id="remember" name="remember" type="checkbox" value="1"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="register.html">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
