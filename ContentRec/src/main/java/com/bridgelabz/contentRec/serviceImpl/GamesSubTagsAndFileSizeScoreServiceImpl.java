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

	@Override
	public GamesSubTagsAndFileSizeScore CatgeoryExists(String parVisitorId, String parCategoryName) {
		GamesSubTagsAndFileSizeScore lUserContentInfo = mGamesSubTagsAndFileSizeScoreDao.CatgeoryExists(parVisitorId, parCategoryName);
		return lUserContentInfo;
	}

	@Override
	public void addNewCategory(String parVisitorId, String parCategoryName) {
		GamesSubTagsAndFileSizeScore lCategoryScore = new GamesSubTagsAndFileSizeScore();
		lCategoryScore.setmContentId("No content id");
		lCategoryScore.setmCategoryType("Category");
		lCategoryScore.setmVisitorId(parVisitorId);
		lCategoryScore.setmCategoryName(parCategoryName);
		lCategoryScore.setmFileSize("No file size");
		// lCategoryScore.setmFileSizeScore(mFileSizeScore);
		// lCategoryScore.setmCategoryScore(mCategoryScore);
		// lCategoryScore.setmSubCategoryTagScore(mSubCategoryTagScore);
		lCategoryScore.setmSubCategoryTagName("No sub tag");
		mGamesSubTagsAndFileSizeScoreDao.addNewCategory(lCategoryScore);

	}

	@Override
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName) {
		int mStatus = mGamesSubTagsAndFileSizeScoreDao.UpdateCategoryScore(parVisitorId, parCategoryName);
		return mStatus;
	}

	@Override
	public GamesSubTagsAndFileSizeScore SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName) {
		GamesSubTagsAndFileSizeScore lUserContentInfo = mGamesSubTagsAndFileSizeScoreDao.SubCatgeoryTagExists(parVisitorId, parSubCategoryName);
		return lUserContentInfo;
	}

	@Override
	public void addNewSubCategoryTag(String parVisitorId, String parSubCategoryName,String parContentId) {
		GamesSubTagsAndFileSizeScore lSubCategoryScore = new GamesSubTagsAndFileSizeScore();
		lSubCategoryScore.setmContentId(parContentId);
		lSubCategoryScore.setmCategoryType("Tag");
		lSubCategoryScore.setmVisitorId(parVisitorId);
		lSubCategoryScore.setmSubCategoryTagName(parSubCategoryName);
		lSubCategoryScore.setmCategoryName("No category Name");
		// lSubCategoryScore.setmCategoryScore(0);
		lSubCategoryScore.setmFileSize("No file size");
		// lSubCategoryScore.setmFileSizeScore(mFileSizeScore);
		// lSubCategoryScore.setmSubCategoryTagScore(mSubCategoryTagScore);
		mGamesSubTagsAndFileSizeScoreDao.addNewSubCategoryTag(lSubCategoryScore);
	}

	@Override
	public int UpdateSubCategoryTagScore(String parVisitorId, String parSubCategoryName) {
		int mStatus = mGamesSubTagsAndFileSizeScoreDao.UpdateSubCategoryScoreTag(parVisitorId, parSubCategoryName);
		return mStatus;
	}

	@Override
	public GamesSubTagsAndFileSizeScore FileSizeExists(String parVisitorId, String parFileSize) {
		GamesSubTagsAndFileSizeScore lUserContentInfo = mGamesSubTagsAndFileSizeScoreDao.FileSizeExists(parVisitorId, parFileSize);
		return lUserContentInfo;
	}

	@Override
	public void addNewFileSize(String parVisitorId, String parFileSize) {
		GamesSubTagsAndFileSizeScore lUserContentInfo = new GamesSubTagsAndFileSizeScore();
		lUserContentInfo.setmCategoryName("No category");
		lUserContentInfo.setmCategoryType("File size");
		// lUserContentInfo.setmCategoryScore(mCategoryScore);
		// lUserContentInfo.setmFileSizeScore(mFileSizeScore);
		// lUserContentInfo.setmSubCategoryTagScore(mSubCategoryTagScore);
		lUserContentInfo.setmVisitorId(parVisitorId);
		lUserContentInfo.setmFileSize(parFileSize);
		// lUserContentInfo.setmCategoryScore(mCategoryScore);
		lUserContentInfo.setmSubCategoryTagName("No sub tag");
		lUserContentInfo.setmContentId("No content id");
		mGamesSubTagsAndFileSizeScoreDao.addNewFileSize(lUserContentInfo);

	}

	@Override
	public int UpdateFileSizeScore(String parVisitorId, String parFileSize) {
		int status = mGamesSubTagsAndFileSizeScoreDao.UpdateFileSizeScore(parVisitorId, parFileSize);
		return status;
	}

	@Override
	public List gamesSubTagsRecommendationByVisitorId(String parVisitorId) {
		List lSubTagsList=mGamesSubTagsAndFileSizeScoreDao.gamesSubTagsRecommendationByVisitorId(parVisitorId);
		return lSubTagsList;
	}

	@Override
	public List<GamesSubTagsAndFileSizeScore> getGamesSubTagsScore(String parVisitorId) {
		
		List<GamesSubTagsAndFileSizeScore> lSubTagsScore=mGamesSubTagsAndFileSizeScoreDao.getGamesSubTagsScore(parVisitorId);
		return lSubTagsScore;
	}

	@Override
	public List<GamesSubTagsAndFileSizeScore> getGamesFileSizeScore(String parVisitorId) {
		List<GamesSubTagsAndFileSizeScore> lGamesFileSizeScore=mGamesSubTagsAndFileSizeScoreDao.getGamesFileSizeScore(parVisitorId);
		return lGamesFileSizeScore;
	}

}
