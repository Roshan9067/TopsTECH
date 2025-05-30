
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<html>
<head>
<title>Login Page</title>
<!-- Bootstrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	
	const displaylogged=()=>{
		var email=$("#email").val()
		var password=$("#password").val()
		$.get("display",{email,password},()=>{
			
		})
		
	}
	
	
	</script>
	
</head>
<body class="bg-light">

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<div class="card mt-5 shadow">
					<div class="card-body">
						<h3 class="text-center">Login</h3>
						<!-- <form action="login" method="post"> -->
							<div class="mb-3">
							
							<span id="err" class="rext-danger"></span>
								<label class="form-label">Email</label> <input type="email"
									name="email" id="email" class="form-control" placeholder="Enter Email"
									required >
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									type="password" id="password" name="password" class="form-control"
									placeholder="Enter Password" required>
							</div>
							<button type="submit" class="btn btn-primary w-100" onclick="displaylogged()">Login</button>
							<button type="button" class="btn btn-danger w-100 mt-2"
								onclick="location.href='forgotPassword.jsp'">Forgot
								Password?</button>
					<!-- 	</form> -->
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
