<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="country">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Country Name</td>
				<td><form:input path="countryName" /></td>
			</tr>
			<tr>
				<td>Continent</td>
				<td><form:input path="continent" /></td>
			</tr>
			<tr>
				<td>Population</td>
				<td><form:input type="number" path="population" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit Country" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>