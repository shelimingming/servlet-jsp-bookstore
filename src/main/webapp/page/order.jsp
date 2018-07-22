<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <table>
        <tr>
            <th>书名</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${cart.items}" var="item">
            <tr>
                <td>${item.value.book.name}</td>
                <td>${item.value.book.price}</td>
                <td>${item.value.quantity}</td>
                <td><f:formatNumber type="currency" value="${item.value.price}"/></td>
                <td><a href="#">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <table>
        <thead>收货人</thead>
        <tr>
            <th>id</th>
            <th>tel</th>
            <th>address</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${account.consigneeList}" var="consignee">
            <tr>
                <td>${consignee.id}</td>
                <td>${consignee.tel}</td>
                <td>${consignee.address}</td>
                <td><a href="#">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <form action="../do/consignee" method="post">
        <input type="hidden" name="op" value="add">

        <p>tel<input type="text" name="tel"/></p>
        <p>address<input type="text" name="address"/></p>
        <p><input type="reset" name="reset">
            <input type="submit" name="submit"></p>
    </form>
</div>