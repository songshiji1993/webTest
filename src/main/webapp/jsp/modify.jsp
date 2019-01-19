<%--
  Created by IntelliJ IDEA.
  User: song
  Date: 2018/12/22
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="../update" method="post">
    要修改的书<input type="text" name="bookName"><br>
    新的价格<input type="text" name="price"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
