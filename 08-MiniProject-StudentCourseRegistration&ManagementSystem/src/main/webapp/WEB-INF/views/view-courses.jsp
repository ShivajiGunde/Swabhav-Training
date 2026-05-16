<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.model.Course" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Courses</title>

    <style>
        body {
            font-family: Arial;
            background-color: #f2f2f2;
        }

        .container {
            width: 80%;
            margin: 40px auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px #ccc;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        h2 {
            text-align: center;
        }

        .btn {
            padding: 5px 10px;
            text-decoration: none;
            color: white;
            border-radius: 4px;
        }

        .edit {
            background-color: #28a745;
        }

        .delete {
            background-color: #dc3545;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Course List</h2>

    <%
        List<Course> courseList = (List<Course>) request.getAttribute("courseList");
    %>

    <table>
        <tr>
            <th>ID</th>
            <th>Course Name</th>
            <th>Duration</th>
            <th>Fees</th>
            <th>Trainer Name</th>
            <th>Actions</th>
        </tr>

        <%
            if (courseList != null && !courseList.isEmpty()) {
                for (Course c : courseList) {
        %>

        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getCourseName() %></td>
            <td><%= c.getDuration() %></td>
            <td><%= c.getFees() %></td>
            <td><%= c.getTrainerName() %></td>

            <td>
                <a href="EditCourseServlet?id=<%= c.getId() %>" class="btn edit">Edit</a>
                <a href="DeleteCourseServlet?id=<%= c.getId() %>" class="btn delete"
                   onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>

        <%
                }
            } else {
        %>

        <tr>
            <td colspan="6">No courses available</td>
        </tr>

        <%
            }
        %>

    </table>

</div>

</body>
</html>