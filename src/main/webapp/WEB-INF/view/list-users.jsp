<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Home</title>
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

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<jsp:include page="menu.jsp"/>
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Employee Data
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>RetailIn ID</th>
									<th>Last Name</th>
									<th>First Name</th>
									<th>Password</th>
									<th>Email</th>
									<th>Phone number</th>
									<th>Enabled</th>
									<th>Authority</th>
									<th>Department ID</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${users}">
									<!-- construct an "update" link with customer id -->
									<c:url var="updateURL" value="/user/updateEmployee">
										<c:param name="employeeID" value="${user.empID}" />
									</c:url>

									<!-- construct an "delete" link with customer id -->
									<c:url var="deleteURL" value="/user/deleteEmployee">
										<c:param name="employeeID" value="${user.empID}" />
									</c:url>

									<tr>
										<td>${user.empID}</td>
										<td>${user.lastName}</td>
										<td>${user.firstName}</td>
										<td>${user.password}</td>
										<td>${user.email}</td>
										<td>${user.phoneNumber}</td>
										<td>${user.enabled}</td>
										<td>${user.authority}</td>
										<td>${user.departmentID}</td>
										<td>
											<!-- display the update link --> <a href="${updateURL}">Update</a>
											| <a href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<input type="button" value="Add User"
						onclick="window.location.href='addUser'; return false;"
						class="btn bg-success text-white" /> <a
						href="${pageContext.request.contextPath}/department/list"
						class="btn bg-success text-white">View/Edit Category</a> <a
						href="${pageContext.request.contextPath}/payroll/list"
						class="btn bg-success text-white">View/Edit Payroll</a> <a
						href="${pageContext.request.contextPath}/bank-account/list"
						class="btn bg-success text-white">View/Edit Bank Account</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
