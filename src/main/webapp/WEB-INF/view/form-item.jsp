<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Item Form</title>
<!-- Resources link -->
<jsp:include page="resources.jsp" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<jsp:include page="menu.jsp" />
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card card-register mx-auto mt-5">
				<div class="card-header">Item Information Form</div>
				<div class="card-body">
					<form:form action="save" modelAttribute="itemForm" method="POST">
						<form:hidden path="itemID" />
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="itemName">Item name</label>
									<form:input path="itemName" class="form-control" id="itemName"
										type="text" placeholder="Apple" />
								</div>
								<div class="col-md-6">
									<label for="description">Description</label>
									<form:input path="description" class="form-control"
										id="description" type="text" placeholder="Organic " />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="price">Price $</label>
									<form:input path="price" class="form-control" id="price"
										type="text" />
								</div>
								<div class="col-md-6">
									<label for="quantity">Quantity</label>
									<form:input path="quantity" class="form-control" id="quantity"
										type="number" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="discount">Discount %</label>
									<form:input path="discount" class="form-control" id="discount"
										type="number" />
								</div>
								<div class="col-md-6">
									<label for="categoryID">Category ID</label>
									<form:select path="categoryID" class="form-control"
										id="categoryID">
										<c:forEach var="category" items="${listCategories}">
											<form:option value="${category.categoryID}">${category.categoryID} - ${category.name}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="vendorID">Vendor</label>
									<form:select path="vendorID" class="form-control" id="vendorID">
										<c:forEach var="vend" items="${listVendors}">
											<form:option value="${vend.vendorID}">${vend.vendorID} - ${vend.name}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<input type="submit" value="Apply & Save"
							class="btn text-white bg-success btn-block" />
					</form:form>
					<a href="${pageContext.request.contextPath}/item/list"
						class="btn btn-secondary btn-block vert-offset-top-1">Back to
						List</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer & Logout -->
	<jsp:include page="logout.jsp" />
</body>
</html>
