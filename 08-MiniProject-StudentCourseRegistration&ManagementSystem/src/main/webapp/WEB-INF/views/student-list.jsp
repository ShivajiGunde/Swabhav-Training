<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.model.Student" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Students</title>

<style>

body{
    font-family: Arial;
    background-color: #f4f4f4;
    margin: 20px;
}

h2{
    text-align: center;
}

table{
    width: 100%;
    border-collapse: collapse;
    background-color: white;
}

table, th, td{
    border: 1px solid #ccc;
}

th{
    background-color: #007bff;
    color: white;
    padding: 10px;
}

td{
    padding: 10px;
    text-align: center;
}

a{
    text-decoration: none;
    padding: 6px 10px;
    border-radius: 4px;
    color: white;
}

.edit-btn{
    background-color: green;
}

.delete-btn{
    background-color: red;
}

.add-btn{
    background-color: blue;
    padding: 10px 15px;
    display: inline-block;
    margin-bottom: 15px;
    color: white;
}

</style>

</head>
<body>

<h2>Student List</h2>

<a href="${pageContext.request.contextPath}/AddStudentServlet" class="add-btn">
    Add New Student
</a>

<!-- <a href="/WEB-INF/views/student-form.jsp" class="add-btn"> -->
<!--     Add New Student -->
<!-- </a> -->

<table>

    <tr>
        <th>Student ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Age</th>
        <th>City</th>
        <th>Actions</th>
    </tr>

<%

List<Student> studentList =
(List<Student>) request.getAttribute("studentList");

if(studentList != null && !studentList.isEmpty()){

    for(Student student : studentList){

%>

    <tr>

        <td>
            <%= student.getStudentId() %>
        </td>

        <td>
            <%= student.getStudentName() %>
        </td>

        <td>
            <%= student.getEmail() %>
        </td>

        <td>
            <%= student.getPhone() %>
        </td>

        <td>
            <%= student.getAge() %>
        </td>

        <td>
            <%= student.getCity() %>
        </td>

        <td>

            <a href="EditStudentServlet?studentId=<%= student.getStudentId() %>"
               class="edit-btn">

               Edit
            </a>

            <a href="DeleteStudentServlet?studentId=<%= student.getStudentId() %>"
               class="delete-btn"
               onclick="return confirm('Are you sure to delete?')">

               Delete
            </a>

        </td>

    </tr>

<%
    }
}else{
%>

    <tr>
        <td colspan="7">
            No Students Found
        </td>
    </tr>

<%
}
%>

</table>

</body>
</html>