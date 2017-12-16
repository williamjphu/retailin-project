<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Receipts"><a class="nav-link"
				href="${pageContext.request.contextPath}/receipt/list"> <i
					class="fa fa-fw fa-dollar"></i> <span class="nav-link-text">Receipts</span>
			</a></li>
			<li class="nav-item" data-toggle="tooltip" data-placement="right"
				title="Vendors"><a class="nav-link"
				href="${pageContext.request.contextPath}/vendor/list"> <i
					class="fa fa-fw fa-truck"></i> <span class="nav-link-text">Vendors</span>
			</a></li>
		</ul>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" data-toggle="modal"
				data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
			</a></li>
		</ul>
	</div>
</nav>