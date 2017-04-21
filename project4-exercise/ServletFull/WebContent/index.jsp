<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Add Student</h1>
	<form action="StudentServlet" method="POST">
		<label for="name">Name</label>
		<input type="text" name="name" id="name"/>
		<button type="submit">add</button>
	</form>
	
	<ul>
		<% 
			if(request.getSession() != null) {
				for(String c:request.getSession().getValueNames()) {
					out.print("<li>" + request.getSession().getAttribute(c) + "</li>");
				}
			}
		%>
	</ul>
	
	<form action="StudentServlet" method="GET">
		<button type="submit">remove</button>
	</form>

</body>
</html>