
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Login Page</title>
<!-- Bootstrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<div class="card mt-5 shadow">
					<div class="card-body">
						<h3 class="text-center">Login</h3>
						<form action="loginServlet" method="post">
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									name="email" class="form-control" placeholder="Enter Email"
									required>
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									type="password" name="password" class="form-control"
									placeholder="Enter Password" required>
							</div>
							<button type="submit" class="btn btn-primary w-100">Login</button>
							<button type="button" class="btn btn-danger w-100 mt-2"
								onclick="location.href='forgotPassword.jsp'">Forgot
								Password?</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
