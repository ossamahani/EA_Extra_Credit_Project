<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a Car</title>
</head>
<body>
	<form action="../projects/${project.id}" method="post">
	<table>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="make" value="${project.description}" /> </td>
		</tr>
		<tr>
			<td>Location:</td>
			<td><input type="text" name="model" value="${project.location}" /> </td>
		</tr>
		<tr>
			<td>Start Date:</td>
			<td><input type="text" name="year" value="${projcet.startDate}" /> </td>
		</tr>
		<tr>
			<td>End Date:</td>
			<td><input type="text" name="color" value="${projct.endDate}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?projectId=${project.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>