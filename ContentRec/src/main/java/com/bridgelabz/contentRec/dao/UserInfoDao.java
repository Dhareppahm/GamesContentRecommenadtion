/*
* @Author:Dhareppa Metri
* File:UserInfoDao.java
* Purpose:DAO interface for user Information.
**/
package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.UserInfo;

public interface UserInfoDao {

	public void saveGameInfo(UserInfo parUserInfo);

	public List<UserInfo> getVisitorHistoryByVisitorId(String parVisitorId);
}
