package com.bridgelabz.contentRec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.contentRec.dao.GamesSubTagsAndFileSizeScoreDao;
import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.GamesSubTagsAndFileSizeScore;
import com.bridgelabz.contentRec.services.GamesSubTagsAndFileSizeScoreService;

public class GamesSubTagsAndFileSizeScoreServiceImpl implements GamesSubTagsAndFileSizeScoreService {
	@Autowired
	GamesSubTagsAndFileSizeScoreDao mGamesSubTagsAndFileSizeScoreDao;

	/**
	 * This method is used to check the game category exists or not
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains category name
	 * @return GamesSubTagsAndFileSizeScore,GamesSubTagsAndFileSizeScore object
	 */
	@Override
	public GamesSubTagsAndFileSizeScore CatgeoryExists(String parVisitorId, String parCategoryName) {
		GamesSubTagsAndFileSizeScore lUserContentInfo = mGamesSubTagsAndFileSizeScoreDao.CatgeoryExists(parVisitorId,
				parCategoryName);
		return lUserContentInfo;
	}// End of CatgeoryExists method

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
		GamesSubTagsAndFileSizeScore lCategoryScore = new GamesSubTagsAndFileSizeScore();
		lCategoryScore.setmContentId("No content id");
		lCategoryScore.setmCategoryType("Category");
		lCategoryScore.setmVisitorId(parVisitorId);
		lCategoryScore.setmCategoryName(parCategoryName);
		lCategoryScore.setmFileSize("No file size");
		lCategoryScore.setmSubCategoryTagName("No sub tag");
		mGamesSubTagsAndFileSizeScoreDao.addNewCategory(lCategoryScore);

	}// End of addNewCategory method

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
		int mStatus = mGamesSubTagsAndFileSizeScoreDao.UpdateCategoryScore(parVisitorId, parCategoryName);
		return mStatus;
	}// End of UpdateCategoryScore method

	/**
	 * This method is used to check the game sub tag exists or not
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains sub tag name
	 * @return GamesSubTagsAndFileSizeScore,GamesSubTagsAndFileSizeScore object
	 */
	@Override
	public GamesSubTagsAndFileSizeScore SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName) {
		GamesSubTagsAndFileSizeScore lUserContentInfo = mGamesSubTagsAndFileSizeScoreDao
				.SubCatgeoryTagExists(parVisitorId, parSubCategoryName);
		return lUserContentInfo;
	}// End of SubCatgeoryTagExists method

	/**
	 * This method is used to add new game sub tag
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains sub tag name
	 * @param String,is
	 *            third parameter for this method contains content ID
	 */

	@Override
	public void addNewSubCategoryTag(String parVisitorId, String parSubCategoryName, String parContentId) {
		GamesSubTagsAndFileSizeScore lSubCategoryScore = new GamesSubTagsAndFileSizeScore();
		lSubCategoryScore.setmContentId(parContentId);
		lSubCategoryScore.setmCategoryType("Tag");
		lSubCategoryScore.setmVisitorId(parVisitorId);
		lSubCategoryScore.setmSubCategoryTagName(parSubCategoryName);
		lSubCategoryScore.setmCategoryName("No category Name");
		lSubCategoryScore.setmFileSize("No file size");
		mGamesSubTagsAndFileSizeScoreDao.addNewSubCategoryTag(lSubCategoryScore);
	}// End of addNewSubCategoryTag method

	/**
	 * This method is used to update the sub tag score
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains sub tag name
	 * @return Integer,status of the query
	 * 
	 */

	@Override
	public int UpdateSubCategoryTagScore(String parVisitorId, String parSubCategoryName) {
		int mStatus = mGamesSubTagsAndFileSizeScoreDao.UpdateSubCategoryScoreTag(parVisitorId, parSubCategoryName);
		return mStatus;
	}// End of UpdateSubCategoryTagScore method

	/**
	 * This method is used to check the game file size exists or not
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains file size
	 * @return GamesSubTagsAndFileSizeScore,GamesSubTagsAndFileSizeScore object
	 */

	@Override
	public GamesSubTagsAndFileSizeScore FileSizeExists(String parVisitorId, String parFileSize) {
		GamesSubTagsAndFileSizeScore lUserContentInfo = mGamesSubTagsAndFileSizeScoreDao.FileSizeExists(parVisitorId,
				parFileSize);
		return lUserContentInfo;
	}// End of FileSizeExists method

	/**
	 * This method is used to add new game file size
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains file size
	 */

	@Override
	public void addNewFileSize(String parVisitorId, String parFileSize) {
		GamesSubTagsAndFileSizeScore lUserContentInfo = new GamesSubTagsAndFileSizeScore();
		lUserContentInfo.setmCategoryName("No category");
		lUserContentInfo.setmCategoryType("File size");
		lUserContentInfo.setmVisitorId(parVisitorId);
		lUserContentInfo.setmFileSize(parFileSize);
		lUserContentInfo.setmSubCategoryTagName("No sub tag");
		lUserContentInfo.setmContentId("No content id");
		mGamesSubTagsAndFileSizeScoreDao.addNewFileSize(lUserContentInfo);

	}// End of addNewFileSize method

	/**
	 * This method is used to update the file size score
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains file size
	 * @return Integer,status of the query
	 * 
	 */

	@Override
	public int UpdateFileSizeScore(String parVisitorId, String parFileSize) {
		int status = mGamesSubTagsAndFileSizeScoreDao.UpdateFileSizeScore(parVisitorId, parFileSize);
		return status;
	}// End of UpdateFileSizeScore method

	/**
	 * This method is used to recommend the game sub tags by visitor ID
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @return List,list of sub tag names
	 * 
	 */

	@Override
	public List gamesSubTagsRecommendationByVisitorId(String parVisitorId) {
		List lSubTagsList = mGamesSubTagsAndFileSizeScoreDao.gamesSubTagsRecommendationByVisitorId(parVisitorId);
		return lSubTagsList;
	}// End of gamesSubTagsRecommendationByVisitorId method

	/**
	 * This method is used to get sub tags score by visitor ID
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @return List<GamesSubTagsAndFileSizeScore>,list of sub tags score
	 * 
	 */
	@Override
	public List<GamesSubTagsAndFileSizeScore> getGamesSubTagsScore(String parVisitorId) {
		List<GamesSubTagsAndFileSizeScore> lSubTagsScore = mGamesSubTagsAndFileSizeScoreDao
				.getGamesSubTagsScore(parVisitorId);
		return lSubTagsScore;
	}// End of getGamesSubTagsScore method

	/**
	 * This method is used to get file size score by visitor ID
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @return List<GamesSubTagsAndFileSizeScore>,list file size score
	 */
	@Override
	public List<GamesSubTagsAndFileSizeScore> getGamesFileSizeScore(String parVisitorId) {
		List<GamesSubTagsAndFileSizeScore> lGamesFileSizeScore = mGamesSubTagsAndFileSizeScoreDao
				.getGamesFileSizeScore(parVisitorId);
		return lGamesFileSizeScore;
	}// End of getGamesFileSizeScore method

}// End of GamesSubTagsAndFileSizeScoreServiceImpl class
