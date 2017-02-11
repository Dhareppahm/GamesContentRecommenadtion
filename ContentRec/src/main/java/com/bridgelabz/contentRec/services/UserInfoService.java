/*
* @Author:Dhareppa Metri
* File:UserInfoService.java
* Purpose:Service interface for user information.
**/
package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.UserInfo;

public interface UserInfoService {

	// This method is used to save game information.
	public void saveUserInfo(UserInfo parUserInfo);

	// This method is used to get visitor history.
	public List<UserInfo> getVisitorHistoryByVisitorId(String parVisitorId);

}// End of UserInfoService interface
