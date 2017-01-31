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

	@Override
	public void saveGameInfo(GameInfo parGameInfo) {
		mGameInfoDao.saveGameInfo(parGameInfo);

	}

	@Override
	public List<GameInfo> dispalyGameInfoByContentId(String parContentId) {
		List<GameInfo> lGameInfo = mGameInfoDao.dispalyGameInfoByContentId(parContentId);
		return lGameInfo;
	}

	@Override
	public List<GameInfo> getGameInfoByContentId(String parContentId) {
		List<GameInfo> lGameInfo = mGameInfoDao.getGameInfoByContentId(parContentId);
		return lGameInfo;
	}

	@Override
	public List<GameInfo> getGameNameByGameCategory(String parVisitorId) {
		List<GameInfo> lGameInfo = mGameInfoDao.getGameNameByGameCategory(parVisitorId);
		return lGameInfo;
	}

	@Override
	public String getSubCategoryTagsByContentId(String parContentId) {
		String lSubCategoryTags=mGameInfoDao.getSubCategoryTagsByContentId(parContentId);
		return lSubCategoryTags;
	}

	@Override
	public String getFileSizeByContentId(String parContentId) {
		String lFileSize=mGameInfoDao.getFileSizeByContentId(parContentId);
		return lFileSize;
	}

	@Override
	public List<GameInfo> getGameNameBySubTags(String parSubTag) {
		 List<GameInfo> lGameNameList=mGameInfoDao.getGameNameBySubTags(parSubTag);
		return lGameNameList;
	}

	@Override
	public List<GameInfo> getGameNameByFileSize(String parVisitorId) {
		List<GameInfo> lGameNames=mGameInfoDao.getGameNameByFileSize(parVisitorId);
		
		return lGameNames;
	}

}
