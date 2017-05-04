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
    <script src="js/myjs.js" type="text/javascript"></script>
    <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
      
      
      
    
    
      <!--<script src="js/myjs.js" ></script>-->


</head>
<body>
<%-- Code to specify Header section of the page--%>
<div id="header" >
    <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home.jsp"><img src="css/5_White_logo_on_black_145x73.png" height="45"/></a>
    </div>
    
      <ul class="nav navbar-nav">
      <li class="active"><a href="home.jsp">Home</a></li>
    </ul>
      <c:if test="${user.username == null}">
            <ul class="nav navbar-nav navbar-right">
            <li><a href="/login.jsp" data-toggle="modal" data-target="#signup-modal"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="/login.jsp" data-toggle="modal" data-target="#login-modal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>      
        </ul>
          </c:if>
      <%--<c:if test="${sessionScope.user != null}">--%>
      <c:if test="${sessionScope.usertype == 'Buyer'}" >
      <%--<c:if test="${user.usertype == 'Buyer'}">--%>
      <ul class="nav navbar-nav navbar-right">
          <li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome, ${user.username}</a></li>
      <li><a href="#"  data-toggle="modal" data-target="#cartModal">Cart <span class="badge">${sessionScope.icount}</span></a></li>
      <li><a href="UserController?action=logout"> Log Out</a></li>
    </ul>
      </c:if>
      <%--<c:if test="${cookie.userTypeCookie.value=='Seller'}">--%>
      <c:if test="${sessionScope.usertype == 'Seller'}" >
      <ul class="nav navbar-nav navbar-right">
          <li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome, ${user.username}</a></li>
      <li><a href="#"  data-toggle="modal" data-target="#cartModal">Past Entries<span class="badge">5</span></a></li>
      <li><a href="UserController?action=logout"> Log Out</a></li>
    </ul>
      </c:if>
      <c:if test="${sessionScope.usertype == 'Admin'}" >
      <ul class="nav navbar-nav navbar-right">
          <li><a href="#"><span class="glyphicon glyphicon-user"></span>Welcome, ${user.username}</a></li>
      <li><a href="FoodController?action=admin" >Control Panel </a></li>
      <li><a href="UserController?action=logout"> Log Out</a></li>
    </ul>
      </c:if>
  </div>
</nav>

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" style="display: none;">
    <div class="modal-dialog" style="margin-top: 20%">
				<div class="loginmodal-container">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h1>Login to Your Account</h1><br>
				  <form action="UserController?action=login" method="post">
                                                                                       <input type="text" name="username" placeholder="Username" required>
					<input type="password" name="password" placeholder="Password" required>
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </form>
					<p>${message}</p>
				  <div class="login-help">
					<a href="#" data-toggle="modal" data-target="#signup-modal">Register</a>
                                        
				  </div>
				</div>
			</div>
		  </div>

    <!--Sign Up form-->
    <div class="modal fade" id="signup-modal" tabindex="-1" role="dialog" style="display: none;">
    <div class="modal-dialog" style="margin-top: 20%">
				<div class="loginmodal-container">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h1>Sign Up for an Account</h1><br>
                                        <form action="UserController?action=register" method="post">
                                            <input type="text" name="username" placeholder="Username" required>
                                                                                        <input type="text" name="email" placeholder="Email" required>
                                                                                        <select name="usertype"><option value="Buyer">Buyer</option><option value="Seller">Seller</option></select>                                                                                                        
					<input type="password" name="password" placeholder="Password" required>
                                                                                        <input type="password" name="rePassword" placeholder="Confirm Password" required>
					<input type="submit" name="register" class="login loginmodal-submit" value="Sign Up">
                                        
				  </form>
                                        <p>${message}</p>
				</div>
			</div>
		  </div>
    <!--End of Sign Up Form-->
    
    <!--Start of cart modal-->
    <div class="modal fade" id="cartModal" tabindex="-1" role="dialog" aria-labelledby="cart" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                 <h4 class="modal-title" id="myModalLabel">Your Food Cart</h4>

            </div>
            <div class="modal-body">
                <table class="table table-hover" id="shopping_table">
                    <thead>
                        <tr>
                            <td class="active">Product Image</td>
                            <td class="active">Product Name</td>
                            <td class="active">Posted By</td>
                            <td class="active">Price</td>
                            <td class="active"></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="active">
                                <img src="css/img2.jpg " width="60">
                            </td>
                            <td class="active">${cart_item}</td>
                            <td class="active"><strong> aseller </strong>
                            </td>
                            <td class="active">$ <span class="price_row"> ${curr_price} </span>
                            </td>
                            <td class="active" onclick="remove_from_cart(this)" data-id="2577" style="cursor:pointer;">×</td>
                        </tr>
                        </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <a class="btn btn-primary" href="OrderServlet?action=buy">Proceed to buy </a><i class="glyphicon glyphicon-chevron-right"></i>
            </div>
        </div>
    </div>
</div>
    <!--End of cart modal-->

</div>
                                