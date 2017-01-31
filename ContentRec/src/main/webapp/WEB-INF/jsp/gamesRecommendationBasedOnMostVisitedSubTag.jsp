
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 5px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<table>
		<h3 align="left">Games Content Recommendation</h3> 
		<tr>
			<th> Content Recommendation Based On:</th>
		    <td><h4>Recent Searched Sub Tags History</h4></td>
		</tr>

	</table>
<table>
	<tr>
		<th>Visitor Id</th>
		<th>Sub Tag Name</th>
		<th>Sub Tag  Score</th>
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
<h2>Recommended games:</h2>
<table>
	<tr>
		<th>Game Image</th>
		<th>Game Name</th>
		<th>Game Rating</th>
		<th>File Size</th>
		<th>Total Downloads</th>
	</tr>
	<c:forEach var="gameInfo" items="${GameInfoAndSubTagsmap.GameInfo}">
		<c:forEach var="game" items="${gameInfo}">
 		<tr>
 		<td><img src="${game.mContentThumbnailUrl}" width="150px" height="150px"/></td>
 			<%-- //<td>${game.mContentThumbnailUrl}</td> --%>
			<td>${game.mContentName}</td>
			<!-- Rating --><td>${game.mContentRating}</td>
			<!-- File Size: --><td>${game.mFileSize}</td>
			<!-- Total Downloads --><td>${game.mTotalDownloads}</td>
		</tr>
		</c:forEach>
 	</c:forEach>
</table>
