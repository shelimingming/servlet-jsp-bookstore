<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>myway图书商城</title>

    <link type="text/css" rel="styleSheet"  href="css/index.css" />
</head>

<body>
<%--<h2>Hello World!</h2>
${bookList}--%>

<div id="body">
    <div id="search">

    </div>

    <div id="navigation">

    </div>

    <div id="main">
        <jsp:include page="page/main.jsp"/>
    </div>
    <div id="user">
        <jsp:include page="page/user.jsp"/>
    </div>
    <div id="cart">
        <jsp:include page="page/cart.jsp"/>
    </div>
</div>

</body>
</html>
