<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/21
  Time: 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>myway图书商城</title>

    <link type="text/css" rel="styleSheet" href="../css/index.css"/>
    <link type="text/css" rel="styleSheet" href="../css/manage.css"/>
</head>
<body>
<div id="body">
    <div id="main">
        <iframe id="content" src="" name="content" frameborder=0 scrolling="no"></iframe>
    </div>
</div>
</body>
</html>

<script type="text/javascript">

    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

    console.log(getQueryString("contentPage"));

    document.getElementById("content").setAttribute("src", getQueryString("contentPage"));
</script>
</html>
