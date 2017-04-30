<%-- 
    Document   : login
    Created on : Apr 27, 2017, 10:40:59 PM
    Author     : anusha
--%>

<%@ include file="header.jsp" %>
<a href="#" data-toggle="modal" data-target="#login-modal">Login</a>

<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" style="display: none;">
    	  <div class="modal-dialog">
				<div class="loginmodal-container">
					<h1>Login to Your Account</h1><br>
				  <form>
					<input type="text" name="user" placeholder="Username">
					<input type="password" name="pass" placeholder="Password">
					<input type="submit" name="login" class="login loginmodal-submit" value="Login">
				  </form>
					
				  <div class="login-help">
					<a href="#">Register</a> - <a href="#">Forgot Password</a>
				  </div>
				</div>
			</div>
		  </div>
<%@ include file="footer.jsp" %>