/*
* @Author:Dhareppa Metri
* File:VisitorsInfoServiceImpl.java
* Purpose:Implementation class for the interface VisitorsInfoService.
**/
package com.bridgelabz.contentRec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.contentRec.dao.VisitorsInfoDao;
import com.bridgelabz.contentRec.model.VisitorsInfo;
import com.bridgelabz.contentRec.services.VisitorsInfoService;

public class VisitorsInfoServiceImpl implements VisitorsInfoService {
	@Autowired
	VisitorsInfoDao visitorsInfoDao;

	public void addVisitors(VisitorsInfo parVisitorsInfo) {
		visitorsInfoDao.addVisitors(parVisitorsInfo);

	}

	@Override
	public List<VisitorsInfo> getVisitorsInfoByContentId(String parContetnId) {
		List<VisitorsInfo> visitorsInfo = visitorsInfoDao.getVisitorsInfoByContentId(parContetnId);
		return visitorsInfo;
	}

	@Override
	public String getVisitorsInfoByVisitorId(String parVisitorId) {
		String visitorsInfo =visitorsInfoDao.getVisitorsInfoByVisitorId(parVisitorId);
		return visitorsInfo;

	}
	
	@Override
	public List getCategoryNameByVisitorId(String parVisitorId) {
		List categoryNameList = visitorsInfoDao.getCategoryNameByVisitorId(parVisitorId);
		return categoryNameList;
	}

}
