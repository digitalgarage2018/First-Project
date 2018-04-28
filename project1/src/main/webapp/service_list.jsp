<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Servizi</title>
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
    <link href="css/services.css" rel="stylesheet" type="text/css" media="all" />

    <script type="text/javascript" src="js/memenu.js"></script>
    <script>$(document).ready(function(){$(".memenu").memenu();});</script>
    <script src="js/simpleCart.min.js"> </script>
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

                <!--			<div class="search-box">
                                <div id="sb-search" class="sb-search">
                                    <form action="#" method="post">
                                        <input class="sb-search-input" placeholder="Enter your search term..." type="search"  id="search">
                                        <input class="sb-search-submit" type="submit" value="">
                                        <span class="sb-icon-search"> </span>
                                    </form>
                                </div>
                            </div>
                            -->

                <!-- search-scripts -->

                <!-- //search-scripts -->

                <div class="ca-r">
                    <div class="cart box_1">
                        <a href="index.jsp">
                            <div class="total">
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
                <h1><a href="index.jsp"> Super Relax </a></h1>
            </div>
            <div class=" h_menu4">
                <ul class="memenu skyblue">
                    <li><a class="color1" href="#">Prodotti</a> </li>
                    <li class="grid"><a class="color2" href="ServiceController">Servizi</a> </li>

                    <%

						if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {
					%>

                    <li><a class="color4" href="login.jsp">Accedi</a></li>
                    <li><a class="color4" href="sign_up.jsp">Registrati</a></li>

                        <%}

					else {
					%>
                    <li><a class="color4" href="LogoutController" onclick="if (!confirm('Sei sicuro di voler uscire? ')) return false"
                           action="">Logout</a></li>
					<li><a class="color8" href="EthereumController">Wallet</a></li>
                    <%
						}
					%>
                    

            </div>
            </ul>
        </div>

        <div class="clearfix"> </div>
    </div>
</div>
</div>

<!-- products -->
<!-- grow -->
<div class="grow">
    <div class="container">
        <h2> La lista dei nostri servizi </h2>
    </div>
</div>
<!-- grow -->

<div class="pro-du">
    <div class="container">
        <div class="col-md-15 product1">
            <div class=" bottom-product">


                <c:forEach items="${services}" var="service">
                    <div class="col-md-3 bottom-cd simpleCart_shelfItem product-card">
                        <div class="product-at ">
                            <a href=""><img class="img-responsive" src="${service.sr_image}" alt="">
                                <div class="pro-grid">
                                    <span class="buy-in">Buy Now</span>
                                </div>
                            </a>
                        </div>
                        <p class="tun">
                            <span>
                                <c:out value="${service.sr_name}" />
                            </span><br>
                            <c:out value="${service.sr_type}" />
                        </p>
                        <div class="ca-rt">
                            <a href="#" class="item_add"><p class="number item_price"><i> </i>
                                <%
                                    if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {
                                %>
                                <p></p>
                                <%}

                                else {
                                %>



                                $ <c:out value="${service.sr_price}" /> </p></a>
                            <%
                                }
                            %>
                        </div>
                        <!-- <div class="clearfix"></div> -->


                    </div>
                </c:forEach>

                <!-- <div class="clearfix"></div> -->
            </div>
        </div>
    </div>
</div>

</body>
</html>
