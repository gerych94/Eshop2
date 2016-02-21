<%@ page import="model.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 21.08.2015
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/admin.css" rel="stylesheet">
    <title>Eshop2</title>
</head>
<body>
   <%Client client= (Client) request.getAttribute("client");%>
<div class="nav">
    <div class="container" >
        <ul class="pull-left">
            <li><a href="/FindUserId">Find User By Id</a> </li>
            <li><a href="/FindProductID">Find Product By Id</a></li>
            <li><a href="/FindUserLogin">Find User By Login</a></li>
            <li><a href="/FindProductName">Find Product By Name</a></li>
        </ul>
        <ul class="pull-right">
            <li><a href="/ShowAllProduct">All Product</a></li>
            <li><a href="/ShowAllUser">All User</a></li>
        </ul>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <h1> Hello user <%=client.getName()%></h1>
    </div>
</div>
</body>
</html>
