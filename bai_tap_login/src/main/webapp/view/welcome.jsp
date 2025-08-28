<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String username = null;
if (session != null) {
	username = (String) session.getAttribute("username");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h2>
		Welcome,
		<%=username%>!
	</h2>
	<a href="<%= request.getContextPath() %>/logout-servlet">Logout</a>
</body>
</html>