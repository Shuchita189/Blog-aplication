<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <form action="register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name"><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email"><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br>
        <label for="role">Role:</label>
        <select id="role" name="role">
            <option value="Admin">Admin</option>
            <option value="Viewer">Viewer</option>
        </select><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
