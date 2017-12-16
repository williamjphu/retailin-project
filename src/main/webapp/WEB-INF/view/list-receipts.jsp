<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Receipts</title>
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
					<i class="fa fa-table"></i> Receipts Data
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
										<td><fmt:formatNumber pattern="0.00"
												value="${receipt.total}" /></td>
										<td>${receipt.customerID}</td>
										<td><fmt:formatNumber pattern="0000000"
												value="${receipt.empID}" /></td>
										<td>
											<!-- display the update link --> <a href="${updateURL}">Update</a>|
											<a href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this receipt?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<a href="${pageContext.request.contextPath}/"
						class="btn bg-secondary text-white">Back Home</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
