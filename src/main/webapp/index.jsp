<%-- <% response.sendRedirect("user/list"); %> --%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>

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
					title="Checkout"><a class="nav-link" href="${pageContext.request.contextPath}/cart"> <i
						class="fa fa-fw fa-shopping-cart"></i> <span class="nav-link-text">Checkout</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Inventory"><a class="nav-link" href="${pageContext.request.contextPath}/item/list">
						<i class="fa fa-fw fa-table"></i> <span class="nav-link-text">Inventory</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Customers"><a class="nav-link" href="${pageContext.request.contextPath}/customer/list"> <i
						class="fa fa-fw fa-user-circle"></i> <span class="nav-link-text">Customers</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Employees"><a class="nav-link"
					href="${pageContext.request.contextPath}/user/list"> <i
						class="fa fa-fw fa-black-tie"></i> <span class="nav-link-text">Employees</span>
				</a></li>
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
			<!-- Icon Cards-->
			<div class="row vert-offset-top-3">
				<div class="col-xl-12 mb-3">
					<h2>
						Welcome,
						<sec:authentication property="principal.username" />
						!
					</h2>
				</div>
				<div class="col-xl-4 col-lg-6 col-xs-12 mb-3">
					<div class="card text-white bg-primary o-hidden h-100">
						<a href="${pageContext.request.contextPath}/cart" class="text-white">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-shopping-cart"></i>
								</div>
								<div class="mr-5">CHECKOUT</div>
							</div>
							<div class="card-footer clearfix small z-1">
								<span class="float-left">Enter shopping mode</span> <span
									class="float-right"> <i class="fa fa-angle-right"></i>
								</span>
							</div>
						</a>
					</div>
				</div>
				<div class="col-xl-4 col-lg-6 col-xs-12 mb-3">
					<div class="card text-white bg-warning o-hidden h-100">
						<a href="${pageContext.request.contextPath}/item/list" class="text-white">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-table"></i>
								</div>
								<div class="mr-5">INVENTORY</div>
							</div>
							<div class="card-footer clearfix small z-1">
								<span class="float-left">Manage items in stock</span> <span
									class="float-right"> <i class="fa fa-angle-right"></i>
								</span>
							</div>
						</a>
					</div>
				</div>
				<div class="col-xl-4 col-lg-6 col-xs-12 mb-3">
					<div class="card text-white bg-success o-hidden h-100">
						<a href="${pageContext.request.contextPath}/customer/list" class="text-white">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-user-circle"></i>
								</div>
								<div class="mr-5">CUSTOMERS</div>
							</div>
							<div class="card-footer clearfix small z-1">
								<span class="float-left">Manage customer information</span> <span
									class="float-right"> <i class="fa fa-angle-right"></i>
								</span>
							</div>
						</a>
					</div>
				</div>
				<div class="col-xl-4 col-lg-6 col-xs-12 mb-3">
					<div class="card text-white bg-danger o-hidden h-100">
						<a href="${pageContext.request.contextPath}/user/list"
							class="text-white">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fa fa-fw fa-black-tie"></i>
								</div>
								<div class="mr-5">EMPLOYEES</div>
							</div>
							<div class="card-footer clearfix small z-1">
								<span class="float-left">Manage employee information</span> <span
									class="float-right"> <i class="fa fa-angle-right"></i>
								</span>
							</div>
						</a>
					</div>
				</div>
			</div>
			<!-- Area Chart Example-->
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
			<div class="container">
				<div class="text-center">
					<small>Copyright © RetailIn 2017</small>
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
							<span aria-hidden="true">×</span>
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
