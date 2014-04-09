<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="it.polito.ai.struts2v1.example.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
  User u = (User)session.getAttribute("user_profile");
 
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Profile</title>
</head>
<body>
 
    <h1>Profile page</h1>
    <p> <b> Username: </b><%  out.print(u.getUsername()); %>
    <p> <b> Name: </b><%  out.print(u.getName()); %>
    <p> <b> Email: </b><%  out.print(u.getEmail()); %>
    <br/>
    <br/>
    <a href="lista_prenotazioni.jsp">Home</a>
</body>
</html>