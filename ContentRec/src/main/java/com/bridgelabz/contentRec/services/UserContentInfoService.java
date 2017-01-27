package com.bridgelabz.contentRec.services;

import java.util.List;

import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.UserContentInfo;

public interface UserContentInfoService {

	public UserContentInfo CatgeoryExists(String parVisitorId, String parCategoryName);

	public void addNewCategory(String parVisitorId, String parCategoryName);

	public int UpdateCategoryScore(String parVisitorId, String parCategoryName);

	public UserContentInfo SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName);

	public void addNewSubCategoryTag(String parVisitorId, String parSubCategoryName);

	public int UpdateSubCategoryTagScore(String parVisitorId, String parSubCategoryName);

	public UserContentInfo FileSizeExists(String parVisitorId,String parFileSize);

	public void addNewFileSize(String parVisitorId, String parFileSize);

	public int UpdateFileSizeScore(String parVisitorId, String parFileSize);
	
	public List<GameCategoryScore> gamesSubTagsRecommendationByVisitorId(String parVisitorId);
}
