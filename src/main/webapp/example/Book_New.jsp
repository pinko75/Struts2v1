<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="it.polito.ai.struts2v1.example.service.RoomService" %>
<%@ page import="it.polito.ai.struts2v1.example.service.RoomServiceImpl" %>
<%@ page import="it.polito.ai.struts2v1.example.model.Room" %>
<%@ page import="java.util.List" %>
<%
    RoomService rservice = new RoomServiceImpl();
    List<Room> rooms = rservice.getAllRooms();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/cupertino/jquery-ui.css">

<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
  $(function() {
    $( "#datepicker" ).datepicker({
      showOtherMonths: true,
      selectOtherMonths: true
    });
  });
</script>
</head>
<body>
    <form method="GET" action="BookNew">
       <p>Room: <select name="room">
                   <% for (Room r : rooms) {%>
                     <option value="<%=r.getRoomId() %>"><%=r.getRoomId() %></option>
                   <% } %>
                 </select>  
       <p>Date: <input name="day" type="text" id="datepicker"></p>
       <p>Slot: <select name="slot">
                          <option value="8:00:00-9:00:00">8:00-9:00</option>
                          <option value="9:00:00-10:00:00">9:00-10:00</option>
                          <option value="10:00:00-11:00:00">10:00-11:00</option>
                          <option value="11:00:00-12:00:00">11:00-12:00</option>
                          <option value="12:00:00-13:00:00">12:00-13:00</option>
                          <option value="13:00:00-14:00:00">13:00-14:00</option>
                          <option value="15:00:00-16:00:00">15:00-16:00</option>
                          <option value="16:00:00-17:00:00">16:00-17:00</option>
                          <option value="17:00:00-18:00:00">17:00-18:00</option>
                      </select>
       </p>
         
       <input type="submit" value="Submit">
    </form>
</body>
</html>