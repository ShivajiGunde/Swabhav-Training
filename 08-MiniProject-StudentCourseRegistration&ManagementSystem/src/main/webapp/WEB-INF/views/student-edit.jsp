<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.studentcourse.model.Student" %>

<html>
<head>
    <title>Update Student</title>
</head>
<body>

<h2>Update Student</h2>

<%
String errorMessage = (String) request.getAttribute("errorMessage");
Student student = (Student) request.getAttribute("student");

if (student == null) {
%>
    <p style="color:red;">Student data not available</p>
<%
    return;
}

if (errorMessage != null) {
%>
    <p style="color:red;"><%= errorMessage %></p>
<%
}
%>

<form action="UpdateStudentServlet" method="post">

    <input type="hidden" name="studentId"
           value="<%= student.getStudentId() %>">

    Name:
    <input type="text" name="studentName"
           value="<%= student.getStudentName() %>">
    <br><br>

    Email:
    <input type="email" name="email"
           value="<%= student.getEmail() %>">
    <br><br>

    Phone:
    <input type="text" name="phone"
           value="<%= student.getPhone() %>">
    <br><br>

    Age:
    <input type="text" name="age"
           value="<%= student.getAge() %>">
    <br><br>

    City:
    <input type="text" name="city"
           value="<%= student.getCity() %>">
    <br><br>

    <button type="submit">Update Student</button>

</form>

</body>
</html>