<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
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
	<div class="loader"></div>
	<br>
	<table>
	<h3 align="left">Games Content Recommendation</h3>
	<tr>
		<th>Content recommendation based on:</th>
		<td><h4>Recent visited/searched game sub tags history</h4></td>
	</tr>

</table>
	<!-- BootStrap Card to display Image and Info -->
	<table>
		<tr>
			<th>Visitor Id</th>
			<th>Sub Tag Name</th>
			<th>Sub Tag Score</th>
		</tr>
		<tr>
		<tr>
			<td rowspan="10000">${visitorID}</td>
			<c:forEach var="subTags" items="${GameInfoAndSubTagsmap.Subtags}">
				<td>${subTags.mSubCategoryTagName}</td>
				<td>${subTags.mSubCategoryTagScore}</td>
		</tr>
		</c:forEach>

	</table>
	<br>
	<h3>Recommended games:</h3>
	<!-- BootStrap Card to display Image and Info -->
	<br>
	<div class="container">
		<div class="row">
			<c:forEach items="${GameInfoAndSubTagsmap.GameInfo}" var="gameInfo">
				<c:forEach var="game" items="${gameInfo}">
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-4"
						style="margin-top: 20px;">
						<img class="card-img-top" height="200px" width="200px"
							src="${game.mContentThumbnailUrl}" alt="Card image cap">
						<div class="card-block">
							<h4 class="card-title">${game.mContentName}</h4>
							 Rating:
							<p class="card-text">${game.mContentRating}</p>
							File Size:
							<p class="card-text">${game.mFileSize}</p>
							Total Downloads:
							<p class="card-text">${game.mTotalDownloads}</p>
						</div>
					</div>
				</c:forEach>
			</c:forEach>
		</div>
	</div>
</body>
</html>