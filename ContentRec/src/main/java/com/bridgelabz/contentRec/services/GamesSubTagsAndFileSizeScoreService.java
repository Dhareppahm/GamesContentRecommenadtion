package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.GamesSubTagsAndFileSizeScore;

public interface GamesSubTagsAndFileSizeScoreService {

	public GamesSubTagsAndFileSizeScore CatgeoryExists(String parVisitorId, String parCategoryName);

	public void addNewCategory(String parVisitorId, String parCategoryName);

	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	public GamesSubTagsAndFileSizeScore SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName);

	public void addNewSubCategoryTag(String parVisitorId, String parSubCategoryName,String parContentId);

	public int UpdateSubCategoryTagScore(String parVisitorId, String parSubCategoryName);

	public GamesSubTagsAndFileSizeScore FileSizeExists(String parVisitorId,String parFileSize);

	public void addNewFileSize(String parVisitorId, String parFileSize);

	public int UpdateFileSizeScore(String parVisitorId, String parFileSize);
	
	public List gamesSubTagsRecommendationByVisitorId(String parVisitorId);
	
	public List<GamesSubTagsAndFileSizeScore> getGamesSubTagsScore(String parVisitorId);
	
	public List<GamesSubTagsAndFileSizeScore> getGamesFileSizeScore(String parVisitorId);
	
}
