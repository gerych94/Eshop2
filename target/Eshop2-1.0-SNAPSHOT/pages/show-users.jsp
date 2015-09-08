<%@ page import="model.Client" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 23.08.2015
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="scc/bootstrap.css" rel="stylesheet">
    <link href="css/table.css" rel="stylesheet">
    <title>Eshop2</title>
</head>
<body>

     <%List<Client> clientList= (List<Client>) request.getAttribute("clientList");%>

     <table class="table table-bordered">
         <caption>Information Of Users</caption>
         <thead>
         <tr>
             <th>Id</th>
             <th>Name</th>
             <th>Login</th>
             <th>Password</th>
             <th>Email</th>
             <th>Phone</th>
         </tr>
         </thead>
        <tbody>
     <%for (Client i:clientList){%>
     <tr>
     <td><%=i.getId_client()%></td>
      <td><%=i.getName()%></td>
      <td><%=i.getLogin()%></td>
      <td><%=i.getPassword()%></td>
      <td><%=i.getEmail()%></td>
      <td><%=i.getPhone()%></td>
     </tr>
     <%}%>
        </tbody>
     </table>

</body>
</html>
