<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display User Information</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content">
<h1>User Information</h1>
${obj.displayUser(user)}<br>
<a href="accountActions">Back to menu</a>
</div>
</body>
</html>