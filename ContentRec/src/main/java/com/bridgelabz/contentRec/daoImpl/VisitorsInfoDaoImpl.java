/*
* @Author:Dhareppa Metri
* File:VisitorsInfoDaoImpl.java
* Purpose:Implementation class for the interface VisitorsInfoDao.
**/
package com.bridgelabz.contentRec.daoImpl;

import java.util.List;

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

	public void addVisitors(VisitorsInfo visitorsInfo) {

		Session lSess = mSessionFactory.getCurrentSession();
		try {
			lSess.save(visitorsInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<VisitorsInfo> getVisitorsInfoByContentId(String parContentId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryToGetVisitorsInfoBycontentId = lSess.createQuery("from VisitorsInfo where mContentId=:id");
		lQueryToGetVisitorsInfoBycontentId.setParameter("id", parContentId);
		List<VisitorsInfo> lVisitorsInfo = lQueryToGetVisitorsInfoBycontentId.list();
		return lVisitorsInfo;

	}

	@Override
	public String getVisitorsInfoByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryToGetVisitorsInfoByVisitorId = lSess.createQuery("select mCategoryName from VisitorsInfo where mContentId=:id");
		lQueryToGetVisitorsInfoByVisitorId.setParameter("id", parVisitorId);
		String lVisitorsInfo = lQueryToGetVisitorsInfoByVisitorId.uniqueResult().toString();
		return lVisitorsInfo;
	}

	@Override
	public List getCategoryNameByVisitorId(String parVisitorId) {

		Session lSess = mSessionFactory.getCurrentSession();
		Query qry = lSess.createQuery("select mCategoryName from VisitorsInfo where mVisitorId=:id");
		qry.setParameter("id", parVisitorId);
		List lCategoryNameList = qry.list();
		return lCategoryNameList;

	}

}
