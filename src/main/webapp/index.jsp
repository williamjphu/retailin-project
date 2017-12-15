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
	<jsp:include page="WEB-INF/view/menu.jsp" />
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Icon Cards-->
			<div class="row vert-offset-top-3">
				<div class="col-xl-4 col-lg-6 col-xs-12 mb-3">
					<div class="card text-white bg-primary o-hidden h-100">
						<a href="${pageContext.request.contextPath}/cart"
							class="text-white">
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
						<a href="${pageContext.request.contextPath}/item/list"
							class="text-white">
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
						<a href="${pageContext.request.contextPath}/customer/list"
							class="text-white">
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
				<sec:authorize access="hasRole('ROLE_ADMIN')">
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
				</sec:authorize>
				<a href="${pageContext.request.contextPath}/receipt/list">Go to
					receipts</a><br>
				<br> <a href="${pageContext.request.contextPath}/vendor/list">Go
					to vendors</a>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<jsp:include page="WEB-INF/view/logout.jsp"/>
	</div>
</body>
</html>
