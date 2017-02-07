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

	/**
	 * This method is used to add visitor
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 */
	public void addVisitors(VisitorsInfo parVisitorsInfo) {
		visitorsInfoDao.addVisitors(parVisitorsInfo);

	}

	/**
	 * This method is used to get visitor information by content Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return List<VisitorsInfo>,list of informations
	 */

	@Override
	public List<VisitorsInfo> getVisitorsInfoByContentId(String parContetnId) {
		List<VisitorsInfo> visitorsInfo = visitorsInfoDao.getVisitorsInfoByContentId(parContetnId);
		return visitorsInfo;
	}

	/**
	 * This method is used to get visitor information by visitor Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List,list of visitor informations
	 */

	@Override
	public String getVisitorsInfoByVisitorId(String parVisitorId) {
		String visitorsInfo = visitorsInfoDao.getVisitorsInfoByVisitorId(parVisitorId);
		return visitorsInfo;

	}

	/**
	 * This method is used to get category name by visitor Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List,list of visitor informations
	 */
	@Override
	public List getCategoryNamesByVisitorId(String parVisitorId) {
		List categoryNameList = visitorsInfoDao.getCategoryNameByVisitorId(parVisitorId);
		return categoryNameList;
	}

	/**
	 * This method is used to get content Id by visitor Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List,list of content Id's
	 */
	@Override
	public List getContentIdByVisitorId(String parVisitorId) {
		List categoryNameList = visitorsInfoDao.getContentIdByVisitorId(parVisitorId);
		return categoryNameList;
	}

}
