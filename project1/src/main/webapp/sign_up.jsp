
<!DOCTYPE html>
<html>
<head>
	<title> Sign Up </title>
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.min.js"></script>
	<!-- Custom Theme files -->
	<!--theme-style-->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!--//theme-style-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Mattress Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!--fonts-->
	<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
	<!-- start menu -->
	<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
	<script type="text/javascript" src="js/memenu.js"></script>
	<script>$(document).ready(function(){$(".memenu").memenu();});</script>
	<script src="js/simpleCart.min.js"> </script>
</head>

<body>

<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="header-top">
				Torna alla home
			</div>

		</div>
	</div>
</div>


<div class="grow">
	<div class="container">
		<h1 align="center"> Sign Up </h1>
	</div>
</div>



<!--content-->
<div class=" container">
	<div class=" register">


		<form action="SignUpController" method="post">
			<div class="col-md-6 register-top-grid">
				<h3>Personal infomation</h3>
				<div>
					<span>First Name</span>
					<input type="text" name="name" required>
				</div>
				<div>
					<span>Last Name</span>
					<input type="text" name="surname" required>
				</div>
				<div>
					<span> Born date </span>
					<input type="text" name="born_date" required>
				</div>
				<div>
					<span> Born place </span>
					<input type="text" name="born_place" required>
				</div>

				<a class="news-letter" href="#">
					<label class="checkbox"><input type="checkbox" required><i> </i>
					Dichiaro di essere in condizioni di buona salute
					</label>
				</a>
			</div>
			<div class="col-md-6 register-top-grid">
				<h3> Login information </h3>

				<div>
					<span> Username</span>
					<input type="text" name="username" required>
				</div>
				<div>
					<span> Email </span>
					<input type="text" name="email" required>
				</div>
			</div>
			<div class="col-md-6 register-bottom-grid">
				<div>
					<span> Password </span>
					<input type="password" name="password" required>
				</div>
				<div>
					<span> Confirm Password </span>
					<input type="password" name="confirmpassword" required>
				</div>

				<input type="submit" value="submit">
				<!-- <button type="submit" class="signup">Sign Up</button> -->

			</div>
			<div class="clearfix"> </div>
		</form>


	</div>
</div>

</body>
</html>
