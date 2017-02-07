/*
* @Author:Dhareppa Metri
* File:GameInfoService.java
* Purpose:Service interface for game information.
**/
package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.GameInfo;

public interface GameInfoService {

	// This method is used save game information.
	public void saveGameInfo(GameInfo gameInfo);

	// This method is used to get game information by content Id.
	public List<GameInfo> getGameInfoByContentId(String parContentId);

	// This method is used to get game names by game category name.
	public List<GameInfo> getGameNameByGameCategory(String parVisitorId);

	// This method is used to get game sub tags by content Id.
	public String getSubCategoryTagsByContentId(String parContentId);

	// This method is used to get game file size by content Id.
	public String getFileSizeByContentId(String parContentId);

	// This method is used to get game names by sub tags.
	public List<GameInfo> getGameNameBySubTags(String parSubTag);

	// This method is used to get game names by visitor Id.
	public List<GameInfo> getGameNameByFileSize(String parVisitorId);

}
