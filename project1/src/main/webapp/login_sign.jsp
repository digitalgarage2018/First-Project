<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus, input[type=password]:focus {
    background-color: #ddd;
    outline: none;
}

/* Set a style for all buttons */
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 20%;
    opacity: 0.9;
}

button:hover {
    opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 20%;
}

/* Add padding to container elements */
.container {
    padding: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: #474e5d;
    padding-top: 50px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 80%; /* Could be more or less, depending on screen size */
}

/* Style the horizontal ruler */
hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
}
 
/* The Close Button (x) */
.close {
    position: absolute;
    right: 35px;
    top: 15px;
    font-size: 40px;
    font-weight: bold;
    color: #f1f1f1;
}

.close:hover,
.close:focus {
    color: #f44336;
    cursor: pointer;
}

/* Clear floats */
.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
    .cancelbtn, .signupbtn {
       width: 100%;
    }
}
</style>
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