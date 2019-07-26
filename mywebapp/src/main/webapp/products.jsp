<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product page here</title>
</head>
<body>
<fieldset name ="Add Product">
<form action = "addProduct">
Name <input name ="name"><br>
Price<input name ="price"><br>
Qoh<input name ="qoh"><br>
<input type ="submit" value ="Add">
</form>

</fieldset>

<table>
<tr><th> Id</th> <th> Name </th> <th> Price </th> <th> QoH </th> <th> Action </th> </tr>
<c:forEach var ="p" items ="${productList }">
<tr>
<td>${p.id}</td> <td> ${p.name} </td> <td> ${p.price} </td> <td> ${t.qoh} </td>  <td> <a href=removeProduct?id=${p.id}>Remove</a> </td>
</tr>
</c:forEach>
</table>
</body>
</html>