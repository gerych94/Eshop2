<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 21.08.2015
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eshop2</title>
</head>
<body>
<form action="/AddProduct" method="post" enctype="multipart/form-data">
  Name of Product : <input name="name" type="text"></br>
  Product Type :<input name="productType" type="text"></br>
  Price : <input name="price" type="text"></br>
  File: <input name="image" type="file">
  <input value="OK" type="submit">
</form>
</body>
</html>
