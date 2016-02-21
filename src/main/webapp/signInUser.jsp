<%@ page import="java.util.Random" %>
<%--
  Created by IntelliJ IDEA.
  User: vitaliy
  Date: 20.02.16
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="css/main.css" rel="stylesheet">
    <title></title>
</head>
<body>
       <%Random random=new Random();
          int a=random.nextInt(10);
          session.setAttribute("parametr",a);%>
<form class="contact_form" action="../SignInUser",method="get" name="contact_form" >
  <ul>
    <li>
      <h2>SignIn User</h2>
      <span class="required_notification"> * Required Fields</span>
    </li>
    <li>Login:<input name="login" type="text" required/></li>
    <li> Password:<input name="password" type="password" required /></li>
    <li>Input 2+<%=a%>:<input name="captcha" type="text" required></li>
    <li> <button class="submit" type="submit">OK</button></li>
  </ul>
</form>

</body>
</html>
