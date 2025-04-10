<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Registration</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
        .card {
            border-radius: 12px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
            padding: 20px;
        }
        .form-control {
            border-radius: 8px;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
            transition: 0.3s;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-danger {
            background-color: #dc3545;
            border: none;
            transition: 0.3s;
        }
        .btn-danger:hover {
            background-color: #c82333;
        }
    </style>
    <script>
    	const validatePass =()=>{
			var pass = $("#pass").val()
			var cpass =$("#cpass").val()
			if(pass!==cpass){
				$("#cpErr").html("Password Did not Match")
			}else{
				$("#cpErr").html("")
			}
    	}
    	const checkEmail=()=>{
			var email = $("#email").val()
			$.post("emailCheck",{email},(rt)=>{
				$("#emlErr").html(rt)
			})
    	}
    
    </script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">
    <div class="card">
        <h2 class="text-center text-primary">Student Registration</h2>
        <hr>
        <form action="reg" method="post">
            
            <span class="text-success">${msg}</span>
            
            
            <!-- First Name & Last Name -->
            <div class="mb-3">
                <label class="form-label">First Name</label>
                <input type="text" name="fname" id="fname" class="form-control" placeholder="Enter First Name" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Last Name</label>
                <input type="text" name="lname" id="lname" class="form-control" placeholder="Enter Last Name" required>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" id="email" class="form-control" placeholder="Enter Email" onblur="checkEmail()" required>
                <span class="text-danger" id="emlErr"></span>
            </div>

            <!-- Mobile Number -->
            <div class="mb-3">
                <label class="form-label">Mobile</label>
                <input type="text" name="mobile" id="mobile" class="form-control" placeholder="Enter Mobile Number" required>
            </div>

            <!-- Address -->
            <div class="mb-3">
                <label class="form-label">Address</label>
                <textarea name="address" class="form-control" id="address" rows="2" placeholder="Enter Address" required></textarea>
            </div>

            <!-- Gender -->
            <div class="mb-3">
                <label class="form-label" for="gender">Gender</label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="Male" id="male" required>
                    <label class="form-check-label">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" value="Female" id="female"required>
                    <label class="form-check-label">Female</label>
                </div>
            </div>

            <!-- Password -->
            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" id="pass" placeholder="Enter Password" required>
            </div>

            <!-- Confirm Password -->
            <div class="mb-3">
                <label class="form-label">Confirm Password</label>
                <input type="password" name="conpassword" class="form-control" id="cpass" placeholder="Confirm Password" onkeyup="validatePass()"required>
                <span class="text-danger" id="cpErr"></span>
            </div>

            <!-- Submit Button -->
            <div class="text-center">
                <button type="submit" class="btn btn-primary w-50">Register</button>
            </div>
        </form>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
