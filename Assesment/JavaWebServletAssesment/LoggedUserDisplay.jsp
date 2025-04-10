<%@page import="com.Model.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h3 class="text-center mb-3">Student List</h3>
    
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                User user = (User) session.getAttribute("user");
                if (user != null) {
                 
            %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getFname() %></td>
                <td><%= user.getLname() %></td>
                <td><%= user.getEmail() %></td>
                <td><%= user.getMobile() %></td>
                <td><%= user.getAddress() %></td>
                <td><%= user.getGender() %></td>
                <td>
                    <a href="UpdateStudentServlet?id=<%= user.getId() %>" class="btn btn-warning btn-sm">Update</a>
                    <a href="DeleteStudentServlet?id=<%= user.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
            <%
                } else {
            %>
            <tr>
                <td colspan="8" class="text-center">No students found.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
