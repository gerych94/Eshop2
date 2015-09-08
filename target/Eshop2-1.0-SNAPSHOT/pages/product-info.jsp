<%@ page import="model.Product" %>
<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 23.08.2015
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eshop2</title>
</head>
<body>
        <%Product product= (Product) request.getAttribute("product");%>
         ID: <%=product.getId_product()%>
         Name: <%=product.getName()%>
         TypeProduct: <%=product.getProductType()%>
         Price: <%=product.getPrice()%>


</body>
</html>
