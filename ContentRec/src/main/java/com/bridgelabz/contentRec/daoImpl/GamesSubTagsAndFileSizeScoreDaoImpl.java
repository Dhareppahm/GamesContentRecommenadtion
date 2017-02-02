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

import com.bridgelabz.contentRec.dao.GamesSubTagsAndFileSizeScoreDao;
import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.GamesSubTagsAndFileSizeScore;

@Repository
@Transactional
public class GamesSubTagsAndFileSizeScoreDaoImpl implements GamesSubTagsAndFileSizeScoreDao {
	@Autowired
	SessionFactory mSessionFactory;

	@Override
	public GamesSubTagsAndFileSizeScore CatgeoryExists(String parVisitorId, String parCategoryName) {

		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(GamesSubTagsAndFileSizeScore.class);

			GamesSubTagsAndFileSizeScore lCategoryScore = (GamesSubTagsAndFileSizeScore) lCriteria
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
	public void addNewCategory(GamesSubTagsAndFileSizeScore parGamesSubTagsAndFileSizeScore) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parGamesSubTagsAndFileSizeScore);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryForToGetCategoryScore = lSess.createQuery(
				"SELECT mCategoryScore FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:id and mCategoryName=:CatName");
		lQueryForToGetCategoryScore.setParameter("id", parVisitorId);
		lQueryForToGetCategoryScore.setParameter("CatName", parCategoryName);
		long categoryScore = (long) lQueryForToGetCategoryScore.uniqueResult();
		categoryScore = categoryScore + 1;

		Query lQueryForToUpdateCategoryScore = lSess.createQuery(
				"UPDATE GamesSubTagsAndFileSizeScore SET mCategoryScore=:score WHERE mVisitorId=:id and mCategoryName=:CatName");
		lQueryForToUpdateCategoryScore.setParameter("score", categoryScore);
		lQueryForToUpdateCategoryScore.setParameter("id", parVisitorId);
		lQueryForToUpdateCategoryScore.setParameter("CatName", parCategoryName);
		int lStatus = lQueryForToUpdateCategoryScore.executeUpdate();
		return lStatus;
	}

	@Override
	public GamesSubTagsAndFileSizeScore SubCatgeoryTagExists(String parVisitorId, String parSubCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(GamesSubTagsAndFileSizeScore.class);

			GamesSubTagsAndFileSizeScore lCategoryScore = (GamesSubTagsAndFileSizeScore) lCriteria
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
	public void addNewSubCategoryTag(GamesSubTagsAndFileSizeScore parGamesSubTagsAndFileSizeScore) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parGamesSubTagsAndFileSizeScore);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int UpdateSubCategoryScoreTag(String parVisitorId, String parSubCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryForToGetSubCategoryTagScore = lSess.createQuery(
				"SELECT mSubCategoryTagScore FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:id and mSubCategoryTagName=:SubCategoryTagName");
		lQueryForToGetSubCategoryTagScore.setParameter("id", parVisitorId);
		lQueryForToGetSubCategoryTagScore.setParameter("SubCategoryTagName", parSubCategoryName);
		long subCategoryTagScore = (long) lQueryForToGetSubCategoryTagScore.uniqueResult();
		subCategoryTagScore = subCategoryTagScore + 1;

		Query lQueryForToUpdateSubCategoryTagScore = lSess.createQuery(
				"UPDATE GamesSubTagsAndFileSizeScore SET mSubCategoryTagScore=:score WHERE mVisitorId=:id and mSubCategoryTagName=:SubCategoryTagName");
		lQueryForToUpdateSubCategoryTagScore.setParameter("score", subCategoryTagScore);
		lQueryForToUpdateSubCategoryTagScore.setParameter("id", parVisitorId);
		lQueryForToUpdateSubCategoryTagScore.setParameter("SubCategoryTagName", parSubCategoryName);
		int lStatus = lQueryForToUpdateSubCategoryTagScore.executeUpdate();
		return lStatus;
	}

	@Override
	public GamesSubTagsAndFileSizeScore FileSizeExists(String parVisitorId, String parFileSize) {
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(GamesSubTagsAndFileSizeScore.class);

			GamesSubTagsAndFileSizeScore lFileSize = (GamesSubTagsAndFileSizeScore) lCriteria
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
	public void addNewFileSize(GamesSubTagsAndFileSizeScore parGamesSubTagsAndFileSizeScore) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parGamesSubTagsAndFileSizeScore);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int UpdateFileSizeScore(String parVisitorId, String parFileSize) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryForToGetFileSizeScore = lSess.createQuery(
				"SELECT mFileSizeScore FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:id and mFileSize=:FileSize");
		lQueryForToGetFileSizeScore.setParameter("id", parVisitorId);
		lQueryForToGetFileSizeScore.setParameter("FileSize", parFileSize);
		long fileSizeScore = (long) lQueryForToGetFileSizeScore.uniqueResult();
		fileSizeScore = fileSizeScore + 1;

		Query lQueryForToUpdateFileSizeScore = lSess.createQuery(
				"UPDATE GamesSubTagsAndFileSizeScore SET mFileSizeScore=:score WHERE mVisitorId=:id and mFileSize=:FileSize");
		lQueryForToUpdateFileSizeScore.setParameter("score", fileSizeScore);
		lQueryForToUpdateFileSizeScore.setParameter("id", parVisitorId);
		lQueryForToUpdateFileSizeScore.setParameter("FileSize", parFileSize);
		int lStatus = lQueryForToUpdateFileSizeScore.executeUpdate();
		return lStatus;
	}

	@Override
	public List gamesSubTagsRecommendationByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		String lTagName = "Games";
		Query lQueryToGetSubTagsName = lSess.createQuery(
				"SELECT mSubCategoryTagName FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:Id and mSubCategoryTagName LIKE '%"+ lTagName + "%' ORDER BY mSubCategoryTagScore DESC");
		lQueryToGetSubTagsName.setParameter("Id", parVisitorId);
		List lGameSubTagsName = lQueryToGetSubTagsName.list();
		return lGameSubTagsName;
	}

	@Override
	public List<GamesSubTagsAndFileSizeScore> getGamesSubTagsScore(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		String lTagName = "Games";
		Query lQueryToGetSubTagsName = lSess
				.createQuery("FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:Id and mSubCategoryTagName LIKE '%"
						+ lTagName + "%' ORDER BY mSubCategoryTagScore DESC");
		lQueryToGetSubTagsName.setParameter("Id", parVisitorId);
		List<GamesSubTagsAndFileSizeScore> lGameSubTagsScore = lQueryToGetSubTagsName.list();
		return lGameSubTagsScore;

	}

	@Override
	public List<GamesSubTagsAndFileSizeScore> getGamesFileSizeScore(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		String lTagName = "Games";
		Query lQueryToGetSubTagsName = lSess
				.createQuery("FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:Id and mFileSize LIKE '%MB' ORDER BY mFileSizeScore DESC");
		lQueryToGetSubTagsName.setParameter("Id", parVisitorId);
		List<GamesSubTagsAndFileSizeScore> lGameSubTagsScore = lQueryToGetSubTagsName.list();
		return lGameSubTagsScore;
	}

}
