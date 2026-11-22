<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	
	<h2>Welcome Page</h2>
	<%-- 
request is a JSP implicit object.

getParameter("username") retrieves the username
submitted through the HTML form.

<%= %> prints the returned value in the HTML response.
--%>
	<h3>
	Welcome , <%=
	request.getParameter("username")
	%>!
	</h3>
</body>
</html>