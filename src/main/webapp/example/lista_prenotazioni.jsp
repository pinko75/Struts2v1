<!DOCTYPE HTML>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="it.polito.ai.struts2v1.example.service.BookingService" %>
<%@ page import="it.polito.ai.struts2v1.example.service.BookingServiceImpl" %>
<%@ page import="it.polito.ai.struts2v1.example.service.RoomService" %>
<%@ page import="it.polito.ai.struts2v1.example.service.RoomServiceImpl" %>
<%@ page import="it.polito.ai.struts2v1.example.model.Room" %>
<%@ page import="it.polito.ai.struts2v1.example.model.Booking" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%  // List rooms
    RoomService rservice = new RoomServiceImpl();
    List<Room> rooms = rservice.getAllRooms();
    
    // List bookings
    BookingService bservice = new BookingServiceImpl();
    List<Booking> bookings = bservice.getAllBookings();
%>
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
                <td><a href="<s:url action="Profile">
                                  <s:param name="username"><%=session.getAttribute("loggedin") %></s:param>
                             </s:url>">Profile</a></td>
                <td><a href="<s:url value="/example/Book_New.jsp"/>">New Booking</a></td>
                <td><a href="<s:url action="ListMyBookings"/>">My Bookings</a></td>
                <td><a href="<s:url action="Logout"/>">Log out</a></td>
             <%
               }else{ 
             %> 
		      	<td><a href="<s:url action="Login"/>">Log in</a></td>
     			<td><a href="<s:url value="/example/Register.jsp"/>">Register</a></td>
		     <% 	
               } 
             %>
		</tr>
	</table>
    <h2>Meeting Room Booking Service</h2>
    <% for (Room r : rooms) {%>
	<table class="gridtable">
	    <tr>
			<th>Room <%=r.getRoomId() %></th>
		</tr>
		<tr>
			<th>Data</th>
			<th>Intervallo</th>
			<th>Utente</th>
			<th>Utente</th>
		</tr>
		
		<% for(Booking b: bookings) { %>
		     <%  if (b.getRoomId() ==  r.getRoomId()) { %>
				<tr>
				     <td><%=b.getDay() %></td>
				     <td><%=b.getStartTime() %> - <%=b.getEndTime() %></td>
				     <td><%=b.getUserName() %></td>
				     <td><a href="<s:url action="RemoveBooking">
                                  <s:param name="bid"><%=b.getBookingId() %></s:param>
                             </s:url>">Delete</a></td>
				</tr>
		     <% } %> 		
		<br>
		<% } %>
	<% } %>
	</table>
    <br>
    
</body>
</html>