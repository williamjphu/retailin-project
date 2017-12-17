<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Vendor Information</title>
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
				<div class="card-header">Vendor Information Form</div>
				<div class="card-body">
					<form:form action="save" modelAttribute="vendorForm" method="POST">
						<form:hidden path="vendorID" />
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="ein">EIN</label>
									<form:input path="ein" class="form-control" id="ein"
										type="text" placeholder="00-0000000" maxLength="10" />
								</div>
								<div class="col-md-6">
									<label for="name">Name</label>
									<form:input path="name" class="form-control" id="name"
										type="text" placeholder="RetailIn" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="address">Address</label>
									<form:input path="address" class="form-control" id="address"
										type="text" placeholder="1 Washington Square" />
								</div>
								<div class="col-md-6">
									<label for="city">Bank City</label>
									<form:select path="city" class="form-control" id="city">
										<form:option value="Alabama">Alabama</form:option>
										<form:option value="Bronx">Bronx</form:option>
										<form:option value="New York city">New York city</form:option>
										<form:option value="San Francisco">San Francisco</form:option>
										<form:option value="San Jose">San Jose</form:option>
										<form:option value="Seattle">Seattle</form:option>
										<form:option value="Oakland">Oakland</form:option>
									</form:select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for=state>Bank State</label>
									<form:select path="state" class="form-control" id="state">
										<form:option value="California">California</form:option>
										<form:option value="New York">New York</form:option>
										<form:option value="Washington">Washington</form:option>
									</form:select>
								</div>
								<div class="col-md-6">
									<label for="zipCode">Zip Code</label>
									<form:input path="zipCode" class="form-control" id="zipCode"
										maxlength="5" />
								</div>
							</div>
						</div>
						<input type="submit" value="Apply & Save"
							class="btn text-white bg-success btn-block" />
					</form:form>
					<a href="${pageContext.request.contextPath}/vendor/list"
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
