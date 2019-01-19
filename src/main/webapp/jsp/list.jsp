<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2018/12/22
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="com.Book" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% List<Book> books = (List<Book>) request.getAttribute("books"); %>
<table class="listtable">
    <caption>所有书籍:</caption>
    <tr class="listheader">
        <th>书名</th>
        <th>价格</th>
 </tr>
    <%for(Book book:books){ %>
    <tr>
        <td><%=book.getName()%></td>
        <td><%=book.getPrice()%></td>
        <%--<td>--%>
            <%--<a class="clickbutton" href="addDeleteDepartment.do?code=delete&departmentid=<%=dept.getDepartmentid() %>">删除</a>--%>
        <%--</td>--%>
    </tr>
    <%}%>
</table>

</body>
</html>
