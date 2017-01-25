/*
* @Author:Dhareppa Metri
* File:GamesCategoryScoreController.java
* Purpose:Controller class for to calculate game category score information.
**/
package com.bridgelabz.contentRec.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

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
	GameInfoService mGameInfoServie;

	@RequestMapping(value = "/getCatScore", method = RequestMethod.GET)
	public String dispalyVisitorFrom() {
		return "CatScore";
	}

	@RequestMapping(value = "/getCatScore", method = RequestMethod.POST)
	public String getCatScore(@RequestParam("visitorId") String parVisitorId) {
		int mStatus;
		Properties lProp = new Properties();
		String lFileName = "CategoryList.properties";

		InputStream lInput = null;
		lInput = GamesCategoryScoreController.class.getClassLoader().getResourceAsStream(lFileName);
		try {

			if (lInput == null) {
				System.out.println("Sorry, unable to find " + lFileName);
			}
			lProp.load(lInput);

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (lInput != null) {
				try {
					lInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		List lCategoryNameList = mVisitorsInfoService.getCategoryNameByVisitorId(parVisitorId);
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
					mStatus = mGameCategoryScoreService.UpdateCategoryScore(parVisitorId, lCategoryName);

				} else {
					mGameCategoryScoreService.addNewCategory(parVisitorId, lCategoryName);
					mStatus = mGameCategoryScoreService.UpdateCategoryScore(parVisitorId, lCategoryName);
				}
			} else {
				continue;
			}
			if (mStatus > 0) {
				System.out.println(
						"Succesfullly updated" + " " + lCategoryName + " " + "category score for visitrID:" + parVisitorId);

			} else {
				System.out.println("Error occured while updating" + " " + lCategoryName + " "
						+ "category scogetCategoryNameByVisitorIdre for visitrID:" + parVisitorId);
			}

		}
		return "CatScore";

	}

	@RequestMapping(value = "/gamesCategoryNameRecommendation", method = RequestMethod.GET)
	public String displayGamesCategoryNameRecommendation() {
		return "VisitorFormToRecommendGamesBasedOnCategories";

	}

	@RequestMapping(value = "/gamesCategoryNameRecommendation", method = RequestMethod.POST)
	public ModelAndView gamesCategoryNameRecommendation(@RequestParam("visitorId") String parVisitorId, Model parModel) {
		List<GameCategoryScore> lGameCategoryScore = mGameCategoryScoreService
				.gamesCategoryNameRecommendationByVisitorId(parVisitorId);
		parModel.addAttribute("visitorID", parVisitorId);
		return new ModelAndView("GamesCategoryNameRecommendation", "gameCategoryScore", lGameCategoryScore);
	}

	@RequestMapping(value = "/gamesRecommended", method = RequestMethod.GET)
	public ModelAndView gamesRecommended(@RequestParam("visitorId") String parVisitorId, Model parModel) {
		List<GameInfo> lGameInfo = mGameInfoServie.getGameNameByGameCategory(parVisitorId);
		parModel.addAttribute("visitorID", parVisitorId);
		return new ModelAndView("GamesRecommended","gameInfo",lGameInfo);
	}
	
}
