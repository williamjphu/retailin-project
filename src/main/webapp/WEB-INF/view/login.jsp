<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login Page</title>
	</head>
	<body>
		<h3>Please login before entering  to RetailIn...</h3>
		<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
			<!-- Show error message -->
 			<c:if test="${param.error != null}" >
		 		<i>Sorry! You entered invalid username/password</i><br>
				<i>Try again!</i>
			</c:if>

			<h3>Username: <input type="text" name="username" /></h3>
			<h3>Password: <input type="password" name="password" /></h3>
		
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<input type="submit" value="Login" />
		</form:form>
	</body>
</html>
