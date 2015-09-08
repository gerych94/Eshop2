<%@ page import="model.Admin" %>
<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 17.08.2015
  Time: 11:40
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
      <%Admin admin=(Admin)request.getAttribute("admin"); %>


      <div class="nav">
       <div class="container" >
           <ul class="pull-left">
               <li><a href="/pages/add-user.jsp">Add User</a></li>
               <li><a href="/pages/add-product.jsp">Add Product</a></li>
               <li><a href="/FindUserId">Find User By Id</a> </li>
               <li><a href="/FindProductID">Find Product By Id</a></li>
               <li><a href="/FindUserLogin">Find User By Login</a></li>
               <li><a href="/FindProductName">Find Product By Name</a></li>
           </ul>
           <ul class="pull-right">
               <li><a href="/pages/add-bucket.jsp">Add Bucket</a></li>
               <li><a href="/ShowAllProduct">All Product</a></li>
               <li><a href="/ShowAllUser">All User</a></li>
           </ul>
       </div>
       </div>
        <div class="jumbotron">
            <div class="container">
                <h1> Hello admin <%=admin.getLogin()%> in Online store Eshop2</h1>
            </div>
        </div>

</body>
</html>
