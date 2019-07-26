<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product page here</title>
</head>
<body>
<fieldset name ="Add Product">

<form:form method="POST"  commandName="product" >
Name <form:input path="name"/> <form:errors path='*' cssClass = "errors" /> <br>
Price <form:input path="price"/> <br>
QoH <form:input path="qoh"/> <br>
<input type="submit" value="Add">
</form:form>

</fieldset>

<table>
<tr><th> Id</th> <th> Name </th> <th> Price </th> <th> QoH </th> <th> Action </th> </tr>
<c:forEach var ="p" items ="${productList }">
<tr>
<td>${p.id}</td> <td> ${p.name} </td> <td> ${p.price} </td> <td> ${p.qoh} </td>  <td> <a href=removeProduct?id=${p.id}>Remove</a> </td>
</tr>
</c:forEach>
</table>
</body>
</html>