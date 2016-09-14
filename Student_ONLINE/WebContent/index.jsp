<%@page import="ces.login.in.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Coding Environment System</title>
<link rel='stylesheet' href='style.css'>
</head>
<body>
<div id="titl">
<h1>Coding Environment System</h1>
</div>
<div id="login">
<form action="login" method="post" id="login" name="login">
<table>
<tr><td colspan="2"><center>LOGIN</center></td></tr>
<tr><td>Server IP: </td><td><input type="text" name="id"></td></tr><br>
<tr><td>Username:  </td><td><input type="text" name="username" required></td></tr><br>
<tr><td>Password: </td><td><input type="password" name="pass" required></td></tr><br>
</table>
<div id="submitlogin">
<input type="submit" name="Submit" style="font-size:20px;">
<input type="reset" name="Reset" style="font-size:20px;">
</div>
</form>
</div>
<br><br><br>
<center>
<h3>For more information: <a href="http://smitshilu.in/ces" style="color: #CCC">ces.smitshilu.in</a></h3>
</center>

</body>
</html>