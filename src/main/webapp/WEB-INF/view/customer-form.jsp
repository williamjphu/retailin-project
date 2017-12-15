<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Employee Information</title>
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">RetailIn</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Checkout"><a class="nav-link"
					href="${pageContext.request.contextPath}/cart"> <i
						class="fa fa-fw fa-shopping-cart"></i> <span class="nav-link-text">Checkout</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Inventory"><a class="nav-link"
					href="${pageContext.request.contextPath}/item/list"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">Inventory</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Customers"><a class="nav-link"
					href="${pageContext.request.contextPath}/customer/list"> <i
						class="fa fa-fw fa-user-circle"></i> <span class="nav-link-text">Customers</span>
				</a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Employees"><a class="nav-link"
						href="${pageContext.request.contextPath}/user/list"> <i
							class="fa fa-fw fa-black-tie"></i> <span class="nav-link-text">Employees</span>
					</a></li>
				</sec:authorize>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
				</a></li>
			</ul>
		</div>
	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card card-register mx-auto mt-5">
				<div class="card-header">Customer Information Form</div>
				<div class="card-body">
					<form:form action="save" modelAttribute="customerForm"
						method="POST">
						<form:hidden path="customerID" />
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="phoneNumber">Phone number</label>
									<form:input path="phoneNumber" class="form-control"
										id="phoneNumber" type="text"
										placeholder="Enter your phone number" />
								</div>
								<div class="col-md-6">
									<label for="lastName">Last name</label>
									<form:input path="lastName" class="form-control" id="lastName"
										type="text" placeholder="Enter last name" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-14">
									<label for="firstName">First Name</label>
									<form:input path="firstName" class="form-control"
										id="firstName" type="text" placeholder="Enter first name" />
								</div>
								<div class="col-md-6">
									<label for="zipCode">Zip Code</label>
									<form:input path="zipCode" class="form-control" id="zipCode"
										type="text" placeholder="Enter zipcode" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="firstName">Email</label>
									<form:input path="email" class="form-control" id="email"
										type="text" placeholder="Enter email" />
								</div>

							</div>
						</div>
						<input type="submit" value="Apply & Save"
							class="btn text-white bg-success btn-block" />
					</form:form>
					<a href="${pageContext.request.contextPath}/customer/list"
						class="btn btn-secondary btn-block vert-offset-top-1">Back to
						List</a>
				</div>
			</div>
		</div>
	</div>
	<!-- /.container-fluid-->
	<!-- /.content-wrapper-->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © RetailIn 2017</small>
			</div>
		</div>
	</footer>
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>
	<!-- Logout Modal-->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<form action="logout" method="POST">
						<input class="btn btn-primary" type="submit" value="Logout" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
