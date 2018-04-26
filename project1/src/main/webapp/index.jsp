<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>Massaggi e saune</title>
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

</head>
<body>
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="social">
				<ul>
					<li><a href="#"><i class="facebok"> </i></a></li>
					<li><a href="#"><i class="twiter"> </i></a></li>
					<li><a href="#"><i class="inst"> </i></a></li>
					<li><a href="#"><i class="goog"> </i></a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<div class="header-left">

				<div class="search-box">
					<div id="sb-search" class="sb-search">
						<form action="#" method="post">
							<input class="sb-search-input" placeholder="Enter your search term..." type="search"  id="search">
							<input class="sb-search-submit" type="submit" value="">
							<span class="sb-icon-search"> </span>
						</form>
					</div>
				</div>

				<!-- search-scripts -->

				<!-- //search-scripts -->

				<div class="ca-r">
					<div class="cart box_1">
						<a href="checkout.html">
							<h3> <div class="total">
								<span class="simpleCart_total"></span> </div>
								<img src="images/cart.png" alt=""/></h3>
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">Carrello Vuoto</a></p>

					</div>
				</div>
				<div class="clearfix"> </div>
			</div>

		</div>
	</div>
	<div class="container">
		<div class="head-top">
			<div class="logo">
				<h1><a href="index.html">Welness Madness</a></h1>
			</div>
			<div class=" h_menu4">
				<ul class="memenu skyblue">
					<li><a class="color8" href="Wallet.jsp">Wallet</a></li>
					<li><a class="color1" href="#">Prodotti</a>

					</li>
					<li class="grid"><a class="color2" href="#">Servizi</a>

					</li>

					<%
						if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {
					%>

					<li><a class="color4" href="login_sign.jsp">Login</a></li>

					<%}

					else {
					%>
					<li><a class="color4" href="login_sign.jsp">Logout</a></li>

					<%
						}
					%>

					<li><a class="color6" onclick="document.getElementById('id01').style.display='block'">Sign Up</a></li>

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
				</ul>
			</div>

			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<div class="banner">
	<div class="container">
		<script src="js/responsiveslides.min.js"></script>
		<script>
            $(function () {
                $("#slider").responsiveSlides({
                    auto: true,
                    nav: true,
                    speed: 500,
                    namespace: "callbacks",
                    pager: true,
                });
            });
		</script>
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider">
				<li>

					<div class="banner-text">
						<h3>Rilassati con i nostri servizi  </h3>
						<p> Scegli uno dei nostri servizi e passa indimenticabili momenti di relax </p>

					</div>

				</li>
				<li>

					<div class="banner-text">
						<h3>Ce ne sono molti</h3>
						<p>Se usufruirai dei nostri servizi potrai acquistare speciali articoli</p>


					</div>

				</li>
				<li>
					<div class="banner-text">
						<h3>Sed ut perspiciatis</h3>
						<p>Lorem Ipsum is not simply random text. Contrary to popular belief, It has roots in a piece of classical Latin literature from 45 BC.</p>


					</div>

				</li>
			</ul>
		</div>

	</div>
</div>


</body>
</html>
</html>