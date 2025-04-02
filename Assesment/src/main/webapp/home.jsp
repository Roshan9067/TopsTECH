<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student Management System</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <style>
  	
  	
    
        .card {
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        iframe {
            border: none;
            width: 100%;
            height: 100px;
        }
        .banner-img {
            width: 100%;
            object-fit: cover;
            max-height : 100%;
            margin-bottom : 60px;
            
        }
    </style>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

    <header class="bg-light text-center py-2">
        <div class="container">
            <h1>Welcome to the Student Management System</h1>
        </div>
    </header>

    <!-- Banner Image -->
    <div class="container text-center">
        <img src="https://ei.study/wp-content/uploads/elementor/thumbs/4-1-qdcrno8zblz2tck9z8mvv0xz6in0c23ze9u49ht9gw.jpg" 
             alt="Student Management System" class="banner-img" style="object-position:top" height="500" >
    </div>

    <!-- Features Section (Only Student Records) -->
    <section class="container my-2">
        <div class="row text-center">
            <div class="col-md-4 offset-md-4">
                <!-- Content can be added here -->
            </div>
        </div>
    </section>

    <!-- Footer Section -->
    <footer  class="bg-dark text-white   text-center py-3">
        <p>&copy; 2025 Student Management System. All Rights Reserved By Roshan Gupta.</p>
    </footer>

    <!-- Bootstrap  JS (optional, for interactive components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
