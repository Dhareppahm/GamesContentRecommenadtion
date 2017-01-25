/*
* @Author:Dhareppa Metri
* File:GameCategoryScoreDaoImpl.java
* Purpose:Implementation class for the interface GameCategoryScoreDao.
**/
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

import com.bridgelabz.contentRec.dao.GameCategoryScoreDao;
import com.bridgelabz.contentRec.model.GameCategoryScore;

@Repository
@Transactional
public class GameCategoryScoreDaoImpl implements GameCategoryScoreDao {
	@Autowired
	SessionFactory mSessionFactory;

	@Override
	public GameCategoryScore CatgeoryExists(String parVisitorId, String parCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(GameCategoryScore.class);

			GameCategoryScore lCategoryScore = (GameCategoryScore) lCriteria.add(Restrictions.conjunction()
					.add(Restrictions.eq("mVisitorId", parVisitorId)).add(Restrictions.eq("mCategoryName", parCategoryName)))
					.uniqueResult();
			return lCategoryScore;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNewCategory(GameCategoryScore mGameCategoryScore) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(mGameCategoryScore);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int UpdateCategoryScore(String parVisitorId, String parCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryForToGetCategoryScore = lSess
				.createQuery("SELECT mCatMarks from GameCategoryScore where mVisitorId=:id and mCategoryName=:CatName");
		lQueryForToGetCategoryScore.setParameter("id", parVisitorId);
		lQueryForToGetCategoryScore.setParameter("CatName", parCategoryName);
		long categoryScore = (long) lQueryForToGetCategoryScore.uniqueResult();
		categoryScore = categoryScore + 1;

		Query lQueryForToUpdateCategoryScore = lSess
				.createQuery("update GameCategoryScore set mCatMarks=:score where mVisitorId=:id and mCategoryName=:CatName");
		lQueryForToUpdateCategoryScore.setParameter("score", categoryScore);
		lQueryForToUpdateCategoryScore.setParameter("id", parVisitorId);
		lQueryForToUpdateCategoryScore.setParameter("CatName", parCategoryName);
		int lStatus = lQueryForToUpdateCategoryScore.executeUpdate();
		return lStatus;
	}

	@Override
	public List<GameCategoryScore> gamesCategoryNameRecommendationByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryToGetCategoryName = lSess
				.createQuery("FROM GameCategoryScore WHERE mVisitorId=:Id ORDER BY mCatMarks ASC");
		lQueryToGetCategoryName.setParameter("Id", parVisitorId);
		List<GameCategoryScore> lGamecategoryScore = lQueryToGetCategoryName.list();
		return lGamecategoryScore;

	}

	@Override
	public List getCategoryNameByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryToGetCategoryNameByVisitorId = lSess
				.createQuery("select mCategoryName from GameCategoryScore where mVisitorId=:id");
		lQueryToGetCategoryNameByVisitorId.setParameter("id", parVisitorId);
		List lCategoryNameList = lQueryToGetCategoryNameByVisitorId.list();
		return lCategoryNameList;

	}
}
