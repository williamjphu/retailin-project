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
		<h3>Save User info</h3>
		<form:form action="saveUser" modelAttribute="user" method="POST">
			<form:hidden path="empID" />			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td><label>Password:</label></td>
						<td><form:input path="password" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" /></td>
					</tr>
					<tr>
						<td><label>Phone number:</label></td>
						<td><form:input path="phoneNumber" /></td>
					</tr>
					<tr>
						<td><label>Enabled:</label>
						<td><form:input path="enabled" value="1"/></td>
					</tr>
					<tr>
						<td><label>ROLE:</label><td>
						<form:select path="authority">
							<form:option value="ROLE_EMPLOYEE">EMPLOYEE</form:option>
							<form:option value="ROLE_ADMIN">ADMIN</form:option>
						</form:select>
					</tr>
					<tr>
						<td><label>Department:</label><td>
						<form:select path="dp=${departments.getDepartmentID()}">
							<c:forEach var="tempDept" items="${departments}">
								<form:option value="${tempDept}">${tempDept.departmentID} - ${tempDept.name}</form:option>
							</c:forEach>	
						</form:select>
	<%-- 					<c:param name="deptID" value="${departments.departmentID}" /> --%>
					</tr>
					
					<tr>
						<td><input type="submit" value="Save changes" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/user/list">Back to List</a>
		</p>
	</div>
</body>
</html>