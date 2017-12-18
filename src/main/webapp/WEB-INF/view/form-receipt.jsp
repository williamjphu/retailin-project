<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
	<jsp:include page="menu.jsp" />
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
										type="text" placeholder="Enter total" disabled="true" />
								</div>
							</div>
							<div class="form-row">
								<div class="col-md-6">
									<label for="customerID">Customer ID</label>
									<form:select path="customerID" class="form-control"
										id="customerID" disabled="true">
										<c:forEach var="cust" items="${listCustomers}">
											<form:option value="${cust.customerID}">${cust.customerID} - ${cust.lastName}, ${cust.firstName}</form:option>
										</c:forEach>
									</form:select>
								</div>
								<div class="col-md-6">
									<label for="empID">Employee</label>
									<form:select path="empID" class="form-control" id="empID"
										disabled="true">
										<c:forEach var="employee" items="${listEmployees}">
											<form:option value="${employee.empID}">${employee.empID} - ${employee.lastName}, ${employee.firstName}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
					</form:form>
					<div class="form-row font-weight-bold vert-offset-top-2">
						<div class="col-md-6">
							<label>Item Name</label>
						</div>
						<div class="col-md-2">
							<label>Quantity</label>
						</div>
						<div class="col-md-2">
							<label>Unit Price</label>
						</div>
						<div class="col-md-2">
							<label>Total Price</label>
						</div>
					</div>
					<c:forEach var="item" items="${items}">
						<div class="form-row">
							<div class="col-md-6">
								<label>${item.itemName}</label>
							</div>
							<div class="col-md-2">
								<label>${item.quantity}</label>
							</div>
							<div class="col-md-2">
								<label><fmt:formatNumber pattern="0.00"
										value="${(item.price *(100-item.discount)/100.0)}" /></label>
							</div>
							<div class="col-md-2">
								<label><fmt:formatNumber pattern="0.00"
										value="${item.quantity *(item.price *(100-item.discount)/100.0)}" /></label>
							</div>
						</div>
					</c:forEach>
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
