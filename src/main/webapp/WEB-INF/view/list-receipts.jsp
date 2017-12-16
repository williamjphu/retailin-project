<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Receipts</title>
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
					<i class="fa fa-table"></i>Receipts Data
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Receipt ID</th>
									<th>Receipt Date</th>
									<th>Total</th>
									<th>Customer ID</th>
									<th>Issued By</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="receipt" items="${listReceipts}">
									<c:url var="updateURL" value="/receipt/update">
										<c:param name="receiptId" value="${receipt.transactionNo}" />
									</c:url>
									<c:url var="deleteURL" value="/receipt/delete">
										<c:param name="receiptId" value="${receipt.transactionNo}" />
									</c:url>

									<tr>
										<td>${receipt.transactionNo}</td>
										<td>${receipt.timestamp}</td>
										<td>${receipt.total}</td>
										<td>${receipt.customerID}</td>
										<td>${receipt.empID}</td>
										<td>
											<!-- display the update link --> <a href="${updateURL}">Update</a>
											| <a href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this receipt?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
