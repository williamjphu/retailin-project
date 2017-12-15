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
					<i class="fa fa-table"></i> Customer Data
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Customer ID</th>
									<th>Phone Number</th>
									<th>Last Name</th>
									<th>First Name</th>
									<th>Email</th>
									<th>Zip Code</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="tempCustomer" items="${customers}">
									<!-- construct an "update" link with customer id -->
									<c:url var="updateURL" value="/customer/update">
										<c:param name="custID" value="${tempCustomer.customerID}" />
									</c:url>

									<!-- construct an "delete" link with customer id -->
									<c:url var="deleteURL" value="/customer/delete">
										<c:param name="custID" value="${tempCustomer.customerID}" />
									</c:url>

									<tr>
										<td>${tempCustomer.customerID}</td>
										<td>${tempCustomer.phoneNumber}</td>
										<td>${tempCustomer.lastName}</td>
										<td>${tempCustomer.firstName}</td>
										<td>${tempCustomer.email}</td>
										<td>${tempCustomer.zipCode}</td>
										<td>
											<!-- display the update link --> <a href="${updateURL}">Update</a>
											| <a href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<input type="button" value="Add User"
						onclick="window.location.href='add'; return false;"
						class="btn bg-success text-white" />
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
