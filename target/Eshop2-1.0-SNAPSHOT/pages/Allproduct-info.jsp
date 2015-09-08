<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 23.08.2015
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Eshop2</title>
</head>
<body>
<%List<Product> productList=(List<Product>)request.getAttribute("productList");%>

<%for (Product i:productList){%>
ID: <%=i.getId_product()%><br/>
Name <%=i.getName()%><br/>
Price <%=i.getPrice()%><br/>
ProductType<%=i.getProductType()%><br/>
<%}%>

</body>
</html>
