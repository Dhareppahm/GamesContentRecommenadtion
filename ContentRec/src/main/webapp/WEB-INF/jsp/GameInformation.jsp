<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>Display game content</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 5px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<h2>Game Information</h2>
<table>
	<tr>
	    <th>Game Image</th>
		<th>contentId</th>
		<th>contentName</th>
		<th>contentTypeId</th>
		<th>groupId</th>
		<th>categoryId</th>
		<th>categoryName</th>
		<th>downloads</th>
		<th>fileSize</th>
		<th>manifestPackageName</th>
		<th>contentDownloadUrl</th>
		<th>metaTags</th>
		<th>contentReviewTotal</th>
		<th>contentRating</th>
	</tr>
	<c:forEach var="game" items="${gameInfo}">
		<tr>
<td><img src="${game.mContentThumbnailUrl}" width="180px" height="180px"/></td>
			<td>${game.mContentId}</td>
			<td>${game.mContentName}</td>
			<td>${game.mContentTypeId}</td>
			<td>${game.mGroupId}</td>
			<td>${game.mCategoryId}</td>
			<td>${game.mCategoryName}</td>
			<td>${game.mTotalDownloads}</td>
			<td>${game.mFileSize}</td>
			<td>${game.mManifestPackageName}</td>
			<td>${game.mContentDownloadUrl}</td>
			<td>${game.mMetaTags}</td>
			<td>${game.mContentReviewTotal}</td>
			<td>${game.mContentRating}</td>

		</tr>
	</c:forEach>
</table>