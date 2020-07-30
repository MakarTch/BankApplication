<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h1> Log in</h1>
<form action="verifyAccount">
<label for="user_id">User ID</label>
<input type="number" name="user_id" autocomplete="off"><br>
<label for="password">Password</label>
<input type="password" name="password">
<input type="submit" value="submit!">
</form>
</body>
</html>