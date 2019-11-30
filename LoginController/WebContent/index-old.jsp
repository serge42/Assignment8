<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form name="loginFrm" method="get" action="/LoginController/LoginController">
	Enter username: <input type="text" name="username" />
	Enter password: <input type="password" name="pwd" />
	<button type="submit" name="command" value="login.login">Log in</button>
	</form>
	<br />
	Not registered yet, <a href="loginPages/register.jsp">register here.</a>
</body>
</html>