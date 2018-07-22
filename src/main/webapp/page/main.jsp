<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${bookList}" var="book">
    ${book.id}<br/>
    ${book.name}<br/>
    ${book.description}<br/>
    ${book.price}<br/>
    <a href="do/cart?id=${book.id}&op=add">加入购物车</a><br/>
</c:forEach>