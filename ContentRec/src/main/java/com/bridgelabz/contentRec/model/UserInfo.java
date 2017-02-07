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
	}// End of getmId method

	public void setmId(int mId) {
		this.mId = mId;
	}// End of setmId method

	public String getmContentId() {
		return mContentId;
	}// End of getmContentId method

	public void setmContentId(String mContentId) {
		this.mContentId = mContentId;
	}// End of setmContentId method

	public String getmUserId() {
		return mUserId;
	}// End of getmUserId method

	public void setmUserId(String mUserId) {
		this.mUserId = mUserId;
	}// End of setmUserId method

	public String getmContentName() {
		return mContentName;
	}// End of getmContentName method

	public void setmContentName(String mContentName) {
		this.mContentName = mContentName;
	}// End of setmContentName method

	public String getmCategoryName() {
		return mCategoryName;
	}// End of getmCategoryName method

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}// End of setmCategoryName method

	public String getmCategoryScore() {
		return mCategoryScore;
	}// End of getmCategoryScore method

	public void setmCategoryScore(String mCategoryScore) {
		this.mCategoryScore = mCategoryScore;
	}// End of setmCategoryScore method

	public String getmTag() {
		return mTag;
	}// End of getmTag method

	public void setmTag(String mTag) {
		this.mTag = mTag;
	}// End of setmTag method

	public String getmTagScore() {
		return mTagScore;
	}// End of getmTagScore method

	public void setmTagScore(String mTagScore) {
		this.mTagScore = mTagScore;
	}// End of setmTagScore method

	public String getmFileSize() {
		return mFileSize;
	}// End of getmFileSize method

	public void setmFileSize(String mFileSize) {
		this.mFileSize = mFileSize;
	}// End of setmFileSize method

	public String getmSizeScore() {
		return mSizeScore;
	}// End of getmSizeScore method

	public void setmSizeScore(String mSizeScore) {
		this.mSizeScore = mSizeScore;
	}// End of setmSizeScore method

	public String getmGroupId() {
		return mGroupId;
	}// End of getmGroupId method

	public void setmGroupId(String mGroupId) {
		this.mGroupId = mGroupId;
	}// End of setmGroupId method

	public String getmGroupScore() {
		return mGroupScore;
	}// End of getmGroupScore method

	public void setmGroupScore(String mGroupScore) {
		this.mGroupScore = mGroupScore;
	}// End of setmGroupScore method

	public String getmView() {
		return mView;
	}// End of getmView method

	public void setmView(String mView) {
		this.mView = mView;
	}// End of setmView method

	public String getmDownload() {
		return mDownload;
	}// End of getmDownload method

	public void setmDownload(String mDownload) {
		this.mDownload = mDownload;
	}// End of setmDownload method

}// End of UserInfo class
