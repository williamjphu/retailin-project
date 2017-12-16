<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Please login to continue</title>
<link
	href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/css/sb-admin.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>
</head>
<body class="shoppingimage">
	<div class="container">
		<div class="vert-offset-top-12">
			<h1 class="text-white text-center">
				RetailIn <small class="text-muted">The best retail store solution</small>
			</h1>
		</div>
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Login</div>
			<div class="card-body">
				<form:form
					action="${pageContext.request.contextPath}/authenticateUser"
					method="POST">
					<c:if test="${param.error != null}">
						<i>Sorry! You entered invalid username/password</i>
						<br>
						<i>Try again!</i>
					</c:if>
					<div class="form-group">
						<label for="username">Employee ID</label> <input
							class="form-control" id="username" name="username" type="text"
							placeholder="Enter your employee ID">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input class="form-control"
							id="password" name="password" type="password"
							placeholder="Password">
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<input class="btn btn-primary btn-block" type="submit"
						value="Login" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
