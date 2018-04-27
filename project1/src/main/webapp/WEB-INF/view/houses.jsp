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
		<td>${house.id}</td>
		<td>${house.name}</td>
		<td>${house.address}</td>
		<td>${house.city}</td>
		<td>${house.price}</td>
		<td>${house.e_class}</td>	
	</tr>
</c:forEach>
</table>
<form action="houses" method="get">
	<input type="text" name="minPrice" placeholder="minPrice">
	<input type="text" name="maxPrice" placeholder="maxPrice">
	<input type="text" name="minArea" placeholder="minArea">
	<input type="text" name="maxArea" placeholder="maxArea">
	<select name="type">
	  	<option value="">Tipo</option>
  		<option value="Bilocale">Bilocale</option>
  		<option value="Trilocale">Trilocale</option>
  		<option value="Quadrilocale">Quadrilocale</option>
  		<option value="Plurilocale">Plurilocale</option>
  		<option value="Loft">Loft</option>
	</select>
	<select name="E_class">
  		<option value="">Classe Energetica</option>
  		<option value="A">A</option>
  		<option value="B">B</option>
  		<option value="C">C</option>
  		<option value="D">D</option>
  		<option value="E">E</option>
  		<option value="F">F</option>
  		<option value="G">G</option>
	</select>
	<input type="text" name="city" placeholder="city">
	<input type="text" name="minLatitude" placeholder="minLatitude">
	<input type="text" name="maxLatitude" placeholder="maxLatitude">
	<input type="text" name="minLongitude" placeholder="minLongitude">
	<input type="text" name="maxLongitude" placeholder="maxLongitude">
	<input type="submit" value="cerca"/> 
</form>
</body>
</html>