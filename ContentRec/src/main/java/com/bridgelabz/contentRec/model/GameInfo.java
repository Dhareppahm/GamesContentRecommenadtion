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
	}// End of getmContentId method

	public void setmContentId(String mContentId) {
		this.mContentId = mContentId;
	}// End of setmContentId method

	public String getmContentName() {
		return mContentName;
	}// End of getmContentName method

	public void setmContentName(String mContentName) {
		this.mContentName = mContentName;
	}// End of setmContentName method

	public String getmContentTypeId() {
		return mContentTypeId;
	}// End of getmContentTypeId method

	public void setmContentTypeId(String mContentTypeId) {
		this.mContentTypeId = mContentTypeId;
	}// End of setmContentTypeId method

	public String getmGroupId() {
		return mGroupId;
	}// End of getmGroupId method

	public void setmGroupId(String mGroupId) {
		this.mGroupId = mGroupId;
	}// End of setmGroupId method

	public String getmCategoryId() {
		return mCategoryId;
	}// End of getmCategoryId method

	public void setmCategoryId(String mCategoryId) {
		this.mCategoryId = mCategoryId;
	}// End of setmCategoryId method

	public String getmCategoryName() {
		return mCategoryName;
	}// End of getmCategoryName method

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}// End of setmCategoryName method

	public String getmTotalDownloads() {
		return mTotalDownloads;
	}// End of getmTotalDownloads method

	public void setmTotalDownloads(String mTotalDownloads) {
		this.mTotalDownloads = mTotalDownloads;
	}// End of setmTotalDownloads method

	public String getmFileSize() {
		return mFileSize;
	}// End of getmFileSize method

	public void setmFileSize(String mFileSize) {
		this.mFileSize = mFileSize;
	}// End of setmFileSize method

	public String getmManifestPackageName() {
		return mManifestPackageName;
	}// End of getmManifestPackageName method

	public void setmManifestPackageName(String mManifestPackageName) {
		this.mManifestPackageName = mManifestPackageName;
	}// End of setmManifestPackageName method

	public String getmContentDownloadUrl() {
		return mContentDownloadUrl;
	}// End of getmContentDownloadUrl method

	public void setmContentDownloadUrl(String mContentDownloadUrl) {
		this.mContentDownloadUrl = mContentDownloadUrl;
	}// End of setmContentDownloadUrl method

	public String getmMetaTags() {
		return mMetaTags;
	}// End of getmMetaTags method

	public void setmMetaTags(String mMetaTags) {
		this.mMetaTags = mMetaTags;
	}// End of setmMetaTags method

	public String getmContentReviewTotal() {
		return mContentReviewTotal;
	}// End of getmContentReviewTotal method

	public void setmContentReviewTotal(String mContentReviewTotal) {
		this.mContentReviewTotal = mContentReviewTotal;
	}// End of setmContentReviewTotal method

	public String getmContentRating() {
		return mContentRating;
	}// End of getmContentRating method

	public void setmContentRating(String mContentRating) {
		this.mContentRating = mContentRating;
	}// End of setmContentRating method

	public String getmContentThumbnailUrl() {
		return mContentThumbnailUrl;
	}// End of getmContentThumbnailUrl method

	public void setmContentThumbnailUrl(String mContentThumbnailUrl) {
		this.mContentThumbnailUrl = mContentThumbnailUrl;
	}// End of setmContentThumbnailUrl method

}// End of GameInfo class
