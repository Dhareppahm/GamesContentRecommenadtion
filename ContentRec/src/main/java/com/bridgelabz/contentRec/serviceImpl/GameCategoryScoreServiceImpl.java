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

	/**
	 * This method is used to check the game category exists or not
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains category name
	 * @return GameCategoryScore,GameCategoryScore object
	 */
	@Override
	public GameCategoryScore CatgeoryExists(String parVisitorId, String parCategoryName) {
		GameCategoryScore lCategoryScore = mGameCategoryScoreDao.CatgeoryExists(parVisitorId, parCategoryName);
		return lCategoryScore;
	}

	/**
	 * This method is used to add new game category
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains category name
	 */
	@Override
	public void addNewCategory(String parVisitorId, String parCategoryName) {
		GameCategoryScore lCategoryScore = new GameCategoryScore();
		lCategoryScore.setmVisitorId(parVisitorId);
		lCategoryScore.setmCategoryName(parCategoryName);
		mGameCategoryScoreDao.addNewCategory(lCategoryScore);

	}

	/**
	 * This method is used to add update the game category score
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains category name
	 * @return Integer,status of the query
	 */

	@Override
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName) {
		int mStatus = mGameCategoryScoreDao.UpdateCategoryScore(parVisitorId, parCategoryName);
		return mStatus;
	}

	/**
	 * This method is used to recommend game category name to visitor by
	 * visitorId
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @return List<GameCategoryScore>,list game category names
	 */
	@Override
	public List<GameCategoryScore> gamesCategoryNameRecommendationByVisitorId(String parVisitorId) {
		List<GameCategoryScore> mGameCategoryScore = mGameCategoryScoreDao
				.gamesCategoryNamesRecommendationByVisitorId(parVisitorId);
		return mGameCategoryScore;
	}

	/**
	 * This method is used to get game category name byvisitorId
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @return List<GameCategoryScore>,list game category names
	 */
	@Override
	public List getCategoryNameByVisitorId(String parVisitorId) {
		List mCategoryNameList = mGameCategoryScoreDao.getCategoryNameByVisitorId(parVisitorId);
		return mCategoryNameList;
	}

}
