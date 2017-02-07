/*
* @Author:Dhareppa Metri
* File:GameInfoDaoImpl.java
* Purpose:Implementation class for the interface GameInfoDao.
**/
package com.bridgelabz.contentRec.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.contentRec.dao.GameInfoDao;
import com.bridgelabz.contentRec.model.GameInfo;

@Repository
@Transactional
public class GameInfoDaoImpl implements GameInfoDao {
	@Autowired
	SessionFactory sessionFactory;

	Logger mLogger = Logger.getLogger("GAMEINFORMATIONDAOIMPL");

	/**
	 * This method is used to save game information
	 * 
	 * @param GameInfo,is
	 *            the first parameter for this method contains game information
	 */
	public void saveGameInfo(GameInfo parGameInfo) {
		Session sess = sessionFactory.getCurrentSession();
		try {
			sess.save(parGameInfo);
		} // End of try
		catch (Exception e) {
			e.printStackTrace();
		} // End of catch

	}// End of saveGameInfo method

	/**
	 * This method is used to get game information by content Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return List<GameInfo>,list game information
	 */
	public List<GameInfo> getGameInfoByContentId(String parContentId) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery("from GameInfo where mContentId=:id");
		qry.setParameter("id", parContentId);
		List<GameInfo> gameInfo = qry.list();
		return gameInfo;
	}// End of getGameInfoByContentId method

	/**
	 * This method is used to get game name by category name
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return List<GameInfo>,list game information
	 */
	@Override
	public List<GameInfo> getGameNameByGameCategory(String parVisitorId) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery(
				"FROM GameInfo WHERE mCategoryName IN(select mCategoryName FROM GameCategoryScore WHERE mVisitorId=:id)"
						+ " " + "ORDER BY mContentRating DESC");
		qry.setParameter("id", parVisitorId);
		List<GameInfo> gameInfo = qry.list();
		return gameInfo;
	}// End of getGameNameByGameCategory method

	/**
	 * This method is used to get sub tags by content Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return String,sub tag name
	 */
	@Override
	public String getSubCategoryTagsByContentId(String parContentId) {

		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery("select mMetaTags from GameInfo where mContentId=:id");
		qry.setParameter("id", parContentId);
		String gameInfo = (String) qry.uniqueResult();
		return gameInfo;
	}// End of getSubCategoryTagsByContentId method

	/**
	 * This method is used to get file size by content Id
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return String,file size
	 */
	@Override
	public String getFileSizeByContentId(String parContentId) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery("select mFileSize from GameInfo where mContentId=:id");
		qry.setParameter("id", parContentId);
		String gameInfo = (String) qry.uniqueResult();
		return gameInfo;
	}// End of getFileSizeByContentId method

	/**
	 * This method is used to get game name by sub tag
	 * 
	 * @param String,
	 *            is the first parameter for this method contains sub tag name
	 * @return List<GameInfo>,list of game names
	 */
	@Override
	public List<GameInfo> getGameNameBySubTags(String parSubTag) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery(
				"FROM GameInfo WHERE mMetaTags LIKE '%" + parSubTag + "%'" + " " + "ORDER BY mTotalDownloads DESC");
		List<GameInfo> gameInfo = qry.list();
		return gameInfo;
	}// End of getFileSizeByContentId method

	/**
	 * This method is used to get game name by file size
	 * 
	 * @param String,
	 *            is the first parameter for this method contains file size
	 * @return List<GameInfo>,list of game names
	 */
	@Override
	public List<GameInfo> getGameNameByFileSize(String parVisitorId) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery(
				"FROM GameInfo WHERE mFileSize IN(select mFileSize FROM GamesSubTagsAndFileSizeScore WHERE mVisitorId=:id) ORDER BY mContentRating DESC");
		qry.setParameter("id", parVisitorId);
		List<GameInfo> gameInfo = qry.list();
		return gameInfo;
	}// End of getGameNameByFileSize method

}
