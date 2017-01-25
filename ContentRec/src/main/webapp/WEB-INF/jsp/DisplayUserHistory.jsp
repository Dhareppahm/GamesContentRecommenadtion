
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
	padding: 4px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<table>
		<h2 align="left">User download and View History</h2>
	<tr>
		<th>userId</th>
		<th>contentId</th>
		<th>contentName</th>
		<th>categoryName</th>
		<th>categoryScore</th>
		<th>tag</th>
		<th>tagScore</th>
		<th>fileSize</th>
		<th>sizeScore</th>
		<th>groupId</th>
		<th>groupScore</th>
		<th>view</th>
		<th>download</th>
	</tr>
	<c:forEach var="user" items="${userInfo}">
		<tr>
			<td>${user.mUserId}</td>
			<td>${user.mContentId}</td>
			<td>${user.mContentName}</td>
			<td>${user.mCategoryName}</td>
			<td>${user.mCategoryScore}</td>
			<td>${user.mTag}</td>
			<td>${user.mTagScore}</td>
			<td>${user.mFileSize}</td>
			<td>${user.mSizeScore}</td>
			<td>${user.mGroupId}</td>
			<td>${user.mGroupScore}</td>
			<td>${user.mView}</td>
			<td>${user.mDownload}</td>
		</tr>
	</c:forEach>
</table>