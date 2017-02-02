<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Visitor Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<br>
	<br>
	<form class="form-inline" action="gamesCategoryNameAndGamesNameRecommendation" method="post">
		<div class="form-group mx-sm-3">
			<input type="text" class="form-control"
				placeholder="Visitor ID" name="visitorId" required/>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>
