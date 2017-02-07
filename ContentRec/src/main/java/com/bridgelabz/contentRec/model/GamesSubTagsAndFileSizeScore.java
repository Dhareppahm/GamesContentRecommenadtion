package com.bridgelabz.contentRec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GamesSubTagsAndFileSizeScore")
public class GamesSubTagsAndFileSizeScore {
	@Id
	@GenericGenerator(name = "gene", strategy = "increment")
	@GeneratedValue(generator = "gene")
	@Column(name = "id")
	public int mId;
	@Column(name = "visitor_Id")
	public String mVisitorId;// visitor Id
	@Column(name = "category_Type")
	public String mCategoryType;// game category type
	@Column(name = "category_Name")
	public String mCategoryName;// game category name
	@Column(name = "category_Score")
	public long mCategoryScore;// game category score
	@Column(name = "sub_Category_Tag_Name")
	public String mSubCategoryTagName;// game sub tag name
	@Column(name = "sub_Category_Tag_Score")
	public long mSubCategoryTagScore;// game sub tag score
	@Column(name = "file_Size")
	public String mFileSize;// game file size
	@Column(name = "file_Size_Score")
	public long mFileSizeScore;// game file size score
	@Column(name = "content_Id")
	public String mContentId;// game Id

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
