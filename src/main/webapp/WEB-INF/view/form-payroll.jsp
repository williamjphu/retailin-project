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
	<jsp:include page="menu.jsp"/>
	<!-- Content -->
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
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
