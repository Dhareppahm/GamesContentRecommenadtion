/*
* @Author:Dhareppa Metri
* File:VisitorsInfoDao.java
* Purpose:DAO interface for visitors Information.
**/
package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.VisitorsInfo;

public interface VisitorsInfoDao {
	public void addVisitors(VisitorsInfo parVisitorsInfo);

	public List<VisitorsInfo> getVisitorsInfoByContentId(String parContentId);

	public String getVisitorsInfoByVisitorId(String parVisitorId);

	public List getCategoryNameByVisitorId(String parVisitorId);

	public List getContentIdByVisitorId(String parVisitorId);
}
