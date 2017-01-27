/*
* @Author:Dhareppa Metri
* File:GameCategoryScoreService.java
* Purpose:Service interface for game category score.
**/
package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.GameCategoryScore;

public interface GameCategoryScoreService {

	public GameCategoryScore CatgeoryExists(String parVisitorId, String parCategoryName);

	public void addNewCategory(String parVisitorId, String parCategoryName);

	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	public List<GameCategoryScore> gamesCategoryNameRecommendationByVisitorId(String parVisitorId);
	
	public List getCategoryNameByVisitorId(String parVisitorId);

}
