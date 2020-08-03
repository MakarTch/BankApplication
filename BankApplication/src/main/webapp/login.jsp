<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<h1> Log in</h1>
<form action="verifyAccount" >
<label for="userId">User ID</label>
<input type="number" name="userId" autocomplete="off"><br>
<label for="password">Password</label>
<input type="password" name="password"><br>
<input type="submit" value="submit!">
</form>
</div>
</body>
</html>