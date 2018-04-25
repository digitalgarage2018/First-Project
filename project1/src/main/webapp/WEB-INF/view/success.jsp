<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
		<title>Insert title here</title>
	</head>
	<body>
		<a href="LogoutController">Logout</a> |  
		<a href="ProfileController">Profile</a>  
		<%
    		if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {
		%>
		You are not logged in<br/>
		<a href="login_sign.jsp">Please Login</a>
		<%} else {
		%>
		Welcome <%=session.getAttribute("user")%>
		<a href="index.jsp">Go home</a>
		<%
		    }
		%>
		<!--  Welcome ${requestScope['user'].username}.  -->

	</body>
</html>