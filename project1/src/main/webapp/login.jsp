<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css" media="all" />

<!------ Include the above in your HEAD tag ---------->

<script src="https://use.typekit.net/ayg4pcz.js"></script>

<script>try{Typekit.load({ async: true });}catch(e){}</script>

<div class="container">
    <h1 class="welcome text-center">Welcome to <br> Ice Code</h1>
    <div class="card card-container">
        <h2 class='login_title text-center'>Login</h2>
        <hr>

        <form class="form-signin">
            <span id="reauth-email" class="reauth-email"></span>
            <p class="input_title">Email</p>
            <input type="text" id="inputEmail" class="login_box" placeholder="user01@IceCode.com" required autofocus>
            <p class="input_title">Password</p>
            <input type="password" id="inputPassword" class="login_box" placeholder="******" required>
            <div id="remember" class="checkbox">
                <label>

                </label>
            </div>
            <button class="btn btn-lg btn-primary" type="submit">Login</button>
        </form><!-- /form -->
    </div><!-- /card-container -->
</div><!-- /container -->