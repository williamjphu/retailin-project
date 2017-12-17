<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Bank Account Information</title>
<!-- Resources link -->
<jsp:include page="resources.jsp" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<jsp:include page="menu.jsp" />
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card card-register mx-auto mt-5">
				<div class="card-header">Bank Account Form</div>
				<div class="card-body">
					<form:form action="save" modelAttribute="bankForm" method="POST">
						<form:hidden path="acctID" />
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="acctNumber">Account Number</label>
									<form:input path="acctNumber" class="form-control"
										id="acctNumber" type="text" maxLength="10" />
								</div>
								<div class="col-md-6">
									<label for="routingNumber">Routing Number</label>
									<form:input path="routingNumber" class="form-control"
										id="routingNumber" type="text" maxLength="9" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="acctType">Account Type</label>
									<form:select path="acctType" class="form-control" id="empID">
										<form:option value="Savings">Saving</form:option>
										<form:option value="Checking">Checking</form:option>
									</form:select>
								</div>
								<div class="col-md-6">
									<label for="bankName">Bank Name</label>
									<form:select path="bankName" class="form-control" id="bankName">
										<form:option value="Bank of America">Bank of America</form:option>
										<form:option value="CitiBank">CitiBank</form:option>
										<form:option value="Chase">Chase</form:option>
										<form:option value="First Republic Bank">First Republic Bank</form:option>
										<form:option value="Wells Fargo">Wells Fargo</form:option>
									</form:select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for=bankAddress>Bank Address</label>
									<form:input path="bankAddress" class="form-control"
										id="bankAddress" type="text" placeholder="1 Washington Square" />
								</div>
								<div class="col-md-6">
									<label for="bankCity">Bank City</label>
									<form:select path="bankCity" class="form-control" id="bankCity">
										<form:option value="Alabama">Alabama</form:option>
										<form:option value="Bronx">Bronx</form:option>
										<form:option value="New York city">New York city</form:option>
										<form:option value="San Francisco">San Francisco</form:option>
										<form:option value="San Jose">San Jose</form:option>
										<form:option value="Seattle">Seattle</form:option>
										<form:option value="Oakland">Oakland</form:option>
									</form:select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for=bankState>Bank State</label>
									<form:select path="bankState" class="form-control" id="bankState">
										<form:option value="California">California</form:option>
										<form:option value="New York">New York</form:option>
										<form:option value="Washington">Washington</form:option>
									</form:select>
								</div>
								<div class="col-md-6">
									<label for=zipCode>Zip Code</label>
									<form:input path="zipCode" class="form-control" id="zipCode"
										type="text" maxLength="5" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
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
						<input type="submit" value="Apply & Save"
							class="btn text-white bg-success btn-block" />
					</form:form>
					<a href="${pageContext.request.contextPath}/bank-account/list"
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
