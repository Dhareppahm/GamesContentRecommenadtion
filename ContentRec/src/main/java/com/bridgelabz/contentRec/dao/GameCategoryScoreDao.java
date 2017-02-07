/*
* @Author:Dhareppa Metri
* File:GameCategoryScoreDao.java
* Purpose:DAO interface for game category score.
**/
package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.GameCategoryScore;

public interface GameCategoryScoreDao {

	// This method is used to check category exists or not.
	public GameCategoryScore CatgeoryExists(String parVisitorId, String parCategoryName);

	// This method is used to add new game category name.
	public void addNewCategory(GameCategoryScore mGameCategoryScore);

	// This method is used to update category score.
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	// This method is used to recommend game names by visitor Id.
	public List<GameCategoryScore> gamesCategoryNamesRecommendationByVisitorId(String parVisitorId);

	// This method is used to get category name by visitor Id.
	public List getCategoryNameByVisitorId(String parVisitorId);

}// End of GameCategoryScoreDao interface
