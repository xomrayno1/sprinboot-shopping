<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url value="/register" var="register"></c:url>
<div class="container">
	<div class="account">
		<h2 class="account-in">SIGN UP</h2>

		<div class="container">
			<div class="account">
				<h2 class="account-in">Account</h2>
				<p style="color: red" id="eror_login">${msg}</p>


				<form:form method="POST" action="${register}" modelAttribute="User">
					<div>
						<span>First Name*</span>
						<form:input path="firstName" required="required" />
						
					</div>

					<div>
						<span class="name-in">Last Name*</span>
						<form:input path="lastName" required="required" />
						

					</div>

					
					<div>
						<span class="mail">Email*</span>
						<form:input path="email" required="required" />
						


					</div>

					<div>
						<span class="mail">Username*</span>
						<form:input path="userName" required="required" />
						<p style="color: red" id="eror_username"><form:errors path="userName"/></p>

					</div>

					<div>
						<span class="word">Password*</span>
						<form:password path="passWord" required="required" />
						<p style="color: red" id="eror_passWord"><form:errors path="passWord"/></p>
						

					</div>


					<input id="submit" type="submit" value="login" />
				</form:form>
			</div>
		</div>


		<script type="text/javascript">
			$(document).ready(function() {

			});
		</script>






	</div>
</div>