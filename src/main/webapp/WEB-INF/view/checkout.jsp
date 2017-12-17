<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Checkout</title>
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
				<div class="card-header">Cart Items</div>
				<div class="card-body">
					<!-- Search bar -->
					<div>
						<form>
							<div class="row">
								<div class="form-group col col-8">
									<select name="item" class="form-control">
										<c:forEach var="item" items="${allItems}">
											<option value="${item.itemID}">${item.itemName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col col-2">
									<select name="amount" class="form-control">
										<c:forEach var="i" begin="1" end="10">
											<option value="${i}">${i}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group col col-2">
									<input type="submit" value="Add" class="btn btn-primary">
								</div>
							</div>
						</form>
					</div>
					<!-- Table content  -->
					<div class="table-responsive">
						<table class="table table-bordered" id="dataTable" width="100%"
							cellspacing="0">
							<thead>
								<tr>
									<th>Product name</th>
									<th>Price $</th>
									<th>Discount %</th>
									<th>Quantity</th>
									<th>Total $</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${cartItems}" varStatus="loop">
									<!-- construct an "update" link with customer id -->
									<c:url var="updateURL" value="/checkout/update">
										<c:param name="index" value="${loop.index}" />
									</c:url>
									<!-- construct an "delete" link with customer id -->
									<c:url var="deleteURL" value="/checkout/delete">
										<c:param name="index" value="${loop.index}" />
									</c:url>

									<tr>
										<td>${item.itemName}</td>
										<td><fmt:formatNumber pattern="0.00"
												value="${item.price}" /></td>
										<td>${item.discount}</td>
										<td>${item.quantity}</td>
										<td><fmt:formatNumber pattern="0.00"
												value="${item.quantity *(item.price *(100-item.discount)/100.0)}" /></td>
										<td><a href="${deleteURL}">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>Total</th>
									<th>---</th>
									<th>---</th>
									<th>---</th>
									<th><fmt:formatNumber pattern="0.00" value="${total}" /></th>
									<th>Checkout</th>
								</tr>
							</tfoot>
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
