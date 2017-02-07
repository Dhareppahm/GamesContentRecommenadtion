/*
* @Author:Dhareppa Metri
* File:VisitorsInfoDaoImpl.java
* Purpose:Implementation class for the interface VisitorsInfoDao.
**/
package com.bridgelabz.contentRec.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bridgelabz.contentRec.dao.VisitorsInfoDao;
import com.bridgelabz.contentRec.model.VisitorsInfo;

@Repository
@Transactional
public class VisitorsInfoDaoImpl implements VisitorsInfoDao {
	@Autowired
	SessionFactory mSessionFactory;

	Logger mLogger = Logger.getLogger("VISITORSINFORMATIONDAOIMPL");

	/**
	 * This method is used to add visitor
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 */
	public void addVisitors(VisitorsInfo visitorsInfo) {

		Session lSess = mSessionFactory.getCurrentSession();
		try {
			lSess.save(visitorsInfo);
		} // End of try
		catch (Exception e) {
			e.printStackTrace();
		} // End of catch

	}// End of addVisitors method

	/**
	 * This method is used to get visitor information by content Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return List<VisitorsInfo>,list of informations
	 */
	@Override
	public List<VisitorsInfo> getVisitorsInfoByContentId(String parContentId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryToGetVisitorsInfoBycontentId = lSess.createQuery("from VisitorsInfo where mContentId=:id");
		lQueryToGetVisitorsInfoBycontentId.setParameter("id", parContentId);
		List<VisitorsInfo> lVisitorsInfo = lQueryToGetVisitorsInfoBycontentId.list();
		return lVisitorsInfo;

	}// End of getVisitorsInfoByContentId method

	/**
	 * This method is used to get visitor information by visitor Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List,list of visitor informations
	 */
	@Override
	public String getVisitorsInfoByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryToGetVisitorsInfoByVisitorId = lSess
				.createQuery("select mCategoryName from VisitorsInfo where mContentId=:id");
		lQueryToGetVisitorsInfoByVisitorId.setParameter("id", parVisitorId);
		String lVisitorsInfo = lQueryToGetVisitorsInfoByVisitorId.uniqueResult().toString();
		return lVisitorsInfo;
	}// End of getVisitorsInfoByVisitorId method

	/**
	 * This method is used to get category name by visitor Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List,list of visitor informations
	 */
	@Override
	public List getCategoryNameByVisitorId(String parVisitorId) {

		Session lSess = mSessionFactory.getCurrentSession();
		Query qry = lSess.createQuery("select mCategoryName from VisitorsInfo where mVisitorId=:id");
		qry.setParameter("id", parVisitorId);
		List lCategoryNameList = qry.list();
		return lCategoryNameList;

	}// End of getCategoryNameByVisitorId

	/**
	 * This method is used to get content Id by visitor Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List,list of content Id's
	 */
	@Override
	public List getContentIdByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query qry = lSess.createQuery("select mContentId from VisitorsInfo where mVisitorId=:id");
		qry.setParameter("id", parVisitorId);
		List lCategoryNameList = qry.list();
		return lCategoryNameList;
	}// End ofgetContentIdByVisitorId method

}// End of VisitorsInfoDaoImpl class
