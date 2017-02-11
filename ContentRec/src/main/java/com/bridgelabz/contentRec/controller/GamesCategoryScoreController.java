/*
* @Author:Dhareppa Metri
* File:GamesCategoryScoreController.java
* Purpose:Controller class for to calculate game category score information.
**/
package com.bridgelabz.contentRec.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.contentRec.model.GameCategoryScore;
import com.bridgelabz.contentRec.model.GameInfo;
import com.bridgelabz.contentRec.services.GameCategoryScoreService;
import com.bridgelabz.contentRec.services.GameInfoService;
import com.bridgelabz.contentRec.services.VisitorsInfoService;

@Controller
public class GamesCategoryScoreController {
	@Autowired
	GameCategoryScoreService mGameCategoryScoreService;
	@Autowired
	VisitorsInfoService mVisitorsInfoService;
	@Autowired
	GameInfoService mGameInfoService;

	Logger mLogger = Logger.getLogger("GAMECATEGORYSCORECONTROLLER");

	/**
	 * This method is used to display category form
	 * 
	 * @return ModelAndView,getCategoryScore view
	 */
	@RequestMapping(value = "/getCategoryScore", method = RequestMethod.GET)
	public ModelAndView dispalyVisitorFrom() {
		return new ModelAndView("getCategoryScore");
	}// End of dispalyVisitorFrom method

	/**
	 * This method is used to calculate game category score
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return ModelAndView,FetchAndSaveGameInfo view
	 */
	@RequestMapping(value = "/getCategoryScore", method = RequestMethod.POST)
	public ModelAndView getCatScore(@RequestParam("visitorId") String parVisitorId) {
		int lStatus;
		Properties lProp = new Properties();
		String lFileName = "CategoryList.properties";

		InputStream lInput = null;
		lInput = GamesCategoryScoreController.class.getClassLoader().getResourceAsStream(lFileName);
		try {

			if (lInput == null) {
				System.out.println("Sorry, unable to find " + lFileName);
			} // End of if
			lProp.load(lInput);

		} // End of try
		catch (IOException e1) {
			e1.printStackTrace();
		} // End of catch
		finally {
			if (lInput != null) {
				try {
					lInput.close();
				} // End of try
				catch (IOException e) {
					e.printStackTrace();
				} // End of catch
			} // End of if
		} // End of finally
		List lCategoryNameList = mVisitorsInfoService.getCategoryNamesByVisitorId(parVisitorId);
		for (Iterator iterator = lCategoryNameList.iterator(); iterator.hasNext();) {
			String lCategoryName = (String) iterator.next();
			if (lCategoryName.equals(lProp.getProperty("CatTag1")) || lCategoryName.equals(lProp.getProperty("CatTag2"))
					|| lCategoryName.equals(lProp.getProperty("CatTag3"))
					|| lCategoryName.equals(lProp.getProperty("CatTag4"))
					|| lCategoryName.equals(lProp.getProperty("CatTag5"))
					|| lCategoryName.equals(lProp.getProperty("CatTag6"))
					|| lCategoryName.equals(lProp.getProperty("CatTag7"))
					|| lCategoryName.equals(lProp.getProperty("CatTag8"))
					|| lCategoryName.equals(lProp.getProperty("CatTag9"))) {
				GameCategoryScore lCatScore = mGameCategoryScoreService.CatgeoryExists(parVisitorId, lCategoryName);
				if (lCatScore != null) {
					lStatus = mGameCategoryScoreService.UpdateCategoryScore(parVisitorId, lCategoryName);

				} // End of if
				else {
					mGameCategoryScoreService.addNewCategory(parVisitorId, lCategoryName);
					lStatus = mGameCategoryScoreService.UpdateCategoryScore(parVisitorId, lCategoryName);
				} // End of else
			} else {
				continue;
			} // End of else
			if (lStatus > 0) {
				System.out.println("Succesfullly updated" + " " + lCategoryName + " " + "category score for visitrID:"
						+ parVisitorId);

			} // End of if
			else {
				System.out.println("Error occured while updating" + " " + lCategoryName + " "
						+ "category scogetCategoryNameByVisitorIdre for visitrID:" + parVisitorId);
			} // End of else

		} // End of for
		return new ModelAndView("getCategoryScore");

	}// End of getCatScore method

	/**
	 * This method is used to display visitor form
	 * 
	 * @return ModelAndView,VisitorFormToRecommendGamesBasedOnCategories view
	 */
	@RequestMapping(value = "/gamesCategoryNameRecommendation", method = RequestMethod.GET)
	public ModelAndView displayGamesCategoryNameRecommendation() {
		return new ModelAndView("VisitorFormToRecommendGamesBasedOnCategories");

	}// End of displayGamesCategoryNameRecommendation method

	/**
	 * This method is used to transfer games category name and games name
	 * recommendations to view part
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return ModelAndView,gamesCategoryNameAndGamesNameRecommendations view
	 */
	@RequestMapping(value = "/gamesCategoryNameAndGamesNameRecommendation", method = RequestMethod.POST)
	public ModelAndView gamesCategoryNameRecommendation(@RequestParam("visitorId") String parVisitorId,
			Model parModel) {
		List<GameCategoryScore> lGameCategoryScore = mGameCategoryScoreService
				.gamesCategoryNameRecommendationByVisitorId(parVisitorId);
		parModel.addAttribute("visitorID", parVisitorId);
		List<GameInfo> lGameInfo = mGameInfoService.getGameNameByGameCategory(parVisitorId);
		Map<String, Object> lMap = new HashMap<String, Object>();
		lMap.put("gameCategoryScore", lGameCategoryScore);
		lMap.put("gameInfo", lGameInfo);
		return new ModelAndView("gamesCategoryNameAndGamesNameRecommendations", "map", lMap);
	}// End of gamesCategoryNameRecommendation method

}// End of GamesCategoryScoreController class
