<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${account!=null}">
        欢迎${account.username}
        <a href="do/account?op=logout">退出登录</a>
    </c:when>
    <c:otherwise>
        <a href="page/loginAndRegister.jsp">登录注册</a>
    </c:otherwise>
</c:choose>