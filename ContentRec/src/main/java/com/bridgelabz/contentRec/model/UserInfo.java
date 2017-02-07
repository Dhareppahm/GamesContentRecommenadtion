/*
* @Author:Dhareppa Metri
* File:UserInfo.java
* Purpose:POJO class for to store user information.
**/
package com.bridgelabz.contentRec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "UserInfo")
public class UserInfo {
	@Id
	@GenericGenerator(name = "gene", strategy = "increment")
	@GeneratedValue(generator = "gene")
	@Column(name = "Id")
	private int mId;
	@Column(name = "content_Id")
	private String mContentId;// game Id
	@Column(name = "user_Id")
	private String mUserId;// visitor Id,fetch from CSV file
	@Column(name = "content_Name")
	private String mContentName;// game name,fetch from RestCall
	@Column(name = "category_Name")
	private String mCategoryName;// game category name,fetch from RestCall
	@Column(name = "category_Score")
	private String mCategoryScore;// game category score,we should calculate
	@Column(name = "tag")
	private String mTag;// game sub tags,fetch from RestCall
	@Column(name = "tag_Score")
	private String mTagScore;// game sub tags score,we should calculate
	@Column(name = "fileSize")
	private String mFileSize;// game file size,fetch from RestCall
	@Column(name = "size_Score")
	private String mSizeScore;// game file size score,we should calculate
	@Column(name = "group_ID")
	private String mGroupId;// game group Id,fetch from RestCall
	@Column(name = "group_Score")
	private String mGroupScore;// game group score,we should calculate
	@Column(name = "view")
	private String mView;// game view status,fetch from CSV file
	@Column(name = "download")
	private String mDownload;// game download status,fetch from CSV file

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmContentId() {
		return mContentId;
	}

	public void setmContentId(String mContentId) {
		this.mContentId = mContentId;
	}

	public String getmUserId() {
		return mUserId;
	}

	public void setmUserId(String mUserId) {
		this.mUserId = mUserId;
	}

	public String getmContentName() {
		return mContentName;
	}

	public void setmContentName(String mContentName) {
		this.mContentName = mContentName;
	}

	public String getmCategoryName() {
		return mCategoryName;
	}

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}

	public String getmCategoryScore() {
		return mCategoryScore;
	}

	public void setmCategoryScore(String mCategoryScore) {
		this.mCategoryScore = mCategoryScore;
	}

	public String getmTag() {
		return mTag;
	}

	public void setmTag(String mTag) {
		this.mTag = mTag;
	}

	public String getmTagScore() {
		return mTagScore;
	}

	public void setmTagScore(String mTagScore) {
		this.mTagScore = mTagScore;
	}

	public String getmFileSize() {
		return mFileSize;
	}

	public void setmFileSize(String mFileSize) {
		this.mFileSize = mFileSize;
	}

	public String getmSizeScore() {
		return mSizeScore;
	}

	public void setmSizeScore(String mSizeScore) {
		this.mSizeScore = mSizeScore;
	}

	public String getmGroupId() {
		return mGroupId;
	}

	public void setmGroupId(String mGroupId) {
		this.mGroupId = mGroupId;
	}

	public String getmGroupScore() {
		return mGroupScore;
	}

	public void setmGroupScore(String mGroupScore) {
		this.mGroupScore = mGroupScore;
	}

	public String getmView() {
		return mView;
	}

	public void setmView(String mView) {
		this.mView = mView;
	}

	public String getmDownload() {
		return mDownload;
	}

	public void setmDownload(String mDownload) {
		this.mDownload = mDownload;
	}

}
