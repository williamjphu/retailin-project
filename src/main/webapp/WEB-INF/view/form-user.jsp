<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn - Employee Information</title>
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
				<div class="card-header">Employee Information Form</div>
				<div class="card-body">
					<form:form action="save" modelAttribute="user" method="POST">
						<form:hidden path="empID" />
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="firstName">First name</label>
									<form:input path="firstName" class="form-control"
										id="firstName" type="text" placeholder="Enter first name" />
								</div>
								<div class="col-md-6">
									<label for="lastName">Last name</label>
									<form:input path="lastName" class="form-control" id="lastName"
										type="text" placeholder="Enter last name" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="password1">Password</label>
									<form:input path="password" class="form-control" id="password"
										type="password" placeholder="Password" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-6">
									<label for="firstName">Email</label>
									<form:input path="email" class="form-control" id="email"
										type="text" placeholder="Enter email" />
								</div>
								<div class="col-md-6">
									<label for="lastName">Phone Number</label>
									<form:input path="phoneNumber" class="form-control"
										id="phoneNumber" type="text" placeholder="Enter phone number" maxLength="10"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-4">
									<label for="enabled">Enabled</label>
									<form:select path="enabled" class="form-control" id="role">
										<form:option value="1">Yes</form:option>
										<form:option value="0">No</form:option>
									</form:select>
								</div>
								<div class="col-md-4">
									<label for="role">Role</label>
									<form:select path="authority" class="form-control" id="role">
										<form:option value="ROLE_EMPLOYEE">EMPLOYEE</form:option>
										<form:option value="ROLE_ADMIN">ADMIN</form:option>
									</form:select>
								</div>
								<div class="col-md-4">
									<label for="department">Department</label>
									<form:select path="departmentID" class="form-control"
										id="department">
										<c:forEach var="dept" items="${listDepartments}">
											<form:option value="${dept.deptID}">${dept.deptID} - ${dept.name}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						<input type="submit" value="Apply & Save"
							class="btn text-white bg-success btn-block" />
					</form:form>
					<a href="${pageContext.request.contextPath}/user/list"
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
