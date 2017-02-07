/*
* @Author:Dhareppa Metri
* File:VisitorsInfoService.java
* Purpose:Service interface for game visitors information.
**/
package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.VisitorsInfo;

public interface VisitorsInfoService {

	// This method is used to add visitors.
	public void addVisitors(VisitorsInfo parVisitorsInfo);

	// This method is used to get visitors information by content Id.
	public List<VisitorsInfo> getVisitorsInfoByContentId(String parContetnId);

	// This method is used to get visitors information by visitor Id.
	public String getVisitorsInfoByVisitorId(String parVisitorId);

	// This method is used to get game category name by visitor Id.
	public List getCategoryNamesByVisitorId(String parVisitorId);

	// This method is used to get content Id by visitor Id.
	public List getContentIdByVisitorId(String parVisitorId);
	
}// End of VisitorsInfoService class
