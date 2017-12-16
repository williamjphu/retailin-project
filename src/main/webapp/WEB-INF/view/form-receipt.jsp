<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Receipt Information</title>
<!-- Resources link -->
<jsp:include page="resources.jsp" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<jsp:include page="menu.jsp"/>
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card card-register mx-auto mt-5">
				<div class="card-header">Receipt Information Form</div>
				<div class="card-body">
					<form:form action="save" modelAttribute="receiptForm" method="POST">
						<form:hidden path="transactionNo" />
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="total">Receipt Total</label>
									<form:input path="total" class="form-control" id="total"
										type="text" placeholder="Enter total" />
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-6">
									<label for="customerID">Customer ID</label>
									<form:select path="customerID" class="form-control"
										id="customerID">
										<c:forEach var="cust" items="${listCustomers}">
											<form:option value="${cust.customerID}">${cust.customerID} - ${cust.lastName}, ${cust.firstName}</form:option>
										</c:forEach>
									</form:select>
								</div>
								<div class="col-md-6">
									<label for="empID">Employee</label>
									<form:select path="empID" class="form-control" id="empID">
										<c:forEach var="employee" items="${listEmployees}">
											<form:option value="${employee.empID}">${employee.empID} - ${employee.lastName}, ${employee.firstName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<input type="submit" value="Apply & Save"
							class="btn text-white bg-success btn-block" />
					</form:form>
					<a href="${pageContext.request.contextPath}/receipt/list"
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
