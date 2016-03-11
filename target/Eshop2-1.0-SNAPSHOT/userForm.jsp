<%--
  Created by IntelliJ IDEA.
  User: vitaliy
  Date: 03.03.16
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<html>
<head>
    <title></title>
</head>
<body>

<jsp:useBean id="Client" class="model.Client" scope="session">
    <jsp:setProperty name="Client" property="name" value="Vitaliy"></jsp:setProperty>
</jsp:useBean>


<form action="/HelloWorld" method="get" name="contactFrom">
  <li>Login: <input name="login" type="text"/></li>
  <li>Password: <input name="password" type="password"/></li>
   <li> <button class="submit" type="submit">OK</button></li>
</form>
</body>
</html>
