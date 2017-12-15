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
	<jsp:include page="menu.jsp" />
	<!-- Content -->
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
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
