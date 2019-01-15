<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2018/12/21
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="com.User" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%
    User user = (User)request.getAttribute("user");
    String s = (String)request.getAttribute("s");
//    System.out.println(s);
//    System.out.println(user.toString());
%>
33 欢迎，您的用户名为：
<%=user.getName()%><br>
<a href="/m1/jsp/admin.jsp">管理书本</a>




</body>
</html>
