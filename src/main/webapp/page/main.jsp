<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<link type="text/css" rel="styleSheet"  href="css/main.css" />
<ul class="bookList">
    <c:forEach items="${bookList}" var="book">
        <li class="book">
            <div>
                <img src="<%=basePath%>${book.image.url}"/>
                    <%--${book.image.url}<br/>--%>
                    <%--${book.id}<br/>--%>
                    ${book.name}<br/>
                    <%--${book.description}<br/>--%>
                    ${book.price}<br/>
                <a href="do/cart?id=${book.id}&op=add">加入购物车</a><br/>
            </div>
        </li>
    </c:forEach>
</ul>