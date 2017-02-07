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

	public String getmCategoryType() {
		return mCategoryType;
	}// End of getmCategoryType method

	public void setmCategoryType(String mCategoryType) {
		this.mCategoryType = mCategoryType;
	}// End of setmCategoryType method

	public long getmCategoryScore() {
		return mCategoryScore;
	}// End of getmCategoryScore method

	public void setmCategoryScore(long mCategoryScore) {
		this.mCategoryScore = mCategoryScore;
	}// End of setmCategoryScore method

	public String getmFileSize() {
		return mFileSize;
	}// End of getmFileSize method

	public void setmFileSize(String mFileSize) {
		this.mFileSize = mFileSize;
	}// End of setmFileSize method

	public long getmFileSizeScore() {
		return mFileSizeScore;
	}// End of getmFileSizeScore method

	public void setmFileSizeScore(long mFileSizeScore) {
		this.mFileSizeScore = mFileSizeScore;
	}// End of setmFileSizeScore method

	public String getmCategoryName() {
		return mCategoryName;
	}// End of getmCategoryName method

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}// End of setmCategoryName method

	public String getmSubCategoryTagName() {
		return mSubCategoryTagName;
	}// End of getmSubCategoryTagName method

	public void setmSubCategoryTagName(String mSubCategoryTagName) {
		this.mSubCategoryTagName = mSubCategoryTagName;
	}// End of setmSubCategoryTagName method

	public long getmSubCategoryTagScore() {
		return mSubCategoryTagScore;
	}// End of getmSubCategoryTagScore method

	public void setmSubCategoryTagScore(long mSubCategoryTagScore) {
		this.mSubCategoryTagScore = mSubCategoryTagScore;
	}// End of setmSubCategoryTagScore method

	public String getmContentId() {
		return mContentId;
	}// End of getmContentId method

	public void setmContentId(String mContentId) {
		this.mContentId = mContentId;
	}// End of setmContentId method

}// End of GamesSubTagsAndFileSizeScore class
