package com.bridgelabz.contentRec.dao;

import java.util.List;

import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.UserContentInfo;

public interface UserContentInfoDao {
	public UserContentInfo CatgeoryExists(String parVisitorId, String parCategoryName);

	public void addNewCategory(UserContentInfo parUserContentInfo);

	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	public UserContentInfo SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName);

	public void addNewSubCategoryTag(UserContentInfo parUserContentInfo);

	public int UpdateSubCategoryScoreTag(String parVisitorId, String parSubCategoryName);

	public UserContentInfo FileSizeExists(String parVisitorId, String parFileSize);

	public void addNewFileSize(UserContentInfo parUserContentInfo);

	public int UpdateFileSizeScore(String parVisitorId, String parFileSize);

	public List gamesSubTagsRecommendationByVisitorId(String parVisitorId);
	
	public List<UserContentInfo> getGamesSubTagsScore(String parVisitorId);
	
	public List<UserContentInfo> getGamesFileSizeScore(String parVisitorId);
}
