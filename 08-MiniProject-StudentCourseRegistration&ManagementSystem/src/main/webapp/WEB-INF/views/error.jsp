<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>

<style>

body{
    font-family: Arial;
    background-color: #f8d7da;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.error-box{
    background-color: white;
    padding: 30px;
    border-radius: 10px;
    width: 400px;
    text-align: center;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
    border-left: 8px solid red;
}

h2{
    color: red;
}

p{
    color: #333;
    margin-top: 10px;
}

a{
    display: inline-block;
    margin-top: 20px;
    text-decoration: none;
    background-color: #007bff;
    color: white;
    padding: 10px 15px;
    border-radius: 5px;
}

a:hover{
    background-color: #0056b3;
}

</style>

</head>
<body>

<div class="error-box">

    <h2>Something Went Wrong!</h2>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if(errorMessage != null){
    %>
        <p><%= errorMessage %></p>
    <%
        } else {
    %>
        <p>Unexpected error occurred. Please try again.</p>
    <%
        }
    %>

    <a href="login.jsp">Go to Login</a>

</div>

</body>
</html>