<%@page import="java.util.*"%>
<%@page import="java.io.*;"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contest Page</title>
</head>
<body>

<h1>Welcome, <% out.print(session.getAttribute("name")); %>! </h1>
<h4><a href="logout">logout</a></h4>

</body>
</html>