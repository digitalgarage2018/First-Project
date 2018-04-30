<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LOGIN + SIGN UP</title>
		<script type="text/javascript" src="<%=request.getContextPath()%>/scripts/validator.js"></script>
	</head>
	<body>
	
		<div>
			<h1>Log In:</h1>
			
			<form action="LoginController" method="post">
				
				<table>
					<tr>
						<td><label for="username">Enter username:</label></td>
						<td><input type="text" name="username" value="_pass or email_"/></td>
					</tr>
					<tr>
						<td><label for="password">Enter password:</label></td>
						<td><input type="text" name="password" /></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" name="type"
							value="Log in" style="width: 100%" /></td>
					</tr>
				</table>
			
			</form>
		</div>
		
		<br><br><br>
		
		<div>
			<h1>Sign Up:</h1>
			
			<form action="SignUpController" method="post" onsubmit="return validateSignUpForm(this)">
			
				<table>
					<tr>
						<td><label for="username">Enter username:</label></td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td><label for="email">Enter email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td><label for="password">Enter password:</label></td>
						<td><input type="text" name="password" /></td>
					</tr>
					<tr>
						<td><label for="confirm">Confirm password:</label></td>
						<td><input type="text" name="confirm" /></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" name="type"
							value="Sign Up" style="width: 100%" /></td>
					</tr>
				</table>
				
			</form>
			
		</div>
		
		
	</body>
</html>