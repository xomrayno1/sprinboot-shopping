<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>

	<div class="container">
		<div class="account">
			<h2 class="account-in">SIGN IN	</h2>
			<p style="color: red">${msg}</p>
				<form>
				
				<div> 	
					<span class="mail">Username*</span>
					<input type="text"> 
				</div>
				<div> 
					<span class="word">Password*</span>
					<input type="password">
				</div>				
					<input type="submit" value="Login">  <a href="#">Quên Mật Khẩu ?</a>
				</form>
				
		</div>
	</div>