<%@ page import="java.util.List, com.ems.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
		<h2>Employee Details</h2>
		<table border="1">
		<thead>
		<tr>
		<th>Employee ID</th>
		<th>Employee Name</th>
		<th>Email</th>
		<th>Salary</th>
		<th>Department</th>
		</tr>
		</thead>
		<tbody>

    <%
        List<Employee> employees =
            (List<Employee>) request.getAttribute("employees");

        for (Employee emp : employees) {
    %>

        <tr>
            <td><%= emp.getEmployeeId() %></td>
            <td><%= emp.getEmployeeName() %></td>
            <td><%= emp.getEmail() %></td>
            <td><%= emp.getSalary() %></td>
            <td><%= emp.getDepartment() %></td>
        </tr>

    <%
        }
    %>

</tbody>
		</table>
		<br><br>
<a href="index.html">Back to Home</a>
</body>
</html>