<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="calculate" method = "get">
	num1 <input name=n1 ><br>
	num2 <input name=n2 ><br>
	<!--  prod_name <input name = p_name> <br>
	prod_price <input name = p_price> <br>
	prod_qoh <input name = p_qoh> <br> -->
	<input name=op value="+" type="submit">
	 <input name=op value="-" type="submit">
	<input name= op value="*" type="submit">
	<input name=op value="/" type="submit"> 
	</form>
<c:if test="${not(empty(result))}">
Result : ${param.n1} ${param.op} ${param.n2} =  ${result}
</c:if>

</body>
</html>