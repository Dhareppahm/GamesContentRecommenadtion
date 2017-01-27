package com.bridgelabz.contentRec.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.contentRec.dao.UserContentInfoDao;
import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.UserContentInfo;
@Repository
@Transactional
public class UserContentInfoDaoImpl implements UserContentInfoDao {
	@Autowired
	SessionFactory mSessionFactory;

	@Override
	public UserContentInfo CatgeoryExists(String parVisitorId, String parCategoryName) {

		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(UserContentInfo.class);

			UserContentInfo lCategoryScore = (UserContentInfo) lCriteria
					.add(Restrictions.conjunction().add(Restrictions.eq("mVisitorId", parVisitorId))
							.add(Restrictions.eq("mCategoryName", parCategoryName)))
					.uniqueResult();
			return lCategoryScore;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNewCategory(UserContentInfo parUserInfoContent) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parUserInfoContent);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryForToGetCategoryScore = lSess.createQuery(
				"SELECT mCategoryScore FROM UserContentInfo WHERE mVisitorId=:id and mCategoryName=:CatName");
		lQueryForToGetCategoryScore.setParameter("id", parVisitorId);
		lQueryForToGetCategoryScore.setParameter("CatName", parCategoryName);
		long categoryScore = (long) lQueryForToGetCategoryScore.uniqueResult();
		categoryScore = categoryScore + 1;

		Query lQueryForToUpdateCategoryScore = lSess.createQuery(
				"UPDATE UserContentInfo SET mCategoryScore=:score WHERE mVisitorId=:id and mCategoryName=:CatName");
		lQueryForToUpdateCategoryScore.setParameter("score", categoryScore);
		lQueryForToUpdateCategoryScore.setParameter("id", parVisitorId);
		lQueryForToUpdateCategoryScore.setParameter("CatName", parCategoryName);
		int lStatus = lQueryForToUpdateCategoryScore.executeUpdate();
		return lStatus;
	}

	@Override
	public UserContentInfo SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(UserContentInfo.class);

			UserContentInfo lCategoryScore = (UserContentInfo) lCriteria
					.add(Restrictions.conjunction().add(Restrictions.eq("mVisitorId", parVisitorId))
							.add(Restrictions.eq("mSubCategoryTagName", parSubCategoryName)))
					.uniqueResult();
			return lCategoryScore;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNewSubCategoryTag(UserContentInfo parUserInfoContent) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parUserInfoContent);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int UpdateSubCategoryScoreTag(String parVisitorId, String parSubCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryForToGetSubCategoryTagScore = lSess.createQuery(
				"SELECT mSubCategoryTagScore FROM UserContentInfo WHERE mVisitorId=:id and mSubCategoryTagName=:SubCategoryTagName");
		lQueryForToGetSubCategoryTagScore.setParameter("id", parVisitorId);
		lQueryForToGetSubCategoryTagScore.setParameter("SubCategoryTagName", parSubCategoryName);
		long subCategoryTagScore = (long) lQueryForToGetSubCategoryTagScore.uniqueResult();
		subCategoryTagScore = subCategoryTagScore + 1;

		Query lQueryForToUpdateSubCategoryTagScore = lSess.createQuery(
				"UPDATE UserContentInfo SET mSubCategoryTagScore=:score WHERE mVisitorId=:id and mSubCategoryTagName=:SubCategoryTagName");
		lQueryForToUpdateSubCategoryTagScore.setParameter("score", subCategoryTagScore);
		lQueryForToUpdateSubCategoryTagScore.setParameter("id", parVisitorId);
		lQueryForToUpdateSubCategoryTagScore.setParameter("SubCategoryTagName", parSubCategoryName);
		int lStatus = lQueryForToUpdateSubCategoryTagScore.executeUpdate();
		return lStatus;
	}

	@Override
	public UserContentInfo FileSizeExists(String parVisitorId, String parFileSize) {
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(UserContentInfo.class);

			UserContentInfo lFileSize = (UserContentInfo) lCriteria
					.add(Restrictions.conjunction().add(Restrictions.eq("mVisitorId", parVisitorId))
							.add(Restrictions.eq("mFileSize", parFileSize)))
					.uniqueResult();
			return lFileSize;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNewFileSize(UserContentInfo parUserContentInfo) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parUserContentInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int UpdateFileSizeScore(String parVisitorId,String parFileSize) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryForToGetFileSizeScore = lSess.createQuery(
				"SELECT mFileSizeScore FROM UserContentInfo WHERE mVisitorId=:id and mFileSize=:FileSize");
		lQueryForToGetFileSizeScore.setParameter("id", parVisitorId);
		lQueryForToGetFileSizeScore.setParameter("FileSize", parFileSize);
		long fileSizeScore = (long) lQueryForToGetFileSizeScore.uniqueResult();
		fileSizeScore = fileSizeScore + 1;

		Query lQueryForToUpdateFileSizeScore = lSess.createQuery(
				"UPDATE UserContentInfo SET mFileSizeScore=:score WHERE mVisitorId=:id and mFileSize=:FileSize");
		lQueryForToUpdateFileSizeScore.setParameter("score", fileSizeScore);
		lQueryForToUpdateFileSizeScore.setParameter("id", parVisitorId);
		lQueryForToUpdateFileSizeScore.setParameter("FileSize", parFileSize);
		int lStatus = lQueryForToUpdateFileSizeScore.executeUpdate();
		return lStatus;
	}

	@Override
	public List<GameCategoryScore> gamesSubTagsRecommendationByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryToGetSubTagsName = lSess
				.createQuery("FROM UserContentInfo WHERE mVisitorId=:Id ORDER BY mSubCategoryTagScore DESC");
		lQueryToGetSubTagsName.setParameter("Id", parVisitorId);
		List<GameCategoryScore> lGameSubTagsScore = lQueryToGetSubTagsName.list();
		return lGameSubTagsScore;
	}

}
