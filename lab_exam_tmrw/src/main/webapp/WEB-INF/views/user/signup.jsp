<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="user">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Employee Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td>Employee Email</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" /></td>
			</tr>
			<tr>
				<td>Employee Password</td>
				<td><form:input  path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="SignUp" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>