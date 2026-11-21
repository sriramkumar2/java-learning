<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Employee</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <h2>Delete Employee</h2>

    <form action="EmployeeServlet" method="post">

        <label>Employee ID:</label>
        <input type="number" name="employeeId" required>

        <br><br>

        <button type="submit" name="action" value="delete">
            Delete Employee
        </button>
<br><br>

    </form>
    <a href="index.html">Back to Home</a>

</body>
</html>
