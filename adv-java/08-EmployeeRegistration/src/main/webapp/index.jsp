
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>

    <h2>Employee Registration</h2>

    <form action="EmployeeServlet" method="post">

        Name:
        <input type="text" name="name" required>
        <br><br>

        Email:
        <input type="email" name="email" required>
        <br><br>

        Phone:
        <input type="text" name="phone" required>
        <br><br>

        <input type="submit" value="Submit">

    </form>

    <br>

    <%
        String message = (String) request.getAttribute("message");

        if (message != null) {
    %>

        <h3><%= message %></h3>

    <%
        }
    %>
<!--Link → EmployeeServlet → doGet() → fetches data → forwards to viewEmployees.jsp → shows records-->
<!-- JSP directly ❌

Link → viewEmployees.jsp → shows "No Employee Records Found" -->
<!-- Always send the request to the servlet, and let the servlet hand the data to the JSP. -->
    <a href="EmployeeServlet">View Employees</a>

</body>
</html>
