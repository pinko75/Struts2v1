<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>

<style type="text/css">
table.gridtable {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
</head>

<body>
    <table class="gridtable">
	    <tr colspan=5 align=right>
	        <% if (session.getAttribute("loggedin") != null){
             %>
                <td>Welcome back, <%=session.getAttribute("loggedin") %></td>
                <td><a href="<s:url action="Profile"/>">Profile</a></td>
                <td><a href="<s:url action="ListMyBookings"/>">My Bookings</a></td>
                <td><a href="<s:url action="Logout"/>">Log out</a></td>
             <%
               }else{ 
             %> 
		      	<td><a href="<s:url action="Login"/>">Log in</a></td>
     			<td><a href="<s:url action="Register"/>">Register</a></td>
		     <% 	
               } 
             %>
		</tr>
	</table>
    <h2>Prenotazioni</h2>
	<table class="gridtable">
	    <tr>
			<th>Sala 1</th>
		</tr>
		<tr>
			<th>Data</th>
			<th>Intervallo</th>
			<th>Utente</th>
		</tr>
		<tr>
			<td>21/1/2014</td>
			<td>8:00 - 9:00</td>
			<td>John Smith</td>
		</tr>
		<tr>
			<td>3/4/2014</td>
			<td>12:00 - 13:00</td>
			<td>Frank Grand</td>
		</tr>
	</table>
    <br>
    <table class="gridtable">
	    <tr>
			<th>Sala 2</th>
		
		</tr>
		<tr>
			<th>Data</th>
			<th>Intervallo</th>
			<th>Utente</th>
		</tr>
		<tr>
			<td>21/1/2014</td>
			<td>8:00 - 9:00</td>
			<td>John Smith</td>
		</tr>
		<tr>
			<td>3/4/2014</td>
			<td>12:00 - 13:00</td>
			<td>Frank Grand</td>
		</tr>
	</table>
	<br>
	<table class="gridtable">
	    <tr>
			<th>Sala 3</th>
		
		</tr>
		<tr>
			<th>Data</th>
			<th>Intervallo</th>
			<th>Utente</th>
		</tr>
		<tr>
			<td>21/1/2014</td>
			<td>8:00 - 9:00</td>
			<td>John Smith</td>
		</tr>
		<tr>
			<td>3/4/2014</td>
			<td>12:00 - 13:00</td>
			<td>Frank Grand</td>
		</tr>
	</table>
	<br>
	<table class="gridtable">
	    <tr>
			<th>Sala 4</th>
		
		</tr>
		<tr>
			<th>Data</th>
			<th>Intervallo</th>
			<th>Utente</th>
		</tr>
		<tr>
			<td>21/1/2014</td>
			<td>8:00 - 9:00</td>
			<td>John Smith</td>
		</tr>
		<tr>
			<td>3/4/2014</td>
			<td>12:00 - 13:00</td>
			<td>Frank Grand</td>
		</tr>
	</table>
    <br>
     
</body>
</html>