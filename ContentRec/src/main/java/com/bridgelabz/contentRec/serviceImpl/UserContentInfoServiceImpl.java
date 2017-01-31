package com.bridgelabz.contentRec.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgelabz.contentRec.dao.UserContentInfoDao;
import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.UserContentInfo;
import com.bridgelabz.contentRec.services.UserContentInfoService;

public class UserContentInfoServiceImpl implements UserContentInfoService {
	@Autowired
	UserContentInfoDao mUserContentInfoDao;

	@Override
	public UserContentInfo CatgeoryExists(String parVisitorId, String parCategoryName) {
		UserContentInfo lUserContentInfo = mUserContentInfoDao.CatgeoryExists(parVisitorId, parCategoryName);
		return lUserContentInfo;
	}

	@Override
	public void addNewCategory(String parVisitorId, String parCategoryName) {
		UserContentInfo lCategoryScore = new UserContentInfo();
		lCategoryScore.setmContentId("No content id");
		lCategoryScore.setmCategoryType("Category");
		lCategoryScore.setmVisitorId(parVisitorId);
		lCategoryScore.setmCategoryName(parCategoryName);
		lCategoryScore.setmFileSize("No file size");
		// lCategoryScore.setmFileSizeScore(mFileSizeScore);
		// lCategoryScore.setmCategoryScore(mCategoryScore);
		// lCategoryScore.setmSubCategoryTagScore(mSubCategoryTagScore);
		lCategoryScore.setmSubCategoryTagName("No sub tag");
		mUserContentInfoDao.addNewCategory(lCategoryScore);

	}

	@Override
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName) {
		int mStatus = mUserContentInfoDao.UpdateCategoryScore(parVisitorId, parCategoryName);
		return mStatus;
	}

	@Override
	public UserContentInfo SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName) {
		UserContentInfo lUserContentInfo = mUserContentInfoDao.SubCatgeoryTagExists(parVisitorId, parSubCategoryName);
		return lUserContentInfo;
	}

	@Override
	public void addNewSubCategoryTag(String parVisitorId, String parSubCategoryName,String parContentId) {
		UserContentInfo lSubCategoryScore = new UserContentInfo();
		lSubCategoryScore.setmContentId(parContentId);
		lSubCategoryScore.setmCategoryType("Tag");
		lSubCategoryScore.setmVisitorId(parVisitorId);
		lSubCategoryScore.setmSubCategoryTagName(parSubCategoryName);
		lSubCategoryScore.setmCategoryName("No category Name");
		// lSubCategoryScore.setmCategoryScore(0);
		lSubCategoryScore.setmFileSize("No file size");
		// lSubCategoryScore.setmFileSizeScore(mFileSizeScore);
		// lSubCategoryScore.setmSubCategoryTagScore(mSubCategoryTagScore);
		mUserContentInfoDao.addNewSubCategoryTag(lSubCategoryScore);
	}

	@Override
	public int UpdateSubCategoryTagScore(String parVisitorId, String parSubCategoryName) {
		int mStatus = mUserContentInfoDao.UpdateSubCategoryScoreTag(parVisitorId, parSubCategoryName);
		return mStatus;
	}

	@Override
	public UserContentInfo FileSizeExists(String parVisitorId, String parFileSize) {
		UserContentInfo lUserContentInfo = mUserContentInfoDao.FileSizeExists(parVisitorId, parFileSize);
		return lUserContentInfo;
	}

	@Override
	public void addNewFileSize(String parVisitorId, String parFileSize) {
		UserContentInfo lUserContentInfo = new UserContentInfo();
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
		mUserContentInfoDao.addNewFileSize(lUserContentInfo);

	}

	@Override
	public int UpdateFileSizeScore(String parVisitorId, String parFileSize) {
		int status = mUserContentInfoDao.UpdateFileSizeScore(parVisitorId, parFileSize);
		return status;
	}

	@Override
	public List gamesSubTagsRecommendationByVisitorId(String parVisitorId) {
		List lSubTagsList=mUserContentInfoDao.gamesSubTagsRecommendationByVisitorId(parVisitorId);
		return lSubTagsList;
	}

	@Override
	public List<UserContentInfo> getGamesSubTagsScore(String parVisitorId) {
		
		List<UserContentInfo> lSubTagsScore=mUserContentInfoDao.getGamesSubTagsScore(parVisitorId);
		return lSubTagsScore;
	}

	@Override
	public List<UserContentInfo> getGamesFileSizeScore(String parVisitorId) {
		List<UserContentInfo> lGamesFileSizeScore=mUserContentInfoDao.getGamesFileSizeScore(parVisitorId);
		return lGamesFileSizeScore;
	}

}
