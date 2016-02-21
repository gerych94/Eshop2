<%@ page import="model.Bucket" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 21.08.2015
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eshop2</title>
</head>
<body>
        <%Bucket bucket= (Bucket) session.getAttribute("bucket");%>
            Products in Bucket : <%=bucket.getId_Bucket()%></br>
             <%List<Product> productList=bucket.getBucket();
             for (Product p:productList){%>
               <%=p.getName()%></br>
             <%}%>
         <form action="../AddOrder" ,method="get">
           <%session.setAttribute("bucket",bucket);%>
          Login of User: <input name="login" type="text"/></br>
               <input value="OK" type="submit" >
         </form>
</body>
</html>
