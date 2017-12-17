<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Departments</title>
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
					<i class="fa fa-table"></i> Departments Data
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Department ID</th>
									<th>Department Name</th>
									<th>Description</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="dept" items="${departments}">
									<!-- construct an "update" link with customer id -->
									<c:url var="updateURL" value="/department/update">
										<c:param name="deptId" value="${dept.deptID}" />
									</c:url>

									<!-- construct an "delete" link with customer id -->
									<c:url var="deleteURL" value="/category/delete">
										<c:param name="deptId" value="${dept.deptID}" />
									</c:url>

									<tr>
										<td>${dept.deptID}</td>
										<td>${dept.name}</td>
										<td>${dept.description}</td>
										<td>
											<!-- display the update link --> <a href="${updateURL}">Update</a>|
											<a href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this department?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<a href="${pageContext.request.contextPath}/department/add"
						class="btn bg-success text-white">Add Department</a> <a
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
