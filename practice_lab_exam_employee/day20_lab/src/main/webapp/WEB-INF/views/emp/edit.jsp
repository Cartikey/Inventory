<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" modelAttribute="employee" >
	<%-- <input type="hidden" name ="id" value= "${emp_details.id}"/> --%>
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Employee Name</td>
				<td><form:input path="name" value='${emp_details.name}' /></td>
					</tr>
			<tr>
				<td>Employee Address</td>
				<td><form:input path="address" value='${emp_details.address}' /></td>
				
			</tr>
			<tr>
				<td>Employee Salary</td>
				<td><form:input type="number" path="salary" value='${emp_details.salary}'/></td>
				
			</tr>
			<tr>
				<td>Join Date</td>
				<td><form:input type="date" path="joinDate" value='${emp_details.joinDate}' /></td>
				
			</tr>
			
			<tr>
				<td><input type="submit" value="Update"/></td>
			</tr>

		</table>
	</form:form>
</body>
</html>