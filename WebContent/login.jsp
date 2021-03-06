<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<header>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/login&registration.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</header>
<body class="lbody">
	<div class="container">
		<div class="row well well-lg l">
		    <div class="login">
		    	Log In
	    	</div>
			<div class="col-sm-3">
			 	<p>Use other accounts</p>
					You can also sign in using your Facebook Account or Google Account<br>
				<div>
					<button type="button" class="btn btn-primary"><a href="https://www.facebook.com/">Login with Facebook</a></button>
				</div><br>
				<div>
					<button type="button" class="btn btn-danger"><a href="https://mail.google.com/">Login with Google</a></button>
				</div>
			</div>
			<div class="col-sm-4">
			<p>Using your account</p>
				<form class="form" method="post" action="Login">
					<div class="form-group">
					<div>
					  <input type="text" class="form-control" name="email" placeholder="Email address" id="usr">
					</div>
					</div>
					<div class="form-group">
					  <div>
					  	<input type="password" class="form-control" name="password" placeholder="Password" id="pwd">
					  </div><br>
					  <div>
						<input type="submit" name="submit" value="Sign In" id="submit" class="btn btn-info">
					  </div>
					  <div>
					  <a class="text-primary">Forgot your password ?</a></div>
					  <a class="text-primary" href="RegistrationPage.jsp">If you don't have account , click here to Sign up</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>