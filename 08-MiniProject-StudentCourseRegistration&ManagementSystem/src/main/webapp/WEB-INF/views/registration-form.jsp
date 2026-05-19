<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Student Course</title>

    <style>
        body {
            font-family: Arial;
            background-color: #f2f2f2;
        }

        .container {
            width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0px 0px 10px #ccc;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        .error {
            color: red;
            margin-bottom: 10px;
        }

        h2 {
            text-align: center;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Register Student to Course</h2>

    <!-- Error Message -->
    <%
        String error = (String) request.getAttribute("errorMessage");
        if (error != null) {
    %>
        <div class="error"><%= error %></div>
    <%
        }
    %>

<!--     <form action="RegisterStudentCourseServlet" method="post"> -->
    
    <form action="${pageContext.request.contextPath}/RegisterStudentCourseServlet" method="post">

        <label>Student ID</label>
        <input type="number" name="studentId" required>

        <label>Course ID</label>
        <input type="number" name="courseId" required>

        <button type="submit">Register</button>

    </form>

</div>

</body>
</html>