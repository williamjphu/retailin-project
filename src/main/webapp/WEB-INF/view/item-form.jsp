<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Item Information</title>
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
	<jsp:include page="menu.jsp"/>
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
										type="text" placeholder="Enter item name" />
								</div>
								<div class="col-md-6">
									<label for="description">Description</label>
									<form:input path="description" class="form-control"
										id="description" type="text" placeholder="Enter Description" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="price">Price</label>
									<form:input path="price" class="form-control" id="price"
										type="text" placeholder="Enter price" />
								</div>
								<div class="col-md-6">
									<label for="quantity">Quantity</label>
									<form:input path="quantity" class="form-control" id="quantity"
										type="text" placeholder="Enter quantity" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-4">
									<label for="discount">discount</label>
									<form:input path="discount" class="form-control" id="discount"
										type="text" placeholder="Enter discount" />
								</div>
								<div class="col-md-4">
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
