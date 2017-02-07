/*
* @Author:Dhareppa Metri
* File:VisitorsInfo.java
* Purpose:POJO class for to store visitors information.
**/
package com.bridgelabz.contentRec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "VisitorsInfo")
public class VisitorsInfo {
	@Id
	@GenericGenerator(name = "gene", strategy = "increment")
	@GeneratedValue(generator = "gene")
	@Column(name = "Id")
	private int mId;
	@Column(name = "visitor_ID")
	private String mVisitorId;// user Id
	@Column(name = "content_Id")
	private String mContentId;// game Id
	@Column(name = "Content_Name")
	private String mContentName;// game name
	@Column(name = "category_Name")
	private String mCategoryName;// game category name
	@Column(name = "view")
	private String mView;// game view status
	@Column(name = "download")
	private String mDownload;// game download status

	public int getmId() {
		return mId;
	}// End of getmId method

	public void setmId(int mId) {
		this.mId = mId;
	}// End of setmId method

	public String getmVisitorId() {
		return mVisitorId;
	}// End of getmVisitorId method

	public void setmVisitorId(String mVisitorId) {
		this.mVisitorId = mVisitorId;
	}// End of setmVisitorId method

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

	public String getmCategoryName() {
		return mCategoryName;
	}// End of getmCategoryName method

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}// End of setmCategoryName method

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

}// End of VisitorsInfo class
