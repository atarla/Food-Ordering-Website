<%--
  Author: anusha
  Created on: 4/27/2017  6:49 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%-- title of the Page--%>
    <title>Food Ordering Website</title>
    
      
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
    
    <script src="https://npmcdn.com/tether@1.2.4/dist/js/tether.min.js"></script>
    <!--<script src="js/bootstrap.js" ></script>-->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/bootstrap3-typeahead.js" type="text/javascript"></script>
    <script src="js/myjs.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!--<link href="/css/bootstrap.min.css" rel="stylesheet">-->

    <%-- importing CSS stylesheet --%>
        <link href="css/mycss.css" rel="stylesheet" />
        
    <link href="css/bootstrap-grid.css" rel="stylesheet" />
    <link href="css/bootstrap-reboot.css" rel="stylesheet" />
    
    <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
      
      
      
    
    
      <!--<script src="js/myjs.js" ></script>-->


</head>
<body>
<%-- Code to specify Header section of the page--%>
<div id="header" >
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Cool Name</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="/login.jsp" data-toggle="modal" data-target="#signup-modal">SignUp</a></li>
      <li><a href="/login.jsp" data-toggle="modal" data-target="#login-modal">Login</a></li>
      
    </ul>
    
  </div>
</nav>

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" style="display: none;">
    <div class="modal-dialog" style="margin-top: 20%">
				<div class="loginmodal-container">
					<h1>Login to Your Account</h1><br>
				  <form>
					<input type="text" name="user" placeholder="Username">
					<input type="password" name="pass" placeholder="Password">
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </form>
					
				  <div class="login-help">
					<a href="#" data-toggle="modal" data-target="#signup-modal">Register</a> - <a href="#">Forgot Password</a>
				  </div>
				</div>
			</div>
		  </div>

    <!--Sign Up form-->
    <div class="modal fade" id="signup-modal" tabindex="-1" role="dialog" style="display: none;">
    <div class="modal-dialog" style="margin-top: 20%">
				<div class="loginmodal-container">
					<h1>Login to Your Account</h1><br>
				  <form>
					<input type="text" name="user" placeholder="Username">
                                                                                                        <input type="text" name="usertype" placeholder="User Type">
					<input type="password" name="pass" placeholder="Password">
                                                                                                         <input type="password" name="pass" placeholder="Confirm Password">
					<input type="submit" name="register" class="login loginmodal-submit" value="Sign Up">
				  </form>
				
				</div>
			</div>
		  </div>
    <!--End of Sign Up Form-->

</div>

