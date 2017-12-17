<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Categories Page</title>
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
					<i class="fa fa-table"></i>Categories Data
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Category ID
									<th>Category name</th>
									<th>Description</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="tempCategory" items="${categories}">
									<c:url var="updateURL" value="/category/update">
										<c:param name="categoryID" value="${tempCategory.categoryID}" />
									</c:url>
									<c:url var="deleteURL" value="/category/delete">
										<c:param name="categoryID" value="${tempCategory.categoryID}" />
									</c:url>

									<tr>
										<td>${tempCategory.categoryID}</td>
										<td>${tempCategory.name}</td>
										<td>${tempCategory.description}</td>
										<td><a href="${updateURL}">Update</a>|<a
											href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this category?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<a href="${pageContext.request.contextPath}/category/add"
						class="btn bg-success text-white">Add Category</a> <a
						href="${pageContext.request.contextPath}/item/list"
						class="btn bg-secondary text-white">Back to List </a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
