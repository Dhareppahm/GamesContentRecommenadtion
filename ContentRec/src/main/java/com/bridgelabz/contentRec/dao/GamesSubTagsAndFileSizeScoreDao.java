package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.GamesSubTagsAndFileSizeScore;

public interface GamesSubTagsAndFileSizeScoreDao {
	public GamesSubTagsAndFileSizeScore CatgeoryExists(String parVisitorId, String parCategoryName);

	public void addNewCategory(GamesSubTagsAndFileSizeScore parUserContentInfo);

	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	public GamesSubTagsAndFileSizeScore SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName);

	public void addNewSubCategoryTag(GamesSubTagsAndFileSizeScore parUserContentInfo);

	public int UpdateSubCategoryScoreTag(String parVisitorId, String parSubCategoryName);

	public GamesSubTagsAndFileSizeScore FileSizeExists(String parVisitorId, String parFileSize);

	public void addNewFileSize(GamesSubTagsAndFileSizeScore parUserContentInfo);

	public int UpdateFileSizeScore(String parVisitorId, String parFileSize);

	public List gamesSubTagsRecommendationByVisitorId(String parVisitorId);
	
	public List<GamesSubTagsAndFileSizeScore> getGamesSubTagsScore(String parVisitorId);
	
	public List<GamesSubTagsAndFileSizeScore> getGamesFileSizeScore(String parVisitorId);
}
