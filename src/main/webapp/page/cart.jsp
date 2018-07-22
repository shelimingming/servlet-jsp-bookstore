<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>购物车</h3>
<c:forEach items="${cart.items}" var="item">
    图书id：${item.value.book.id}<br/>items
    图书名称:${item.value.book.name}<br/>
    数量:${item.value.quantity}<br/>
    <a href="do/cart?id=${item.value.book.id}&op=del">删除</a>
    <br/>
</c:forEach>

总计：${cart.total}<br/>

<a href="page/manage.jsp?contentPage=order.jsp">提交订单</a>