<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart here</title>
</head>
<body>
<% 
String [] selectedcars = (String[]) session.getAttribute("selectedcars");
String [] selectedbooks = (String[])session.getAttribute("selectedbooks");
String [] selectedbikes = request.getParameterValues("bikes");//why?? getparam and why bikes??

		
		%>
		
<h4>Selected Books</h4>
<ul>
    <%for(String aBook : selectedbooks) 
    {
    %>
        <li><%=aBook %></li>
    <%
    }
    %>
</ul>
<h4>Selected Cars</h4>
<ul>
    <%for(String aCar : selectedcars) 
    {
    %>
        <li><%= aCar %></li>
    <%
    }
    %>
</ul>

<h4>Selected Bikes</h4>
<ul>
    <%for(String aBike : selectedbikes) 
    {
    %>
        <li><%= aBike %></li>
    <%
    }
    %>
</ul>
</body>
</html>