<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Employees</title>
<!-- Resources link -->
<jsp:include page="resources.jsp" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<jsp:include page="menu.jsp" />
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Employee Data
				</div>
				<div class="card-body">
					<!-- Search bar -->
					<div>
						<form>
							<div class="row">
								<div class="form-group">
									<input name="keyword" value="${param.keyword}"
										placeholder="Search" type="text" class="form-control">
								</div>
								<div class="form-group">
									<input type="submit" value="Search" class="btn btn-secondary">
								</div>
							</div>
						</form>
					</div>
					<!-- Table content -->
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
									<th>Dept. ID</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${users}">
									<!-- construct an "update" link with customer id -->
									<c:url var="updateURL" value="/user/update">
										<c:param name="employeeID" value="${user.empID}" />
									</c:url>

									<!-- construct an "delete" link with customer id -->
									<c:url var="deleteURL" value="/user/delete">
										<c:param name="employeeID" value="${user.empID}" />
									</c:url>

									<tr>
										<td><fmt:formatNumber pattern="00000000" value="${user.empID}" /></td>
										<td>${user.lastName}</td>
										<td>${user.firstName}</td>
										<td>${user.password}</td>
										<td>${user.email}</td>
										<td>${user.phoneNumber}</td>
										<td>${user.enabled}</td>
										<td>${user.authority}</td>
										<td>${user.departmentID}</td>
										<td>
											<!-- display the update link --> <a href="${updateURL}">Update</a>|<a
											href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<a href="${pageContext.request.contextPath}/user/add"
						class="btn bg-success text-white">Add Employee</a> <a
						href="${pageContext.request.contextPath}/department/list"
						class="btn bg-success text-white">View/Edit Department</a> <a
						href="${pageContext.request.contextPath}/payroll/list"
						class="btn bg-success text-white">View/Edit Payroll</a> <a
						href="${pageContext.request.contextPath}/bank-account/list"
						class="btn bg-success text-white">View/Edit Bank Account</a> <a
						href="${pageContext.request.contextPath}/"
						class="btn bg-secondary text-white">Back Home</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
