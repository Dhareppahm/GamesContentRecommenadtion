/*
* @Author:Dhareppa Metri
* File:GameInfoServiceImpl.java
* Purpose:Implementation class for the interface GameInfoService.
**/
package com.bridgelabz.contentRec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.contentRec.dao.GameInfoDao;
import com.bridgelabz.contentRec.model.GameInfo;
import com.bridgelabz.contentRec.services.GameInfoService;

public class GameInfoServiceImpl implements GameInfoService {
	@Autowired
	GameInfoDao mGameInfoDao;

	/**
	 * This method is used to save game information
	 * 
	 * @param GameInfo,is
	 *            the first parameter for this method contains game information
	 */
	@Override
	public void saveGameInfo(GameInfo parGameInfo) {
		mGameInfoDao.saveGameInfo(parGameInfo);

	}

	/**
	 * This method is used to get game information by content Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return List<GameInfo>,list game information
	 */

	@Override
	public List<GameInfo> getGameInfoByContentId(String parContentId) {
		List<GameInfo> lGameInfo = mGameInfoDao.getGameInfoByContentId(parContentId);
		return lGameInfo;
	}

	/**
	 * This method is used to get game name by category name
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List<GameInfo>,list game information
	 */

	@Override
	public List<GameInfo> getGameNameByGameCategory(String parVisitorId) {
		List<GameInfo> lGameInfo = mGameInfoDao.getGameNameByGameCategory(parVisitorId);
		return lGameInfo;
	}

	/**
	 * This method is used to get sub tags by content Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return String,sub tag name
	 */

	@Override
	public String getSubCategoryTagsByContentId(String parContentId) {
		String lSubCategoryTags = mGameInfoDao.getSubCategoryTagsByContentId(parContentId);
		return lSubCategoryTags;
	}

	/**
	 * This method is used to get file size by content Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return String,file size
	 */
	@Override
	public String getFileSizeByContentId(String parContentId) {
		String lFileSize = mGameInfoDao.getFileSizeByContentId(parContentId);
		return lFileSize;
	}

	/**
	 * This method is used to get game name by sub tag
	 * 
	 * @param String,
	 *            is the first parameter for this method contains sub tag name
	 * @return List<GameInfo>,list of game names
	 */

	@Override
	public List<GameInfo> getGameNameBySubTags(String parSubTag) {
		List<GameInfo> lGameNameList = mGameInfoDao.getGameNameBySubTags(parSubTag);
		return lGameNameList;
	}

	/**
	 * This method is used to get game name by file size
	 * 
	 * @param String,
	 *            is the first parameter for this method contains file size
	 * @return List<GameInfo>,list of game names
	 */

	@Override
	public List<GameInfo> getGameNameByFileSize(String parVisitorId) {
		List<GameInfo> lGameNames = mGameInfoDao.getGameNameByFileSize(parVisitorId);
		return lGameNames;
	}

}
