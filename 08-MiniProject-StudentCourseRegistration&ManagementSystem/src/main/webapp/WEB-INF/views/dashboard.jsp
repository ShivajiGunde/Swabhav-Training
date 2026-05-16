<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<style>
    body{
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin:0;
        padding:0;
    }

    .container{
        width: 400px;
        margin: 50px auto;
        background: white;
        padding: 25px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.2);
    }

    h2{
        text-align:center;
        color:#333;
    }

    ul{
        list-style:none;
        padding:0;
    }

    ul li{
        margin:10px 0;
    }

    ul li a{
        display:block;
        text-decoration:none;
        background:#007bff;
        color:white;
        padding:12px;
        border-radius:5px;
        transition:0.3s;
    }

    ul li a:hover{
        background:#0056b3;
    }
</style>

</head>
<body>

<div class="container">

    <h2>Dashboard Menu</h2>

    <ul>
        <li><a href="login.jsp">1. Log in</a></li>

<!--         <li><a href="dashboard.jsp">2. View Dashboard</a></li> -->

        <li><a href="AddStudentServlet">2. Add Student</a></li>

        <li><a href="ViewStudentsServlet">3. View Student List</a></li>

        <li><a href="UpdateStudentServlet">4. Update Student</a></li>

        <li><a href="DeleteStudentServlet">5. Delete Student</a></li>

        <li><a href="AddCourseServlet">6. Add Course</a></li>

        <li><a href="ViewCoursesServlet">7. View Course List</a></li>

        <li><a href="UpdateCourseServlet">8. Update Course</a></li>

        <li><a href="DeleteCourseServlet">9. Delete Course</a></li>

        <li><a href="RegisterStudentServlet">10. Register Student to Course</a></li>

        <li><a href="ViewRegistrationsServlet">11. View Registrations</a></li>

        <li><a href="LogoutServlet">12. Logout</a></li>
    </ul>

</div>

</body>
</html>