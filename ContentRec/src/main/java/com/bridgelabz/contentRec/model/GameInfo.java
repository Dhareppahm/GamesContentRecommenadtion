/*
* @Author:Dhareppa Metri
* File:GameInfo.java
* Purpose:POJO class for to store game information.
**/
package com.bridgelabz.contentRec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GameInfo")
public class GameInfo {
	@Id
	@Column(name = "content_Id")
	private String mContentId;// game Id
	@Column(name = "content_Name")
	private String mContentName;// game name
	@Column(name = "content_Type_Id")
	private String mContentTypeId;// game content type Id
	@Column(name = "group_Id")
	private String mGroupId;// game group Id
	@Column(name = "category_Id")
	private String mCategoryId;// game category Id
	@Column(name = "category_Name")
	private String mCategoryName;// game category name
	@Column(name = "total_Downloads")
	private String mTotalDownloads;// game total downloads
	@Column(name = "file_Size")
	private String mFileSize;// game file size
	@Column(name = "manifest_Package_Name")
	private String mManifestPackageName;// game package name
	@Column(name = "content_Download_Url")
	private String mContentDownloadUrl;// game download url link
	@Column(name = "meta_Tags")
	private String mMetaTags;// game sub tags
	@Column(name = "content_Review_Total")
	private String mContentReviewTotal;// game total review
	@Column(name = "content_Rating")
	private String mContentRating;// game rating
	@Column(name = "content_Thumbnail_Url")
	private String mContentThumbnailUrl;// game image url link

	public String getmContentId() {
		return mContentId;
	}

	public void setmContentId(String mContentId) {
		this.mContentId = mContentId;
	}

	public String getmContentName() {
		return mContentName;
	}

	public void setmContentName(String mContentName) {
		this.mContentName = mContentName;
	}

	public String getmContentTypeId() {
		return mContentTypeId;
	}

	public void setmContentTypeId(String mContentTypeId) {
		this.mContentTypeId = mContentTypeId;
	}

	public String getmGroupId() {
		return mGroupId;
	}

	public void setmGroupId(String mGroupId) {
		this.mGroupId = mGroupId;
	}

	public String getmCategoryId() {
		return mCategoryId;
	}

	public void setmCategoryId(String mCategoryId) {
		this.mCategoryId = mCategoryId;
	}

	public String getmCategoryName() {
		return mCategoryName;
	}

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}

	public String getmTotalDownloads() {
		return mTotalDownloads;
	}

	public void setmTotalDownloads(String mTotalDownloads) {
		this.mTotalDownloads = mTotalDownloads;
	}

	public String getmFileSize() {
		return mFileSize;
	}

	public void setmFileSize(String mFileSize) {
		this.mFileSize = mFileSize;
	}

	public String getmManifestPackageName() {
		return mManifestPackageName;
	}

	public void setmManifestPackageName(String mManifestPackageName) {
		this.mManifestPackageName = mManifestPackageName;
	}

	public String getmContentDownloadUrl() {
		return mContentDownloadUrl;
	}

	public void setmContentDownloadUrl(String mContentDownloadUrl) {
		this.mContentDownloadUrl = mContentDownloadUrl;
	}

	public String getmMetaTags() {
		return mMetaTags;
	}

	public void setmMetaTags(String mMetaTags) {
		this.mMetaTags = mMetaTags;
	}

	public String getmContentReviewTotal() {
		return mContentReviewTotal;
	}

	public void setmContentReviewTotal(String mContentReviewTotal) {
		this.mContentReviewTotal = mContentReviewTotal;
	}

	public String getmContentRating() {
		return mContentRating;
	}

	public void setmContentRating(String mContentRating) {
		this.mContentRating = mContentRating;
	}

	public String getmContentThumbnailUrl() {
		return mContentThumbnailUrl;
	}

	public void setmContentThumbnailUrl(String mContentThumbnailUrl) {
		this.mContentThumbnailUrl = mContentThumbnailUrl;
	}

}
