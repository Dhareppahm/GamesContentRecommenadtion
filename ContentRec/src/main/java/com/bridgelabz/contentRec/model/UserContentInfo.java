package com.bridgelabz.contentRec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "UserContentInfo")
public class UserContentInfo {
	@Id
	@GenericGenerator(name = "gene", strategy = "increment")
	@GeneratedValue(generator = "gene")
	@Column(name = "id")
	public int mId;
	@Column(name = "visitor_Id")
	public String mVisitorId;
	@Column(name = "category_Type")
	public String mCategoryType;
	@Column(name = "category_Name")
	public String mCategoryName;
	@Column(name = "category_Score")
	public long mCategoryScore;
	@Column(name = "sub_Category_Tag_Name")
	public String mSubCategoryTagName;
	@Column(name = "sub_Category_Tag_Score")
	public long mSubCategoryTagScore;
	@Column(name = "file_Size")
	public String mFileSize;
	@Column(name = "file_Size_Score")
	public long mFileSizeScore;
	@Column(name = "content_Id")
	public String mContentId;

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

	public String getmCategoryType() {
		return mCategoryType;
	}

	public void setmCategoryType(String mCategoryType) {
		this.mCategoryType = mCategoryType;
	}

	public long getmCategoryScore() {
		return mCategoryScore;
	}

	public void setmCategoryScore(long mCategoryScore) {
		this.mCategoryScore = mCategoryScore;
	}

	public String getmFileSize() {
		return mFileSize;
	}

	public void setmFileSize(String mFileSize) {
		this.mFileSize = mFileSize;
	}

	public long getmFileSizeScore() {
		return mFileSizeScore;
	}

	public void setmFileSizeScore(long mFileSizeScore) {
		this.mFileSizeScore = mFileSizeScore;
	}

	public String getmCategoryName() {
		return mCategoryName;
	}

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}

	public String getmSubCategoryTagName() {
		return mSubCategoryTagName;
	}

	public void setmSubCategoryTagName(String mSubCategoryTagName) {
		this.mSubCategoryTagName = mSubCategoryTagName;
	}

	public long getmSubCategoryTagScore() {
		return mSubCategoryTagScore;
	}

	public void setmSubCategoryTagScore(long mSubCategoryTagScore) {
		this.mSubCategoryTagScore = mSubCategoryTagScore;
	}

	public String getmContentId() {
		return mContentId;
	}

	public void setmContentId(String mContentId) {
		this.mContentId = mContentId;
	}

}
