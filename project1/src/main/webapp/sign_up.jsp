<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:a="http://xmlns.jcp.org/jsf/passthrough"
	xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
	<title> Registrati </title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<!-- <script src="js/jquery.min.js"></script> -->
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
	<!-- <script type="text/javascript" src="js/memenu.js"></script> -->
	<!-- <script>$(document).ready(function(){$(".memenu").memenu();});</script> -->
	<!-- <script src="js/simpleCart.min.js"> </script> -->
</head>

<body>

<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="header-top">
				<a href="index.jsp"> <i class="glyphicon glyphicon-home" style="font-size:20px;color:white"></i>  </a>

			</div>

		</div>
	</div>
</div>


<div class="grow">
	<div class="container">
		<h1 align="center"> Registrati </h1>
	</div>
</div>

 <br>
 <h4 style="color:red;"><%
   if(null!=request.getAttribute("errorMessage"))
   {
       out.println(request.getAttribute("errorMessage"));
   }
%></h4>

<!--content-->
<div class=" container">
	<div class=" register">


		<form action="SignUpController" method="post">
			<div class="col-md-6 register-top-grid">
				<h3>Informazioni personali</h3>
				<div>
					<span>Nome</span>
					<input type="text" name="name" required>
				</div>
				<div>
					<span>Cognome</span>
					<input type="text" name="surname" required>
				</div>
				<div>
					<span>Data di nascita </span>
				 <input
						 type="text"
						 name="born_date"
						 id="born_date"
						 pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
						 onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Data inserita non valida: ripetta il formato richiesto (YYYY-MM-DD) ed inserisci una data di nascita valida' : '');"
						 placeholder="YYYY-MM-DD"
						 required>
				</div>
				<div>
					<span>Luogo di nascita </span>
					<input type="text" name="born_place" required>
				</div>

				<a class="news-letter" href="#">
					<label class="checkbox"><input type="checkbox" required><i> </i>
					Dichiaro di essere in condizioni di buona salute
					</label>
				</a>
			</div>
			<div class="col-md-6 register-top-grid">
				<h3> Informazioni d'accesso </h3>

				<div>
					<span> Nome utente</span>
					<input type="text" name="username" required>
				</div>
				<div>
					<span> Email </span>
					  <input type="text" name="email" pattern="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})" title="example@gmail.com" placeholder="example@gmail.com" required>
					<!--  <input type="email" name="email" value="" required />-->
				</div>
			</div>
			<div class="col-md-6 register-bottom-grid">
				<div>
					<span> Password </span>
					<input id="password" name="password" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Inserisci almeno 6 caratteri' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;" required>
				</div>
				<div>
					<span> Conferma Password </span>
					
					<input id="password_two" name="password_two" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Le password inserite non corrispondono. Riprova' : '');" required>
				</div>

				<input type="submit" value="submit">

			</div>
			<div class="clearfix"> </div>
		</form>


	</div>
</div>

</body>
</html>
