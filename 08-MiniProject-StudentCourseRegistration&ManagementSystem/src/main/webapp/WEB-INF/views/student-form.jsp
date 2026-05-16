<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Add Student</title>
</head>
<body>

<h2>Add Student</h2>

<!-- Error message -->
<p style="color:red;">
    ${errorMessage}
</p>

<form action="AddStudentServlet" method="post">

    Name: <input type="text" name="studentName"><br><br>

    Email: <input type="text" name="email"><br><br>

    Phone: <input type="text" name="phone"><br><br>

    Age: <input type="number" name="age"><br><br>

    City: <input type="text" name="city"><br><br>

    <input type="submit" value="Add Student">

</form>

</body>
</html>