<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$(".loader").fadeOut("slow");
	})
</script>
</head>
<body>
	<!-- Load the icon while page loading  -->
	<h2>Game Content Recommendation</h2>
	<div class="loader"></div>
	<br>
	<div class="container">


		<a href="fetchAndSaveGameInfo" class="btn btn-info"><h4>Fetch and save game content</h4></a><br><br>
		<a href="displayGameInfo" class="btn btn-info" ><h4>Display game content</h4></a><br><br>
		<a href="uploadCSVToDb" class="btn btn-info"><h4>Upload CSV file to DB</h4></a><br><br>
        <a href="storeUserInfo" class="btn btn-info"><h4>Store user Information to DB</h4></a> <br><br>
		<a href="getUserHistory" class="btn btn-info"><h4>User download and view history</h4></a><br><br>
		<a href="getCategoryScore" class="btn btn-info"><h4>Category score for each visitor</h4></a><br><br>
		<a href="userContentInfo" class="btn btn-info"><h4>Sub tags score for each visitor</h4></a><br><br>
	    <a href="gamesCategoryNameRecommendation" class="btn btn-info"><h4>Games recommendation based on most visited game categories</h4></a><br><br>
		<a href="gamesRecommendationBasedOnMostVisitedSubTags" class="btn btn-info"><h4>Games recommendation based on most visited sub tags</h4></a><br><br>
		<a href="gamesRecommendationBasedOnFileSize" class="btn btn-info"><h4>Games recommendation based on file size</h4></a><br><br>

	</div>

</body>
</html>