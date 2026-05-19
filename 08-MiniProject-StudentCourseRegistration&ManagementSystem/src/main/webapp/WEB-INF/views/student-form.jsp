<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.studentcourse.model.Student" %>

<html>
<head>
<title>Add Student</title>
</head>
<body>

<h2>Add Student</h2>

<%
String errorMessage =
(String) request.getAttribute("errorMessage");

if(errorMessage != null){
%>

<p style="color:red;">
    <%= errorMessage %>
</p>

<%
}

Student student =
(Student) request.getAttribute("student");
%>

<form action="AddStudentServlet" method="post">

    Name:
    <input type="text" name="studentName"
           value="<%= student != null ? student.getStudentName() : "" %>">
    <br><br>

    Email:
    <input type="text" name="email"
           value="<%= student != null ? student.getEmail() : "" %>">
    <br><br>

    Phone:
    <input type="text" name="phone"
           value="<%= student != null ? student.getPhone() : "" %>">
    <br><br>

    Age:
    <input type="number" name="age"
           value="<%= student != null ? student.getAge() : "" %>">
    <br><br>

    City:
    <input type="text" name="city"
           value="<%= student != null ? student.getCity() : "" %>">
    <br><br>

    <input type="submit" value="Add Student">

</form>

</body>
</html>