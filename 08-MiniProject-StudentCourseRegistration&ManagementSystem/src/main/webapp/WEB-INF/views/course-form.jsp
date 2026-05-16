<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Course</title>
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

        input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
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

    <h2>Add Course</h2>

    <!-- Error Message -->
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <div class="error"><%= error %></div>
    <%
        }
    %>

    <form action="AddCourseServlet" method="post">

        <label>Course Name</label>
        <input type="text" name="courseName" required>

        <label>Duration</label>
        <input type="text" name="duration" required>

        <label>Fees</label>
        <input type="number" step="0.01" name="fees" required>

        <label>Trainer Name</label>
        <input type="text" name="trainerName" required>

        <button type="submit">Add Course</button>

    </form>

</div>

</body>
</html>