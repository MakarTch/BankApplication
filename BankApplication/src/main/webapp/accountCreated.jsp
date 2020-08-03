<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Created</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
Your account has been created! Sign into the application <a href="login.jsp">here</a>.<br>
Your User Id is ${user.getUserId()} and password is ${user.getPassword()}. Please remember these!
</div>
</body>
</html>