<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
		<title>Insert title here</title>
	</head>
	<body>

		Benvenuto : <b>${requestScope['newStudent'].surname} ${requestScope['newStudent'].name} </b>
		<br>
		Le credenziali per l'accesso alla piattaforma sono le seguenti:
		<br>
		<ul>
			<li>Email Istituzionale: ${requestScope['newStudent'].istitutionalEmail}</li>
			<li>Matricola: ${requestScope['newStudent'].badgeNumber}</li>
		</ul>
		<br>
		<p> <a href="index.jsp">Effettua il Login</a> </p>


	</body>
</html>