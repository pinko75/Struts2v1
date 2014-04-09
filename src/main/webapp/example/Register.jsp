<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Registration</title>
</head>

<body>
<s:form action="register">
    <s:textfield key="username" label="Username" required="true"/>
    <s:password key="password" label="Password" required="true"/>
    <s:password key="confirm_password" label="Confirm Password" required="true"/>
    <s:textfield key="email" label="Email" required="true" />
    <s:textfield key="name" label="Name" required="true"/>

    <s:submit/>
</s:form>
<a href="lista_prenotazioni.jsp">Home</a>
</body>
</html>
