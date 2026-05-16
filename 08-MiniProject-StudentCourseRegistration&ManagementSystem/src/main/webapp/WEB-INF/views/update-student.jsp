<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Update Student</title>
</head>
<body>

<h2>Update Student</h2>

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
%>

<form action="UpdateStudentServlet" method="post">

    <input type="hidden"
           name="studentId"
           value="${student.studentId}">

    Name:
    <input type="text"
           name="studentName"
           value="${student.studentName}">
    <br><br>

    Email:
    <input type="email"
           name="email"
           value="${student.email}">
    <br><br>

    Phone:
    <input type="text"
           name="phone"
           value="${student.phone}">
    <br><br>

    Age:
    <input type="text"
           name="age"
           value="${student.age}">
    <br><br>

    City:
    <input type="text"
           name="city"
           value="${student.city}">
    <br><br>

    <button type="submit">
        Update Student
    </button>

</form>

</body>
</html>