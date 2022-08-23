<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../nav.jsp" %>

<h1>Inside Employee Details</h1>



	<div>
<c:choose>
<c:when test="${! empty employee}">

		<h2>Employee Details</h2>
		<ul>
			<li>First Name: ${employee.firstName}</li>
			<li>Last Name: ${employee.lastName}</li>
			<li> ID: ${employee.id}</li>

		</ul>

			<form action="deleteEmployee.do" method="GET" name="id">
		<label for="deleteEmployee">ID: </label> <input type="text" name="id"
			value="${employee.id}" placeholder="Delete by ID"> <input
			class="btn btn-danger" type="submit" value="Delete This Employee">
			<br>
		</form>
		
		<form action="adminUpdateEmployeeForm.do" method="GET"name="id">
		<label for="updateEmployee"> ID:</label> <input type="text" name="id"
			value="${employee.id}" placeholder="Update by ID"> <input
			class="btn btn-warning" type="submit" value="Update Employee Info">
	</form>
	
	<form action="home.do">
				<input class="btn btn-success" type="submit" value="Home">
			</form>
	
	</c:when>
	
	
	<c:otherwise>
	<h2>Employee Not Found</h2>
	</c:otherwise>
	</c:choose>
	</div>

</body>
</html>