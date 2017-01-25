/*
* @Author:Dhareppa Metri
* File:USerInfoDaoImpl.java
* Purpose:Implementation class for the interface UserInfoDao.
**/
package com.bridgelabz.contentRec.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.contentRec.dao.UserInfoDao;
import com.bridgelabz.contentRec.model.UserInfo;

@Repository
@Transactional
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	SessionFactory mSessionFactory;

	@Override
	public void saveGameInfo(UserInfo parUserInfo) {
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			lSess.save(parUserInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<UserInfo> getVisitorHistoryByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query qry = lSess.createQuery("from UserInfo where mUserId=:id");
		qry.setParameter("id", parVisitorId);
		List<UserInfo> lUserInfo = qry.list();
	/*	lUserInfo.get(1).get */
		return lUserInfo;

	}
}
