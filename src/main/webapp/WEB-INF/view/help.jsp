<%-- <% response.sendRedirect("user/list"); %> --%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RetailIn Help</title>
<jsp:include page="resources.jsp" />
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<jsp:include page="menu.jsp" />
	<!-- Content -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="card card-register mx-auto mt-5">
				<div class="card-header">Contact Us</div>
				<div class="card-body">
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-12">
								<p>For any questions, please contact one of the developers below:</p>
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-6">
								<label>Quang Duy Luong:</label> <input class="form-control"
									value="quangduy.luong@sjsu.edu" disabled />
							</div>
							<div class="col-md-6">
								<label>Jie Peng Hu:</label> <input class="form-control"
									value="jiepeng.huwu@sjsu.edu" disabled />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<jsp:include page="logout.jsp" />
	</div>
</body>
</html>
