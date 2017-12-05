<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>List Users</title>

	<!-- reference our style sheet -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>ADMIN PAGE</h2>
		</div>
	</div>
	<a href="${pageContext.request.contextPath}/user/list">View/Edit Employee's information</a><br>
	<a href="${pageContext.request.contextPath}/authority/list">View/Edit Employee's authorization</a>
</body>
</html>