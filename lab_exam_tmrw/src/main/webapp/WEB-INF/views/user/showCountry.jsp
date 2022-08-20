<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto" border="1">
	<!-- <h5>User info : </h5> -->

		<caption>user id : ${user_id}</caption>
		<caption>All Employees from Department ID : ${param.deptId}</caption>
		<tr>
			<td>Country Id</td>
			<td>Country Name</td>
			<td>Country Continent</td>
			<td>Country population</td>
			
			<td>Actions</td>
		<tr />
		<c:forEach var="list_country" items="${requestScope.list_country}">
			<tr>
				<td>${list_country.id}</td>
				<td>${list_country.countryName}</td>
				<td>${list_country.continent}</td>
				<td>${list_country.population}</td>
				<td><a href="<spring:url value='/user/country/delete/${list_country.id }'/>"
					onclick="return confirm('Are you sure?')">Delete</a></td>

			</tr>
		</c:forEach>
	</table>
	<h5>
		<a href="<spring:url value='/user/addCountries/${user_id}'/>">Add New Country</a>
	</h5>
	<h5>
		<a href="<spring:url value='/user/sortCountries/${user_details.id}'/>">Sort Country</a>
	</h5> 
</body>
</html>