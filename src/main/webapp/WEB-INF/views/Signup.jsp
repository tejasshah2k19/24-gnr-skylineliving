<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Signup</h2>
	<form action="saveuser" method="post">
		FirstName: <input type="text" name="firstName" /><br>
		<br> Email:<input type="text" name="email" /><br>
		<br> Password : <input type="password" name="password" /><br>
		<br> 
		ContactNum : <input type="text" name="contactNum"/><br><br> 
		<input type="submit" value="signup" />
	</form>
	<br>
	<a href="login">Login</a>

</body>
</html>