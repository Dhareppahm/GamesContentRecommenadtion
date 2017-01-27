/*
* @Author:Dhareppa Metri
* File:GameCategoryScoreServiceImpl.java
* Purpose:Implementation class for the interface GameCategoryScoreService.
**/
package com.bridgelabz.contentRec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.contentRec.dao.GameCategoryScoreDao;
import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.services.GameCategoryScoreService;

public class GameCategoryScoreServiceImpl implements GameCategoryScoreService {
	@Autowired
	GameCategoryScoreDao mGameCategoryScoreDao;

	@Override
	public GameCategoryScore CatgeoryExists(String parVisitorId, String parCategoryName) {
		GameCategoryScore lCategoryScore = mGameCategoryScoreDao.CatgeoryExists(parVisitorId, parCategoryName);
		return lCategoryScore;
	}

	@Override
	public void addNewCategory(String parVisitorId, String parCategoryName) {
		GameCategoryScore lCategoryScore = new GameCategoryScore();
		lCategoryScore.setmVisitorId(parVisitorId);
		lCategoryScore.setmCategoryName(parCategoryName);
		mGameCategoryScoreDao.addNewCategory(lCategoryScore);

	}

	@Override
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName) {
		int mStatus = mGameCategoryScoreDao.UpdateCategoryScore(parVisitorId, parCategoryName);
		return mStatus;
	}

	@Override
	public List<GameCategoryScore> gamesCategoryNameRecommendationByVisitorId(String parVisitorId) {
		List<GameCategoryScore> mGameCategoryScore = mGameCategoryScoreDao
				.gamesCategoryNamesRecommendationByVisitorId(parVisitorId);
		return mGameCategoryScore;
	}

	@Override
	public List getCategoryNameByVisitorId(String parVisitorId) {
		List mCategoryNameList = mGameCategoryScoreDao.getCategoryNameByVisitorId(parVisitorId);
		return mCategoryNameList;
	}

}
