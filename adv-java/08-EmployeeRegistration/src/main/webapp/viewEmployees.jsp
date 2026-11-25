
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.practice.model.Employee" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employees</title>
</head>
<body>

    <h2>Employee Records</h2>

    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>

        <%
            List<Employee> employees =
                (List<Employee>) request.getAttribute("employees");

            if (employees != null && !employees.isEmpty()) {

                for (Employee employee : employees) {
        %>

        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getName() %></td>
            <td><%= employee.getEmail() %></td>
            <td><%= employee.getPhone() %></td>
        </tr>

        <%
                }
            } else {
        %>

        <tr>
            <td colspan="4">No Employee Records Found</td>
        </tr>

        <%
            }
        %>

    </table>

    <br>

    <a href="index.jsp">Add New Employee</a>

</body>
</html>
