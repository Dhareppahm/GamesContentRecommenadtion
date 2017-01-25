/*
* @Author:Dhareppa Metri
* File:VisitorsInfoService.java
* Purpose:Service interface for game visitors information.
**/
package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.VisitorsInfo;

public interface VisitorsInfoService {
	public void addVisitors(VisitorsInfo parVisitorsInfo);

	public List<VisitorsInfo> getVisitorsInfoByContentId(String parContetnId);

	public String getVisitorsInfoByVisitorId(String parVisitorId);
	
	public List getCategoryNameByVisitorId(String parVisitorId);
}
