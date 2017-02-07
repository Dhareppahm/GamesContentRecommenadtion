/*
* @Author:Dhareppa Metri
* File:USerInfoDaoImpl.java
* Purpose:Implementation class for the interface UserInfoDao.
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

import com.bridgelabz.contentRec.dao.UserInfoDao;
import com.bridgelabz.contentRec.model.UserInfo;

@Repository
@Transactional
public class UserInfoDaoImpl implements UserInfoDao {
	@Autowired
	SessionFactory mSessionFactory;

	Logger mLogger = Logger.getLogger("USERINFORMATIONDAOIMPL");

	/**
	 * This method is used to save visitor information
	 * 
	 * @param UserInfo,
	 *            is the first parameter for this method contains visitor
	 *            information
	 */
	@Override
	public void saveGameInfo(UserInfo parUserInfo) {
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			lSess.save(parUserInfo);
		} // End of try
		catch (Exception e) {
			e.printStackTrace();
		} // End of catch

	}// End of saveGameInfo method

	/**
	 * This method is used to get visitor history
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List<UserInfo>,list of user informations
	 */
	@Override
	public List<UserInfo> getVisitorHistoryByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query qry = lSess.createQuery("from UserInfo where mUserId=:id");
		qry.setParameter("id", parVisitorId);
		List<UserInfo> lUserInfo = qry.list();
		return lUserInfo;

	}// End of getVisitorHistoryByVisitorId method
}// End of UserInfoDaoImpl class
