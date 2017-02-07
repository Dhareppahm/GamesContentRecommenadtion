/*
* @Author:Dhareppa Metri
* File:GameCategoryScoreDaoImpl.java
* Purpose:Implementation class for the interface GameCategoryScoreDao.
**/
package com.bridgelabz.contentRec.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
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

	Logger mLogger = Logger.getLogger("GAMECATEGORYSCOREDAOIMPL");

	/**
	 * This method is used to check the game category exists or not
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains category name
	 * @return GameCategoryScore,GameCategoryScore object
	 */
	@Override
	public GameCategoryScore CatgeoryExists(String parVisitorId, String parCategoryName) {
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(GameCategoryScore.class);

			GameCategoryScore lCategoryScore = (GameCategoryScore) lCriteria
					.add(Restrictions.conjunction().add(Restrictions.eq("mVisitorId", parVisitorId))
							.add(Restrictions.eq("mCategoryName", parCategoryName)))
					.uniqueResult();
			return lCategoryScore;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method is used to add new game category
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @param String,is
	 *            second parameter for this method contains category name
	 */
	@Override
	public void addNewCategory(GameCategoryScore mGameCategoryScore) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(mGameCategoryScore);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

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
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryForToGetCategoryScore = lSess
				.createQuery("SELECT mCatMarks from GameCategoryScore where mVisitorId=:id and mCategoryName=:CatName");
		lQueryForToGetCategoryScore.setParameter("id", parVisitorId);
		lQueryForToGetCategoryScore.setParameter("CatName", parCategoryName);
		long categoryScore = (long) lQueryForToGetCategoryScore.uniqueResult();
		categoryScore = categoryScore + 1;

		Query lQueryForToUpdateCategoryScore = lSess.createQuery(
				"update GameCategoryScore set mCatMarks=:score where mVisitorId=:id and mCategoryName=:CatName");
		lQueryForToUpdateCategoryScore.setParameter("score", categoryScore);
		lQueryForToUpdateCategoryScore.setParameter("id", parVisitorId);
		lQueryForToUpdateCategoryScore.setParameter("CatName", parCategoryName);
		int lStatus = lQueryForToUpdateCategoryScore.executeUpdate();
		return lStatus;
	}

	/**
	 * This method is used to recommend game category name to visitor by
	 * visitorId
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @return List<GameCategoryScore>,list game category names
	 */
	@Override
	public List<GameCategoryScore> gamesCategoryNamesRecommendationByVisitorId(String parVisitorId) {
		Session lSess = mSessionFactory.getCurrentSession();
		Query lQueryToGetCategoryName = lSess
				.createQuery("FROM GameCategoryScore WHERE mVisitorId=:Id ORDER BY mCatMarks DESC");
		lQueryToGetCategoryName.setParameter("Id", parVisitorId);
		List<GameCategoryScore> lGamecategoryScore = lQueryToGetCategoryName.list();
		return lGamecategoryScore;

	}

	/**
	 * This method is used to get game category name byvisitorId
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitorId
	 * @return List<GameCategoryScore>,list game category names
	 */
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
