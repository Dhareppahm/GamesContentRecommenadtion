/*
* @Author:Dhareppa Metri
* File:UserInfoService.java
* Purpose:Service interface for user information.
**/
package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.UserInfo;

public interface UserInfoService {

	public void saveUserInfo(UserInfo parUserInfo);

	public List<UserInfo> getVisitorHistoryByVisitorId(String parVisitorId);
	

}
