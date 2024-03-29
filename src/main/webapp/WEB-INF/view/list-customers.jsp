<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Customers Page</title>
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
					<i class="fa fa-table"></i> Customer Data
				</div>
				<div class="card-body">
					<!-- Search bar -->
					<div>
						<form>
							<div class="row">
								<div class="form-group col col-md-6">
									<input name="keyword" value="${param.keyword}"
										placeholder="Search" type="text" class="form-control">
								</div>
								<div class="form-group">
									<input type="submit" value="Search" class="btn btn-secondary">
								</div>
							</div>
						</form>
					</div>
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
										<td><a href="${updateURL}">Update</a>|<a
											href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<a href="${pageContext.request.contextPath}/customer/add"
						class="btn bg-success text-white">Add Customer</a> <a
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
