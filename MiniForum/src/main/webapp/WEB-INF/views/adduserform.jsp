<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>

</head>
<body>
	<h1>Add new user</h1>
	<form:form method="POST" modelAttribute="addUserFormBacking">
		<table>
		<tr>
			<td><form:label path="username">User name:</form:label></td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td><form:label path="password">Password:</form:label></td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td><form:label path="password">Confirm password:</form:label></td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td><form:label path="info">Something about you:</form:label></td>
			<td><form:textarea path="info" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Save" /></td>
		</tr>
		</table>
	</form:form>
</body>
</html>