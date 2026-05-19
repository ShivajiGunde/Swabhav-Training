<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.studentcourse.model.Course" %>

<%
    Course course = (Course) request.getAttribute("course");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Course</title>

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
            background-color: #007bff;
            color: white;
            border: none;
        }

        h2 {
            text-align: center;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Update Course</h2>

    <form action="UpdateCourseServlet" method="post">

        <input type="hidden" name="courseId" value="<%= course.getCourseId() %>">

        <label>Course Name</label>
        <input type="text" name="courseName" value="<%= course.getCourseName() %>" required>

        <label>Duration</label>
        <input type="text" name="duration" value="<%= course.getDuration() %>" required>

        <label>Fees</label>
        <input type="number" step="0.01" name="fees" value="<%= course.getFees() %>" required>

        <label>Trainer Name</label>
        <input type="text" name="trainerName" value="<%= course.getTrainerName() %>" required>

        <button type="submit">Update Course</button>

    </form>

</div>

</body>
</html>