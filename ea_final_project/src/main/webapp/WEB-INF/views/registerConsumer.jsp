<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register a New Consumer</title>
</head>
<body>
  <h1>Register a New Consumer</h1>
	<form:form action="register" modelAttribute="consumer">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name"></form:errors>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address"/></td>
				<td><form:errors path="address"></form:errors>
			</tr>
			<tr>
				<td>username</td>
				<td><form:input path="username"/></td>
				<td><form:errors path="username"></form:errors>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password"/></td>
				<td><form:errors path="password"></form:errors>
			</tr>
		</table>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>