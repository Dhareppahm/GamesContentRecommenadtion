/*
* @Author:Dhareppa Metri
* File:GameCategoryScoreDao.java
* Purpose:DAO interface for game category score.
**/
package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.GameCategoryScore;

public interface GameCategoryScoreDao {

	public GameCategoryScore CatgeoryExists(String parVisitorId, String parCategoryName);

	public void addNewCategory(GameCategoryScore mGameCategoryScore);

	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	public List<GameCategoryScore> gamesCategoryNamesRecommendationByVisitorId(String parVisitorId);

	public List getCategoryNameByVisitorId(String parVisitorId);
	
}
