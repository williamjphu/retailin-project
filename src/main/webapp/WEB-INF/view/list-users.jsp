<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>List of Employees</title>
	<!-- reference our style sheet -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Welcome Here</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- put new button: Add Customer -->
			<input type="button" value="Add User" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
		
			<!--  add our html table here -->
			<table>
				<tr>
					<th>Username</th>		
					<th>Last Name</th>
					<th>First Name</th>
					<th>Password</th>
					<th>Email</th>
					<th>Phone number</th>
					<th>Enabled</th>
					<th>Authority</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempUser" items="${users}">
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink2" value="/user/showFormForUpdate">
						<c:param name="employeeID" value="${tempUser.empID}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink2" value="/user/delete">
						<c:param name="employeeID" value="${tempUser.empID}" />
					</c:url>					
				
					<tr>
						<td> ${tempUser.username} </td>
						<td> ${tempUser.lastName} </td>
						<td> ${tempUser.firstName} </td>
						<td> ${tempUser.password} </td>
						<td> ${tempUser.email} </td>
						<td> ${tempUser.phoneNumber} </td>
						<td> ${tempUser.enabled} </td>
						<td> ${tempUser.authority} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink2}">Update</a> |
							<a href="${deleteLink2}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>			
			</table>	
		</div>
	</div>
	<br><br>
	<a href="${pageContext.request.contextPath}/">--Back to home</a>
</body>
</html>