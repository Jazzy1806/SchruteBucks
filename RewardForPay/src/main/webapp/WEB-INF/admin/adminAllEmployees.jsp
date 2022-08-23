<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Employee List</title>
</head>
<body>
<%@ include file="../nav.jsp" %>

<h1>Inside Admin All Employees</h1>

<%-- <table class="table table-striped table-hover">
		<thead class="table-light">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				
				
				
				
				
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${allEmployees}">

				<tr>
					<td>${employee.id}</td>
					<td><a href="findEmployeeById?employeeId=${employee.id}">${employee.firstName}</a></td>
					<td><a href="findEmployeeById?employeeId=${employee.id}">${employee.lastName}</a></td>
					<td><form action="updateEmployeeForm.do"><input type ="hidden" name="employeeId" value="${employee.id}"><button type="submit" class="btn btn-primary btn-sm">Update this Employee</button></form>
					
					
				</tr>
				
			</c:forEach>
		</tbody>
	</table>

 --%>
</body>
</html>