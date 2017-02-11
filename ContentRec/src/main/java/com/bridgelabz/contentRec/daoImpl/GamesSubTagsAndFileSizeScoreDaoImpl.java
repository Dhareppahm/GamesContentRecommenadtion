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

import com.bridgelabz.contentRec.dao.GamesSubTagsAndFileSizeScoreDao;
import com.bridgelabz.contentRec.model.GamesSubTagsAndFileSizeScore;

@Repository
@Transactional
public class GamesSubTagsAndFileSizeScoreDaoImpl implements GamesSubTagsAndFileSizeScoreDao {
	@Autowired
	SessionFactory mSessionFactory;

	Logger mLogger = Logger.getLogger("GAMESUBTAGSANDFILESIZESCOREDAOIMPL");

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

		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(GamesSubTagsAndFileSizeScore.class);

			GamesSubTagsAndFileSizeScore lCategoryScore = (GamesSubTagsAndFileSizeScore) lCriteria
					.add(Restrictions.conjunction().add(Restrictions.eq("mVisitorId", parVisitorId))
							.add(Restrictions.eq("mCategoryName", parCategoryName)))
					.uniqueResult();
			return lCategoryScore;
		} // End of try
		catch (HibernateException e) {
			e.printStackTrace();
		} // End of catch
		return null;
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
	public void addNewCategory(GamesSubTagsAndFileSizeScore parGamesSubTagsAndFileSizeScore) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parGamesSubTagsAndFileSizeScore);
		} // End of try
		catch (Exception e) {
			e.printStackTrace();
		} // End of catch

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
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(GamesSubTagsAndFileSizeScore.class);

			GamesSubTagsAndFileSizeScore lCategoryScore = (GamesSubTagsAndFileSizeScore) lCriteria
					.add(Restrictions.conjunction().add(Restrictions.eq("mVisitorId", parVisitorId))
							.add(Restrictions.eq("mSubCategoryTagName", parSubCategoryName)))
					.uniqueResult();
			return lCategoryScore;
		} // End of try
		catch (HibernateException e) {
			e.printStackTrace();
		} // End of catch
		return null;
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
	public void addNewSubCategoryTag(GamesSubTagsAndFileSizeScore parGamesSubTagsAndFileSizeScore) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parGamesSubTagsAndFileSizeScore);
		} // End of try
		catch (Exception e) {
			e.printStackTrace();
		} // End of catch

	}// End of addNewSubCategoryTag

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
	}// End of UpdateSubCategoryScoreTag method

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
		Session lSess = mSessionFactory.getCurrentSession();
		try {
			Criteria lCriteria = lSess.createCriteria(GamesSubTagsAndFileSizeScore.class);

			GamesSubTagsAndFileSizeScore lFileSize = (GamesSubTagsAndFileSizeScore) lCriteria
					.add(Restrictions.conjunction().add(Restrictions.eq("mVisitorId", parVisitorId))
							.add(Restrictions.eq("mFileSize", parFileSize)))
					.uniqueResult();
			return lFileSize;
		} // End of try
		catch (HibernateException e) {
			e.printStackTrace();
		} // End of catch
		return null;
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
	public void addNewFileSize(GamesSubTagsAndFileSizeScore parGamesSubTagsAndFileSizeScore) {
		Session lSess = mSessionFactory.getCurrentSession();

		try {
			lSess.save(parGamesSubTagsAndFileSizeScore);
		} // End of try
		catch (Exception e) {
			e.printStackTrace();
		} // End of catch

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
		Session lSess = mSessionFactory.getCurrentSession();
		String lTagName = "Games";
		Query lQueryToGetSubTagsName = lSess.createQuery(
				"SELECT mSubCategoryTagName FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:Id and mSubCategoryTagName LIKE '%"
						+ lTagName + "%' ORDER BY mSubCategoryTagScore DESC");
		lQueryToGetSubTagsName.setParameter("Id", parVisitorId);
		List lGameSubTagsName = lQueryToGetSubTagsName.list();
		return lGameSubTagsName;
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
		Session lSess = mSessionFactory.getCurrentSession();
		String lTagName = "Games";
		Query lQueryToGetSubTagsName = lSess
				.createQuery("FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:Id and mSubCategoryTagName LIKE '%"
						+ lTagName + "%' ORDER BY mSubCategoryTagScore DESC");
		lQueryToGetSubTagsName.setParameter("Id", parVisitorId);
		List<GamesSubTagsAndFileSizeScore> lGameSubTagsScore = lQueryToGetSubTagsName.list();
		return lGameSubTagsScore;

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
		Session lSess = mSessionFactory.getCurrentSession();
		String lTagName = "Games";
		Query lQueryToGetSubTagsName = lSess.createQuery(
				"FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:Id and mFileSize LIKE '%MB' ORDER BY mFileSizeScore DESC");
		lQueryToGetSubTagsName.setParameter("Id", parVisitorId);
		List<GamesSubTagsAndFileSizeScore> lGameSubTagsScore = lQueryToGetSubTagsName.list();
		return lGameSubTagsScore;
	}// End of getGamesFileSizeScore method

}// End of GamesSubTagsAndFileSizeScoreDaoImpl class
