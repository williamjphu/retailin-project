<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
				<div class="card-header">Payroll Form</div>
				<div class="card-body">
					<form:form action="save" modelAttribute="payrollForm"
						method="POST">
						<form:hidden path="payrollID" />
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="payPeriod">Pay Period</label>
									<form:input path="payPeriod" class="form-control"
										id="payPeriod" type="text" placeholder="Enter payment period" />
								</div>
								<div class="col-md-6">
									<label for="hourlyRate">Hourly Rate</label>
									<form:input path="hourlyRate" class="form-control"
										id="hourlyRate" type="text" placeholder="Enter hourly rate" />
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-6">
									<label for="workedHours">Worked Hours</label>
									<form:input path="workedHours" class="form-control"
										id="workedHours" type="text" placeholder="Enter payment period" />
								</div>
								<div class="col-md-6">
									<label for="empID">Employee ID</label>
									<form:select path="empID" class="form-control" id="empID">
										<c:forEach var="employee" items="${listEmployees}">
											<form:option value="${employee.empID}">${employee.empID} - ${employee.lastName}, ${employee.firstName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<input type="submit" value="Apply & Save" class="btn text-white bg-success btn-block" />
					</form:form>
					<a href="${pageContext.request.contextPath}/payroll/list" class="btn btn-secondary btn-block vert-offset-top-1">Back to List</a>
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
