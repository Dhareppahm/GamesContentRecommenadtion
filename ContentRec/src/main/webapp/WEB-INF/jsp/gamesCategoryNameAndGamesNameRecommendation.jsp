
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
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<table>
	<h2 align="left">Recommended game categories for visitor
		ID:${visitorID}</h2>
	<tr>
		<th>Visitor Id</th>
		<th>Category Name</th>
		<th>Category Score</th>
	</tr>
	<tr>
	<tr>
		<td rowspan="10000">${visitorID}</td>
		<c:forEach var="game" items="${map.gameCategoryScore}">
			<td>${game.mCategoryName}</td>
			<td>${game.mCatMarks}</td>
	</tr>
	</c:forEach>
	
</table>
<h2>Recommended games for visitor:${visitorID} based on visitor
	category history</h2>
<table>
	<tr>
		<th>Game Name</th>
		<th>Game Rating</th>
		<th>File Size</th>
		<th>Total Downloads</th>
	</tr>
	<c:forEach var="gameInfo" items="${map.gameInfo}">
		<tr>
			<td>${gameInfo.mContentName}</td>
			<td>${gameInfo.mContentRating}</td>
			<td>${gameInfo.mFileSize}</td>
			<td>${gameInfo.mTotalDownloads}</td>
		</tr>
	</c:forEach>
</table>
<%-- <a href="<c:url value="gamesRecommended"/>?visitorId=${visitorID}"><h2>Recommended games for Visitor ${visitorID}</a></h2>
 --%>