<%@page import="com.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Users</h2>

	<%
	List<UserBean> users = (List<UserBean>) request.getAttribute("users");
	%>

	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Role</th>
		</tr>
		<%
		for (UserBean user : users) {
			out.print("<tr>");
			out.print("<td>" + user.getUserId() + "</td>");
			out.print("<td>" + user.getFirstName() + "</td>");
			out.print("<td>" + user.getEmail() + "</td>");
			out.print("<td>" + user.getRole() + "</td>");
			out.print("</tr>");
		}
		%>

	</table>
</body>
</html>