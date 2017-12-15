<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Home</title>
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/">RetailIn</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Checkout"><a class="nav-link"
					href="${pageContext.request.contextPath}/cart"> <i
						class="fa fa-fw fa-shopping-cart"></i> <span class="nav-link-text">Checkout</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Inventory"><a class="nav-link"
					href="${pageContext.request.contextPath}/item/list"> <i
						class="fa fa-fw fa-table"></i> <span class="nav-link-text">Inventory</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Customers"><a class="nav-link"
					href="${pageContext.request.contextPath}/customer/list"> <i
						class="fa fa-fw fa-user-circle"></i> <span class="nav-link-text">Customers</span>
				</a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item" data-toggle="tooltip" data-placement="right"
						title="Employees"><a class="nav-link"
						href="${pageContext.request.contextPath}/user/list"> <i
							class="fa fa-fw fa-black-tie"></i> <span class="nav-link-text">Employees</span>
					</a></li>
				</sec:authorize>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
				</a></li>
			</ul>
		</div>
	</nav>
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Item Data
				</div>
				<div class="card-body">
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
					<input type="button" value="Add Item"
						onclick="window.location.href='add'; return false;"
						class="btn bg-success text-white" /> <a
						href="${pageContext.request.contextPath}/category/list"
						class="btn bg-success text-white">Go to Categories</a>
				</div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
			<div class="container">
				<div class="text-center">
					<small>Copyright � RetailIn 2017</small>
				</div>
			</div>
		</footer>
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>
		<!-- Logout Modal-->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">�</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<form action="logout" method="POST">
							<input class="btn btn-primary" type="submit" value="Logout" /> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
