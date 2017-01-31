/*
* @Author:Dhareppa Metri
* File:GameInfoService.java
* Purpose:Service interface for game information.
**/
package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.GameInfo;

public interface GameInfoService {
	public void saveGameInfo(GameInfo gameInfo);

	public List<GameInfo> dispalyGameInfoByContentId(String parContentId);

	public List<GameInfo> getGameInfoByContentId(String parContentId);
	
	public List<GameInfo> getGameNameByGameCategory(String parVisitorId);
	
	public String getSubCategoryTagsByContentId(String parContentId);
	
	public String getFileSizeByContentId(String parContentId);
	
	public List<GameInfo> getGameNameBySubTags(String parSubTag);
	
	
	public List<GameInfo> getGameNameByFileSize(String parVisitorId);
	
}
