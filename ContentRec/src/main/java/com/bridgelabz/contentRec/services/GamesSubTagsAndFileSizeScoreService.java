package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.GamesSubTagsAndFileSizeScore;

public interface GamesSubTagsAndFileSizeScoreService {

	// This method is used to check game category exists or not.
	public GamesSubTagsAndFileSizeScore CatgeoryExists(String parVisitorId, String parCategoryName);

	// This method is used to add new game category.
	public void addNewCategory(String parVisitorId, String parCategoryName);

	// This method is used to update the game category score.
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	// This method is used to check sub tag exists or not.
	public GamesSubTagsAndFileSizeScore SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName);

	// This method is used to add new sub tag.
	public void addNewSubCategoryTag(String parVisitorId, String parSubCategoryName, String parContentId);

	// This method is used to update sub tags score.
	public int UpdateSubCategoryTagScore(String parVisitorId, String parSubCategoryName);

	// This method is used to check file size exists or not.
	public GamesSubTagsAndFileSizeScore FileSizeExists(String parVisitorId, String parFileSize);

	// This method is used to add new file size score.
	public void addNewFileSize(String parVisitorId, String parFileSize);

	// This method is used to update the file size score.
	public int UpdateFileSizeScore(String parVisitorId, String parFileSize);

	// This method is used to recommend sub tags by visitor Id.
	public List gamesSubTagsRecommendationByVisitorId(String parVisitorId);

	// This method is used to get sub tags score.
	public List<GamesSubTagsAndFileSizeScore> getGamesSubTagsScore(String parVisitorId);

	// This method is used to recommend file size score by visitor Id.
	public List<GamesSubTagsAndFileSizeScore> getGamesFileSizeScore(String parVisitorId);

}// End of GamesSubTagsAndFileSizeScoreService interface
