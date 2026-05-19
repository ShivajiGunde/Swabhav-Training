<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>

body{
    font-family: Arial;
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.login-box{
    background-color: white;
    padding: 30px;
    border-radius: 10px;
    width: 300px;
    box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
}

h2{
    text-align: center;
    margin-bottom: 20px;
}

input[type="text"], input[type="password"]{
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}

button{
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    border: none;
    color: white;
    border-radius: 5px;
    cursor: pointer;
}

button:hover{
    background-color: #0056b3;
}

.error{
    color: red;
    text-align: center;
}

</style>

</head>
<body>

<div class="login-box">

    <h2>Login</h2>

    <!-- Error Message -->
    <%
        String error = (String) request.getAttribute("error");
        if(error != null){
    %>
        <p class="error"><%= error %></p>
    <%
        }
    %>
    
    

    <!-- Login Form -->
    <form action="LoginServletAdmin" method="post">

        <label>Username</label>
        <input type="text" name="username" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <button type="submit">Login</button>

    </form>

</div>

</body>
</html>