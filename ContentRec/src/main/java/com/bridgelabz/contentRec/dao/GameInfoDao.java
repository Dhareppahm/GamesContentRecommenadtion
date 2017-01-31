/*
* @Author:Dhareppa Metri
* File:GameInfoDao.java
* Purpose:DAO interface for game Information.
**/
package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.GameInfo;

public interface GameInfoDao {
	public void saveGameInfo(GameInfo gameInfo);

	public List<GameInfo> getGameInfoByContentId(String parContentId);
	
	public List<GameInfo> getGameNameByGameCategory(String parVisitorId);

	public String getSubCategoryTagsByContentId(String parContentId);
	
	public String getFileSizeByContentId(String parContentId);
	
	public  List<GameInfo> getGameNameBySubTags(String parSubTag);

	public List<GameInfo> getGameNameByFileSize(String parVisitorId);


}
