<%--
  Created by IntelliJ IDEA.
  User: vitaliy
  Date: 03.03.16
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>


<jsp:useBean id="Client" class="model.Client" scope="session">
  Hello user <jsp:getProperty name="Client" property="name"></jsp:getProperty>
</jsp:useBean>

</body>
</html>
