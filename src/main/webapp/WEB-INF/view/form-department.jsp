<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save User Info</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>RetailIn</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Department info</h3>
		<form:form action="saveDepartment" modelAttribute="depart" method="POST">
			<form:hidden path="departmentID" />			
			<table>
				<tbody>
					<tr>
						<td><label>Name of the Department:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="additional" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Save changes" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/department/list">Back to List</a>
		</p>
	</div>
</body>
</html>