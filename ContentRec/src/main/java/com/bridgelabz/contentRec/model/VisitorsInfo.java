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
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getmVisitorId() {
		return mVisitorId;
	}

	public void setmVisitorId(String mVisitorId) {
		this.mVisitorId = mVisitorId;
	}

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

	public String getmCategoryName() {
		return mCategoryName;
	}

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
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
