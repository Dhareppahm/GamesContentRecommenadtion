<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 25%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 15px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<h3 align="left">Enter the Content Id</h3>
	<form method="post" action="storeUserDatatoDb">
		<table>
			<tr>
				<td>Content ID</td>
				<td><input type="text" name="contentId" required />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SUBMIT" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
