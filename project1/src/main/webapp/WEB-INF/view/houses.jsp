<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach items="${houses}" var="house">
	<tr>
	<td>${house.indirizzo}</td>
	<td>${house.costo}</td>
	</tr>
</c:forEach>
</table>
<form action="houses" method="get">
	<input type="text" name="minPrice" placeholder="minPrice">
	<input type="text" name="maxPrice" placeholder="maxPrice">
	<input type="text" name="minSize" placeholder="minSize">
	<input type="text" name="maxSize" placeholder="maxSize">
	<input type="text" name="minLatitude" placeholder="minLatitude">
	<input type="text" name="maxLatitude" placeholder="maxLatitude">
	<input type="text" name="minLongitude" placeholder="minLongitude">
	<input type="text" name="maxLongitude" placeholder="maxLongitude">
	<input type="submit" value="cerca"/> 
</form>
</body>
</html>