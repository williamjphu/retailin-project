<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Items</title>
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
	<jsp:include page="menu.jsp" />
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Item Data
				</div>
				<div class="card-body">
					<!-- Search bar -->
					<div>
						<form>
							<div class="row">
								<div class="form-group">
									<input placeholder="Search" class="form-control">
								</div>
								<div class="form-group">
									<input type="submit" value="Search" class="btn btn-secondary">
								</div>
							</div>
						</form>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Item ID</th>
									<th>Item name</th>
									<th>Description</th>
									<th>Price $</th>
									<th>Discount %</th>
									<th>Quantity</th>
									<th>Category id</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${listItems}">
									<!-- construct an "update" link with customer id -->
									<c:url var="updateURL" value="/item/update">
										<c:param name="itemId" value="${item.itemID}" />
									</c:url>

									<!-- construct an "delete" link with customer id -->
									<c:url var="deleteURL" value="/item/delete">
										<c:param name="itemId" value="${item.itemID}" />
									</c:url>

									<tr>
										<td>${item.itemID}</td>
										<td>${item.itemName}</td>
										<td>${item.description}</td>
										<td>${item.price}</td>
										<td>${item.discount}</td>
										<td>${item.quantity}</td>
										<td>${item.categoryID}</td>
										<td>
											<!-- display the update link --> <%-- <spring:url value="/item/update/${item.itemName}" var="updateURL" /> --%>
											<a href="${updateURL}">Update</a> | <%--                       <spring:url value="/item/delete/${item.itemName}" var="deleteURL" /> --%>
											<a href="${deleteURL}"
											onclick="if (!(confirm('Are you sure you want to delete this item?'))) return false">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<%--  <spring:url value="/item/add" var="addURL" /> --%>
					<a href="${pageContext.request.contextPath}/item/add"
						class="btn bg-success text-white">Add Item</a> <a
						href="${pageContext.request.contextPath}/category/list"
						class="btn bg-success text-white">Go to Categories</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
