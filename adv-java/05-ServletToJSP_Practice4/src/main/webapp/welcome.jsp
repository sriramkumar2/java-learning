
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSP Page Directive: Defines page settings. -->

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

    <!--
    JSP Expression Language (EL) retrieves
    the username attribute from the request.
    -->

    <h2>Welcome, ${username}!</h2>

</body>
</html>