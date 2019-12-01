<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	Complete the from: <br /> <br />
	<form name="register" method="get" action="/LoginController/FrontController">
		<table>
		<tr>
			<td>Username: </td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>E-mail: </td>
			<td><input type="email" name="email" /></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="pwd" /></td>
		</tr>
		<tr>
			<td>Repeat password: </td>
			<td><input type="password" name="pwd2" /></td>
		</tr>
		<tr>
			<td><button type="submit" name="command" value="register.CreateUser">Submit</button></td>
		</tr>
		</table>
	</form>
</body>
</html>