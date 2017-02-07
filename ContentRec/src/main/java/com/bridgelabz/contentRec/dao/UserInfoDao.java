/*
* @Author:Dhareppa Metri
* File:UserInfoDao.java
* Purpose:DAO interface for user Information.
**/
package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.UserInfo;

public interface UserInfoDao {

	// This method is used to save game information.
	public void saveGameInfo(UserInfo parUserInfo);

	// This method is used to get visitor history.
	public List<UserInfo> getVisitorHistoryByVisitorId(String parVisitorId);
	
}// End of UserInfoDao interface
