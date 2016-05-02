<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>Easy Web Input - Login</title>

<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
</head>
<body>
	<div class="container">
	    <div class="row center-content">
	        <div class="col-sm-6 col-md-4 col-md-offset-4">
	        	<% if(request.getAttribute("errorRedirect") != null) { %>
	        		<div class="alert alert-danger alert-dismissable">
	        			<strong>Connection failed :</br>
	        			Incorrect Login and/or Password</strong>
	        		</div>	        	
	        	<%}%>
	            <h1 class="text-center login-title">Sign in to continue to Easy Web Input</h1>
	            <div class="account-wall">
	                <form action="login" class="form-signin" method="post">
	                	<input name="login" type="text" class="form-control" placeholder="Login" required autofocus>
	                	<input name="password" type="password" class="form-control" placeholder="Password" required>
	                	<button class="btn btn-lg btn-primary btn-block" type="submit">
	                    	Sign in</button>
	                </form>
	            </div>
<!--            <a href="#" class="text-center new-account">Create an account </a>-->	        </div>
	    </div>
	</div>
	<script src="js/jquery-1.12.3.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>