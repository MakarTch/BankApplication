<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<link rel="stylesheet" href="bankstyle.css">
</head>
<body>
<div class="navbar"></div>
<div class="content"><!-- Maybe I'll make this into a nice little js thing -->
<h1>New Account Info</h1>
<p>Please enter your new account information:
<form action="accountCreated">
<div >
<label for="lastName">Last Name</label>
<input type="text" name="lastName" autocomplete ="off" required><br>
</div>
<div>
<label for="firstName">First Name</label>
<input type="text" name="firstName" autocomplete ="off" required><br>
</div>
<div>
<label for="address">Address</label>
<input type="text" name="address" autocomplete ="off" required><br>
</div>
<div>
<label for="contactNumber">Contact Number</label>
<input type="text" name="contactNumber" autocomplete ="off" required><br>
</div>
<div>
<label for="password">Password</label>
<input type="password" name="password" autocomplete ="off" required><br>
</div>
<div>
<label for="initialDeposit">Initial Deposit</label>
<input type="number" name="initialDeposit" autocomplete ="off" required><br>
</div>
<input type="submit">
</form>
</div>
</body>
</html>