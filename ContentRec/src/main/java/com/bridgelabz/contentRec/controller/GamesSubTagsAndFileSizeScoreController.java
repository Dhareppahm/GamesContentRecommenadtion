package com.bridgelabz.contentRec.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
import com.bridgelabz.contentRec.model.GamesSubTagsAndFileSizeScore;
import com.bridgelabz.contentRec.services.GameInfoService;
import com.bridgelabz.contentRec.services.GamesSubTagsAndFileSizeScoreService;
import com.bridgelabz.contentRec.services.VisitorsInfoService;

@Controller
public class GamesSubTagsAndFileSizeScoreController {
	@Autowired
	VisitorsInfoService mVisitorsInfoService;

	@Autowired
	GameInfoService mGameInfoService;

	@Autowired
	GamesSubTagsAndFileSizeScoreService mGamesSubTagsAndFileSizeScoreService;
	int mCategoryStatus;
	
	Logger mLogger = Logger.getLogger("GAMESUBTAGSANDFILESIZECONTROLLER");

	@RequestMapping(value = "/userContentInfo", method = RequestMethod.GET)
	public String userContentInfo() {
		return "UserContentInfo";

	}

	@RequestMapping(value = "/userContentInfo", method = RequestMethod.POST)
	public String getCatScore(@RequestParam("visitorId") String parVisitorId) {

		Properties lProp = new Properties();
		String lFileName = "CategoryList.properties";

		InputStream lInput = null;
		lInput = GamesSubTagsAndFileSizeScoreController.class.getClassLoader().getResourceAsStream(lFileName);
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
				GamesSubTagsAndFileSizeScore lCatScore = mGamesSubTagsAndFileSizeScoreService
						.CatgeoryExists(parVisitorId, lCategoryName);
				if (lCatScore != null) {
					mCategoryStatus = mGamesSubTagsAndFileSizeScoreService.UpdateCategoryScore(parVisitorId,
							lCategoryName);

				} else {
					mGamesSubTagsAndFileSizeScoreService.addNewCategory(parVisitorId, lCategoryName);
					mCategoryStatus = mGamesSubTagsAndFileSizeScoreService.UpdateCategoryScore(parVisitorId,
							lCategoryName);
				}

				List lContentIdList = mVisitorsInfoService.getContentIdByVisitorId(parVisitorId);

				for (Iterator iterator2 = lContentIdList.iterator(); iterator2.hasNext();) {
					String lContentId = (String) iterator2.next();

					String lSubCategoryTagList = mGameInfoService.getSubCategoryTagsByContentId(lContentId);
					String[] subTags = lSubCategoryTagList.split(",");
					for (int i = 0; i < subTags.length; i++) {
						GamesSubTagsAndFileSizeScore userContentInfo = mGamesSubTagsAndFileSizeScoreService
								.SubCatgeoryTagExists(parVisitorId, subTags[i]);
						if (userContentInfo != null) {
							mGamesSubTagsAndFileSizeScoreService.UpdateSubCategoryTagScore(parVisitorId, subTags[i]);
						} else {
							mGamesSubTagsAndFileSizeScoreService.addNewSubCategoryTag(parVisitorId, subTags[i],
									lContentId);
							int mCategorySubTagStatus = mGamesSubTagsAndFileSizeScoreService
									.UpdateSubCategoryTagScore(parVisitorId, subTags[i]);
						}
					}
					String lFileSize = mGameInfoService.getFileSizeByContentId(lContentId);
					System.out.println(lFileSize);
					GamesSubTagsAndFileSizeScore lUserContentInfo = mGamesSubTagsAndFileSizeScoreService
							.FileSizeExists(parVisitorId, lFileSize);
					if (lUserContentInfo != null) {
						mGamesSubTagsAndFileSizeScoreService.UpdateFileSizeScore(parVisitorId, lFileSize);
					} else {

						mGamesSubTagsAndFileSizeScoreService.addNewFileSize(parVisitorId, lFileSize);
						mGamesSubTagsAndFileSizeScoreService.UpdateFileSizeScore(parVisitorId, lFileSize);
					}

				}

			} else {
				continue;
			}
			if (mCategoryStatus > 0) {
				System.out.println("Succesfullly updated" + " " + lCategoryName + " " + "category score for visitrID:"
						+ parVisitorId);

			} else {
				System.out.println("Error occured while updating" + " " + lCategoryName + " "
						+ "category score for visitrID:" + parVisitorId);
			}

		}
		return "UserContentInfo";

	}

	@RequestMapping(value = "/gamesRecommendationBasedOnMostVisitedSubTags", method = RequestMethod.GET)
	public String dispalyVisitorFrom() {
		return "getSubTagsScore";
	}

	@RequestMapping(value = "/gamesRecommendationBasedOnMostVisitedSubTags", method = RequestMethod.POST)
	public ModelAndView gamesCategoryNameRecommendation(@RequestParam("visitorId") String parVisitorId,
			Model parModel) {
		// int lFlag = 0;
		List lGameInfoList = new ArrayList();
		List<GamesSubTagsAndFileSizeScore> lGameSubTagsSCore = mGamesSubTagsAndFileSizeScoreService
				.getGamesSubTagsScore(parVisitorId);
		Map<String, Object> lGameInfoAndSubTagsmap = new HashMap<String, Object>();
		List lSubTagsList = mGamesSubTagsAndFileSizeScoreService.gamesSubTagsRecommendationByVisitorId(parVisitorId);
		for (Iterator iterator = lSubTagsList.iterator(); iterator.hasNext();) {
			String lsubTagName = (String) iterator.next();

			List<GameInfo> lGameInfo = mGameInfoService.getGameNameBySubTags(lsubTagName);
			lGameInfoList.add(lGameInfo);
		}
		parModel.addAttribute("visitorID", parVisitorId);
		lGameInfoAndSubTagsmap.put("Subtags", lGameSubTagsSCore);
		lGameInfoAndSubTagsmap.put("GameInfo", lGameInfoList);

		return new ModelAndView("gamesRecommendationBasedOnMostVisitedSubTags", "GameInfoAndSubTagsmap",
				lGameInfoAndSubTagsmap);
	}

	@RequestMapping(value = "/gamesRecommendationBasedOnFileSize", method = RequestMethod.POST)
	public ModelAndView gamesRecommendationBasedOnFileSize(@RequestParam("visitorId") String parVisitorId,
			Model parModel) {
		List<GamesSubTagsAndFileSizeScore> lGameFileSizeScore = mGamesSubTagsAndFileSizeScoreService
				.getGamesFileSizeScore(parVisitorId);
		parModel.addAttribute("visitorID", parVisitorId);
		List<GameInfo> lGameInfo = mGameInfoService.getGameNameByFileSize(parVisitorId);
		Map<String, Object> lMap = new HashMap<String, Object>();
		lMap.put("gameFileScore", lGameFileSizeScore);
		lMap.put("gameInfo", lGameInfo);
		return new ModelAndView("gamesRecommendationBasedOnFileSize", "map", lMap);
	}

	@RequestMapping(value = "/gamesRecommendationBasedOnFileSize", method = RequestMethod.GET)
	public String gamesRecommendationBasedOnFileSizeVisitorForm() {
		return "gamesRecommendationBasedOnFileSizeVisitorForm";

	}

}
