<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="background-color: lightgrey; margin: auto">
		<caption>All Employees from Department ID : ${param.deptId}</caption>
		<tr>
		        <td>Emp Id</td>
				<td>Emp Name</td>
				<td>Emp Address</td>
				<td>Emp Salary</td>
				<td>Emp Join Date</td>
				<td>Actions</td>
		<tr/>
		<c:forEach var="emp" items="${requestScope.emp_list}">
		<tr>

		<tr/>
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.address}</td>
				<td>${emp.salary}</td>
				<td>${emp.joinDate}</td>
				<td>
					<a href="<spring:url value='/dept/emp/del/${emp.id }'/>" onclick="return confirm('Are you sure?')" >Delete</a>
				</td>
					<td>
					<a href="<spring:url value='/dept/emp/edit/${emp.id }'/>">Update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h5><a href="<spring:url value='/dept/emp/add'/>">Add New Employee</a></h5>

</body>
</html>