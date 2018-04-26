<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<title>Login page</title>
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Wellness super</h2>
			</div>
		</div>
		<form action="LoginController" method="post">
			Enter username : <input type="text" name="username"> <BR>
			Enter password : <input type="password" name="password"> <BR>
			<input type="submit" value="Login"/>
		</form>

		<button onclick="document.getElementById('id01').style.display='block'">Sign Up</button>

	
		<div id="id01" class="modal">
		  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
		  <form class="modal-content" action="SignUpController" method="post">
		    <div class="container">
		      <h1>Sign Up</h1>
		      <p>Please fill in this form to create an account.</p>
		      <hr>
		      
		      <label for="email"><b>Username</b></label>
		      <input type="text" placeholder="Enter Username" name="username" required>
		      		
		      <label for="psw"><b>Password</b></label>
		      <input type="password" placeholder="Enter Password" name="password" required>
		      
		      <label for="email"><b>Email</b></label>
		      <input type="text" placeholder="Enter Email" name="email" required>
		      
		      <label for="email"><b>Name</b></label>
		      <input type="text" placeholder="Enter Name" name="name" required>
		      
		      <label for="email"><b>Surname</b></label>
		      <input type="text" placeholder="Enter Surname" name="surname" required>
		      
		      <label for="email"><b>Born date</b></label>
		      <input type="text" placeholder="Enter Born date" name="born_date" required>
		      
		      <label for="email"><b>Born place</b></label>
		      <input type="text" placeholder="Enter Born place" name="born_place" required>

		
		      <!--  <label>
		        <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Remember me
		      </label> 
		
		      <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>
		
				-->
		      <div class="clearfix">
		        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
		        <button type="submit" class="signup">Sign Up</button>
		      </div>
		    </div>
		  </form>
		</div> 
	</body>
</html>