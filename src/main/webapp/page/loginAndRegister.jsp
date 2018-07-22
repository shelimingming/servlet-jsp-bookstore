<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录注册</title>
</head>
<body>
<div id="login">
    <h3>用户登录</h3>
    <c:choose>
        <c:when test="${login_error!=null}">
            ${login_error}
        </c:when>
    </c:choose>
    <form action="../do/account" method="post">
        <input type="hidden" name="op" value="login">
        <p>username<input type="text" name="username"/></p>
        <p>password<input type="password" name="password"/></p>
        <p><input type="reset" name="reset">
            <input type="submit" name="submit"></p>
    </form>
</div>
<div id="register">
    <h3>用户注册</h3>
    <c:choose>
        <c:when test="${register_error!=null}">
            ${register_error}
        </c:when>
    </c:choose>
    <form action="../do/account" method="post">
        <input type="hidden" name="op" value="register">
        <p>username<input type="text" name="username"/></p>
        <p>password<input type="password" name="password"/></p>
        <p>email<input type="text" name="email"/></p>
        <p><input type="reset" name="reset">
            <input type="submit" name="submit"></p>
    </form>
</div>
</body>
</html>
