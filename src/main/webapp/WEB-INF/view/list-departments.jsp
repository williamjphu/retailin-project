<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>List of Departments</title>
	<!-- reference our style sheet -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2></h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- put new button: Add Customer -->
			<input type="button" value="Add Department" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
		
			<!--  add our html table here -->
			<table>
				<tr>	
					<th>Department ID </th>
					<th>Department Name</th>
					<th>Additional</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempDept" items="${departments}">
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink2" value="/department/showFormForUpdate">
						<c:param name="deptID" value="${tempDept.departmentID}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink2" value="/department/delete">
						<c:param name="deptID" value="${tempDept.departmentID}" />
					</c:url>					
				
					<tr>
						<td> ${tempDept.departmentID} </td>
						<td> ${tempDept.name} </td>
						<td> ${tempDept.additional} </td>
						<td>
							<!-- display the update link -->
							<a href="${updateLink2}">Update</a> |
							<a href="${deleteLink2}" onclick="if (!(confirm('Are you sure you want to delete this department?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>			
			</table>	
		</div>
	</div>
	<br><br>
	<a href="${pageContext.request.contextPath}/admin">--Back to home</a>
</body>
</html>