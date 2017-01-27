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
		lCategoryScore.setmCategoryType("Category");
		lCategoryScore.setmVisitorId(parVisitorId);
		lCategoryScore.setmCategoryName(parCategoryName);
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
	public void addNewSubCategoryTag(String parVisitorId, String parSubCategoryName) {
		UserContentInfo lSubCategoryScore = new UserContentInfo();
		lSubCategoryScore.setmCategoryType("Tag");
		lSubCategoryScore.setmVisitorId(parVisitorId);
		lSubCategoryScore.setmSubCategoryTagName(parSubCategoryName);
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
		lUserContentInfo.setmVisitorId(parVisitorId);
		lUserContentInfo.setmFileSize(parFileSize);
		mUserContentInfoDao.addNewFileSize(lUserContentInfo);

	}

	@Override
	public int UpdateFileSizeScore(String parVisitorId, String parFileSize) {
		int status = mUserContentInfoDao.UpdateFileSizeScore(parVisitorId, parFileSize);
		return status;
	}

	@Override
	public List<GameCategoryScore> gamesSubTagsRecommendationByVisitorId(String parVisitorId) {
	
		return null;
	}
}
