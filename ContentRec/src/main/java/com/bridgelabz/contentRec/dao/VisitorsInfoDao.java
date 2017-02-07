/*
* @Author:Dhareppa Metri
* File:VisitorsInfoDao.java
* Purpose:DAO interface for visitors Information.
**/
package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.VisitorsInfo;

public interface VisitorsInfoDao {

	// This method is used to add visitors.
	public void addVisitors(VisitorsInfo parVisitorsInfo);

	// This method is used to get visitors information by content Id.
	public List<VisitorsInfo> getVisitorsInfoByContentId(String parContentId);

	// This method is used to get visitors information by visitor Id.
	public String getVisitorsInfoByVisitorId(String parVisitorId);

	// This method is used to get game category name by visitor Id.
	public List getCategoryNameByVisitorId(String parVisitorId);

	// This method is used to get content Id by visitor Id.
	public List getContentIdByVisitorId(String parVisitorId);
}// End of VisitorsInfoDao interface
