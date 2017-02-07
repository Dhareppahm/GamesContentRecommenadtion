/*
* @Author:Dhareppa Metri
* File:UserInfoServiceImpl.java
* Purpose:Implementation class for the interface UserInfoService.
**/
package com.bridgelabz.contentRec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.contentRec.dao.UserInfoDao;
import com.bridgelabz.contentRec.model.UserInfo;
import com.bridgelabz.contentRec.services.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoDao mUserInfoDao;

	/**
	 * This method is used to save visitor information
	 * 
	 * @param UserInfo,
	 *            is the first parameter for this method contains visitor
	 *            information
	 */
	@Override
	public void saveUserInfo(UserInfo parUserInfo) {
		mUserInfoDao.saveGameInfo(parUserInfo);

	}

	/**
	 * This method is used to get visitor history
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List<UserInfo>,list of user informations
	 */

	@Override
	public List<UserInfo> getVisitorHistoryByVisitorId(String parVisitorId) {
		List<UserInfo> mUserInfo = mUserInfoDao.getVisitorHistoryByVisitorId(parVisitorId);
		return mUserInfo;
	}

}
