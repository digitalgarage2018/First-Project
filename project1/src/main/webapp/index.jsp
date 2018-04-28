<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css"  />
		<script src="assets/jquery-1.11.3-jquery.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		<title>WebImmobiliare&reg;</title>
	</head>
	<body>
	<div class="container" style="margin:0 auto; position: center">
		<div id="login-form" style="width:500px; text-align: center;">
			<form action="LoginController" method="post" autocomplete="on">
				<div class="col-md-12">

					<div class="form-group">
						<h2 class="">Log In</h2>
					</div>

					<div class="form-group">
						<hr />
					</div>

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" name="username" class="form-control" placeholder="Enter Name or Email"  maxlength="50"/>
						</div>
						<span class="text-danger"></span>
					</div>

					<%--<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
							<input type="email" name="email" class="form-control" placeholder="Enter Your Email" maxlength="40"/>
						</div>
						<span class="text-danger"></span>
					</div>--%>

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" name="password" class="form-control" placeholder="Enter Password" maxlength="15" />
						</div>
						<span class="text-danger"></span>
					</div>

					<div class="form-group">
						<hr />
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-block btn-primary" name="login">Log In</button>
					</div>


					<%--Enter username : <input type="text" name="username"> <BR>
					Enter password : <input type="password" name="password"> <BR>
					<input type="submit" />--%>

				</div>
			</form>
		</div>


		<div id="signup-form" style="width:500px; text-align: center;">
			<form action="SignUpController" method="post" autocomplete="on">
				<div class="col-md-12">

					<div class="form-group">
						<h2 class="">Sign Up</h2>
					</div>

					<div class="form-group">
						<hr />
					</div>

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" name="username" class="form-control" placeholder="Enter Name"  maxlength="50" required/>
						</div>
						<span class="text-danger"></span>
					</div>

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
							<input type="email" name="email" class="form-control" placeholder="Enter Your Email" maxlength="40" required/>
						</div>
						<span class="text-danger"></span>
					</div>

					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" name="password" id="password" class="form-control" placeholder="Enter Password" maxlength="15" required />
						</div>
						<span class="text-danger"></span>
					</div>

					<div class="form-group">
						<hr />
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-block btn-primary" name="signup">Sign Up</button>
					</div>


					<%--Enter username : <input type="text" name="username"> <BR>
					Enter password : <input type="password" name="password"> <BR>
					<input type="submit" />--%>

				</div>
			</form>
		</div>
	</div>
		
	</body>
</html>