/*
* @Author:Dhareppa Metri
* File:GameCategoryScore.java
* Purpose:POJO class for to store game category score information.
**/

package com.bridgelabz.contentRec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "GameCategoryScore")
public class GameCategoryScore {
	@Id
	@GenericGenerator(name = "gene", strategy = "increment")
	@GeneratedValue(generator = "gene")
	@Column(name = "Id")
	public int mId;
	@Column(name = "Visitor_Id")
	public String mVisitorId;// visitor ID
	@Column(name = "Category_Name")
	public String mCategoryName;// game category name
	@Column(name = "Cat_Marks")
	public long mCatMarks;// game category score

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

	public String getmCategoryName() {
		return mCategoryName;
	}// End of setmVisitorId method

	public void setmCategoryName(String mCategoryName) {
		this.mCategoryName = mCategoryName;
	}// End of setmCategoryName method

	public long getmCatMarks() {
		return mCatMarks;
	}// End of setmCategoryName method

	public void setmCatMarks(long mCatMarks) {
		this.mCatMarks = mCatMarks;
	}// End of setmCatMarks method

}// End of GameCategoryScore class
