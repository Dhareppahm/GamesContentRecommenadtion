/*
* @Author:Dhareppa Metri
* File:GameInfoDaoImpl.java
* Purpose:Implementation class for the interface GameInfoDao.
**/
package com.bridgelabz.contentRec.daoImpl;

import java.util.List;

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

	public void saveGameInfo(GameInfo parGameInfo) {
		Session sess = sessionFactory.getCurrentSession();
		try {
			sess.save(parGameInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<GameInfo> dispalyGameInfoByContentId(String parContentId) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery("from GameInfo where mContentId=:id");
		qry.setParameter("id", parContentId);
		List<GameInfo> gameInfo = qry.list();
		return gameInfo;
	}

	public List<GameInfo> getGameInfoByContentId(String parContentId) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery("from GameInfo where mContentId=:id");
		qry.setParameter("id", parContentId);
		List<GameInfo> gameInfo = qry.list();
		return gameInfo;
	}

	@Override
	public List<GameInfo> getGameNameByGameCategory(String parVisitorId) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery(
				"FROM GameInfo WHERE mCategoryName IN(select mCategoryName FROM GameCategoryScore WHERE mVisitorId=:id)");
		qry.setParameter("id", parVisitorId);
		List<GameInfo> gameInfo = qry.list();
		return gameInfo;
	}

	@Override
	public String getSubCategoryTagsByContentId(String parContentId) {

		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery("select mMetaTags from GameInfo where mContentId=:id");
		qry.setParameter("id", parContentId);
		String gameInfo = (String)qry.uniqueResult();
		return gameInfo;
	}

	@Override
	public String getFileSizeByContentId(String parContentId) {
		Session sess = sessionFactory.getCurrentSession();
		Query qry = sess.createQuery("select mFileSize from GameInfo where mContentId=:id");
		qry.setParameter("id", parContentId);
		String gameInfo = (String)qry.uniqueResult();
		return gameInfo;
	}

}
