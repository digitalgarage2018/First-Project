

<!DOCTYPE html>
<html>
<head>
    <title> Login </title>
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
        <h1 align="center"> Benvenuto in SuperRelax </h1>
    </div>
</div>


<!--content-->
<div align="center" class="container">
    <div class="account">
        <div class="account-pass">
            <div class="col-md-2 left-account">
                <!-- colonna sinistra vuota-->
            </div>
            <div class="col-md-8 account-top">

                <h3> Accedi </h3>
                <form action="LoginController" method="post">

                    <div>
                        <span align="left" id="reauth-email" class="reauth-email">Username</span>
                        <input type="text" name="username" id="inputEmail" class="login_box"  required autofocus>

                    </div>
                    <div>
                        <span align="left">Password</span>
                        <input type="password" name="password" id="inputPassword" class="login_box" required>
                    </div>
                    <input type="submit" value="Accedi">
                </form>

                <br> <br>
                Non sei ancora registrato? <br>

                <form action="sign_up.jsp">
                    <input type="submit" value="Registrati">
                </form>

            </div>

            <div class="col-md-2 left-account">
                <!-- colonna destra vuota-->
            </div>

            <div class="clearfix"> </div>
        </div>
    </div>

</div>


</body>
</html>
