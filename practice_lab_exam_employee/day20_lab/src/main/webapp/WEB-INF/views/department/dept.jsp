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
	<%-- url pattern : /dept/emp --%>
	<spring:url var="url" value="/dept/emp/list" />

	<form action="${url}" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Choose a Department</td>
				<td><select name="deptId">
						<c:forEach var="dept" items="${requestScope.depts}">
							<option value="${dept.id}">${dept.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose A Department" /></td>
			</tr>
		</table>
	</form>

</body>
</html>