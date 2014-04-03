<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Registration</title>
</head>

<body>
<s:form action="register">
    <s:textfield key="username"/>
    <s:password key="password" />
    <s:password key="confirm_password" />
    <s:textfield key="email" />

    <s:submit/>
</s:form>
<a href="lista_prenotazioni.jsp">Home</a>
</body>
</html>
