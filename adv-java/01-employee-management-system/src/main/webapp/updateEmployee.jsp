
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <h2>Update Employee Details</h2>

    <form action="EmployeeServlet" method="post">

        <label>Employee ID:</label>
        <input type="number" name="employeeId" required>
        <br><br>

        <label>Employee Name:</label>
        <input type="text" name="employeeName" required>
        <br><br>

        <label>Email:</label>
        <input type="email" name="email" required>
        <br><br>

        <label>Salary:</label>
        <input type="number" name="salary" step="0.01" required>
        <br><br>

        <label>Department:</label>
        <input type="text" name="department" required>
        <br><br>

        <button type="submit" name="action" value="update">
            Update Employee
        </button>

    </form>
    <br><br>
<a href="index.html">Back to Home</a>
    

</body>
</html>
