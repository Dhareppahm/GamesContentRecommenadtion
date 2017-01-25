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

	@Override
	public void saveUserInfo(UserInfo parUserInfo) {
		mUserInfoDao.saveGameInfo(parUserInfo);

	}

	@Override
	public List<UserInfo> getVisitorHistoryByVisitorId(String parVisitorId) {
		List<UserInfo> mUserInfo = mUserInfoDao.getVisitorHistoryByVisitorId(parVisitorId);
		return mUserInfo;
	}

}
