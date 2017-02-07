/*
* @Author:Dhareppa Metri
* File:GameCategoryScoreService.java
* Purpose:Service interface for game category score.
**/
package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.GameCategoryScore;

public interface GameCategoryScoreService {

	// This method is used to check category exists or not.
	public GameCategoryScore CatgeoryExists(String parVisitorId, String parCategoryName);

	// This method is used to add new game category name.
	public void addNewCategory(String parVisitorId, String parCategoryName);

	// This method is used to update category score.
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	// This method is used to recommend game names by visitor Id.
	public List<GameCategoryScore> gamesCategoryNameRecommendationByVisitorId(String parVisitorId);

	// This method is used to get category name by visitor Id.
	public List getCategoryNameByVisitorId(String parVisitorId);

}// End of GameCategoryScoreService class
