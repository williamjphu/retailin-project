<%-- <% response.sendRedirect("user/list"); %> --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>

<!DOCTYPE html>
<html>

<head>
	<title>Home Page </title>
	<!-- reference our style sheet -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<h1>This is the home page!</h1>
	<a href="${pageContext.request.contextPath}/user/list">Go to user list</a>

	<h3>Your username is: <sec:authentication property="principal.username" /> </h3>
	<h3>Your role is: <sec:authentication property="principal.authorities"/> </h3>
	<form action="logout" method="POST">
		<input type="submit" value="Logout" />
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>