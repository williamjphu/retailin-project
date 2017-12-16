<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Payrolls</title>
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
					<i class="fa fa-table"></i>Payroll Data
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Payroll ID</th>
									<th>Pay Period</th>
									<th>Hourly rate</th>
									<th>Worked hours</th>
									<th>Employee ID</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="payroll" items="${listItems}">
									<c:url var="updateURL" value="/payroll/update">
										<c:param name="payrollId" value="${payroll.payrollID}" />
									</c:url>
									<c:url var="deleteURL" value="/payroll/delete">
										<c:param name="payrollId" value="${payroll.payrollID}" />
									</c:url>

									<tr>
										<td>${payroll.payrollID}</td>
										<td>${payroll.payPeriod}</td>
										<td><fmt:formatNumber pattern="0.00"
												value="${payroll.hourlyRate}" /></td>
										<td>${payroll.workedHours}</td>
										<td><fmt:formatNumber pattern="00000000"
												value="${payroll.empID}" /></td>
										<td>
											<!-- display the update link --> <a href="${updateURL}">Update</a>|
											<a href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this payroll?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<a href="${pageContext.request.contextPath}/payroll/add"
						class="btn bg-success text-white">Add Payroll</a> <a
						href="${pageContext.request.contextPath}/user/list"
						class="btn bg-secondary text-white">Back to List</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
