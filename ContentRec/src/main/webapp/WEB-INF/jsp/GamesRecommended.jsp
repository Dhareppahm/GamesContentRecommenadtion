
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
<h2>Recommended games for visitor:${visitorID} based on visitor
	category history</h2>
<table>
	<tr>
		<th>Game Name</th>
		<th>Game Rating</th>
		<th>File Size</th>
		<th>Total Downloads</th>
	</tr>
	<c:forEach var="gameInfo" items="${gameInfo}">
		<tr>
			<td>${gameInfo.mContentName}</td>
			<td>${gameInfo.mContentRating}</td>
			<td>${gameInfo.mFileSize}</td>
			<td>${gameInfo.mTotalDownloads}</td>
		</tr>
	</c:forEach>
</table>