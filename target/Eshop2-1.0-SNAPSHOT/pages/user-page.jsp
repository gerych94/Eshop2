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
    <title>Eshop2</title>
</head>
<body>
         <%Client client= (Client) request.getAttribute("client");%>

      Hello client <%=client.getName()%> in online Store Eshop2

</body>
</html>
