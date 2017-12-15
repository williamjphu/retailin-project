<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<jsp:include page="menu.jsp"/>
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card card-register mx-auto mt-5">
				<div class="card-header">Vendor Information Form</div>
				<div class="card-body">
					<form:form action="save" modelAttribute="vendorForm" method="POST">
						<form:hidden path="vendorID" />
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="ein">EIN</label>
									<form:input path="ein" class="form-control" id="ein"
										type="text" placeholder="Enter Employer Identification Number" />
								</div>
								<div class="col-md-6">
									<label for="name">Name</label>
									<form:input path="name" class="form-control" id="name"
										type="text" placeholder="RetailIn" />
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-6">
									<label for="address">Address</label>
									<form:input path="address" class="form-control" id="address"
										type="text" placeholder="1 Washington Square" />
								</div>
								<div class="col-md-6">
									<label for="city">City</label>
									<form:input path="city" class="form-control" id="city"
										type="text" placeholder="San Jose" />
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-6">
									<label for="state">State</label>
									<form:input path="state" class="form-control" id="state"
										type="text" placeholder="California" />
								</div>
								<div class="col-md-6">
									<label for="zipCode">Zip Code</label>
									<form:input path="zipCode" class="form-control" id="zipCode"
										type="text" placeholder="95112" />
								</div>
							</div>
						</div>
						<input type="submit" value="Apply & Save"
							class="btn text-white bg-success btn-block" />
					</form:form>
					<a href="${pageContext.request.contextPath}/vendor/list"
						class="btn btn-secondary btn-block vert-offset-top-1">Back to List</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
