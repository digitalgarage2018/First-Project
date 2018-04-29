<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>UniMarina Economia - Log in</title>
	</head>
	<body>
		<form action="LoginController" method="post">
			Enter Email : <input type="text" name="username"> <BR>
			Enter Password : <input type="password" name="password"> <BR>
			<input type="submit" value="Accedi"/>
		</form>

		<form action="LoginController" method="get">
			<input type="submit" value="Registrati"/>
		</form>
	</body>
</html>