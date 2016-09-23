<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>The Projects</title>
</head>
<body>
	<h1>Projects Portfolio</h1>
	<table>
	<c:forEach var="project" items="${projects}">
	<tr>
		<td>${project.description}</td>
		<td>${project.location}</td>
		<td>${project.startDate}</td>
		<td>${project.endDate}</td>
		<td><a href="projects/${project.id}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addProject.html"> Add New Project</a>
</body>
</html>