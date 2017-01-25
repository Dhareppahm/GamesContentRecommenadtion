<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
h3 {
	padding-right: 100px;
}

h4 {
	padding-right: 100px;
	padding-top: 150px;
}

table {
	padding-right: 100px;
}
</style>
</head>
<body>

	<h3 align="right">Game content recommendation</h3>

	<form method="post" action="searchGameData">
		<table bgcolor="FloralWhite" cellpadding="5px" cellspacing="5px"
			align="right">
			<tr>
				<td>ContentID</td>
				<td><input type="text" name="contentId" required />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SUBMIT" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
