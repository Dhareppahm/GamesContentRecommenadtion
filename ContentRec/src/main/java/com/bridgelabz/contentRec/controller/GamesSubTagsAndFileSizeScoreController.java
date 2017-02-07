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

	/**
	 * This method is used to display user form
	 * 
	 * @return String(view),UserContentInfo view
	 */
	@RequestMapping(value = "/userContentInfo", method = RequestMethod.GET)
	public String userContentInfo() {
		return "UserContentInfo";
	}// End of userContentInfo method

	/**
	 * This method is used to calculate the sub tags and file size score
	 * 
	 * @param String,
	 *            is the first parameter for this method contains visitor Id
	 * @return String(view),UserContentInfo view
	 */
	@RequestMapping(value = "/userContentInfo", method = RequestMethod.POST)
	public String getCatScore(@RequestParam("visitorId") String parVisitorId) {

		Properties lProp = new Properties();
		String lFileName = "CategoryList.properties";

		InputStream lInput = null;
		lInput = GamesSubTagsAndFileSizeScoreController.class.getClassLoader().getResourceAsStream(lFileName);
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
				GamesSubTagsAndFileSizeScore lCatScore = mGamesSubTagsAndFileSizeScoreService
						.CatgeoryExists(parVisitorId, lCategoryName);
				if (lCatScore != null) {
					mCategoryStatus = mGamesSubTagsAndFileSizeScoreService.UpdateCategoryScore(parVisitorId,
							lCategoryName);

				} // End of if
				else {
					mGamesSubTagsAndFileSizeScoreService.addNewCategory(parVisitorId, lCategoryName);
					mCategoryStatus = mGamesSubTagsAndFileSizeScoreService.UpdateCategoryScore(parVisitorId,
							lCategoryName);
				} // End of else

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
						} // End of if
						else {
							mGamesSubTagsAndFileSizeScoreService.addNewSubCategoryTag(parVisitorId, subTags[i],
									lContentId);
							int mCategorySubTagStatus = mGamesSubTagsAndFileSizeScoreService
									.UpdateSubCategoryTagScore(parVisitorId, subTags[i]);
						} // End of else
					} // End of for
					String lFileSize = mGameInfoService.getFileSizeByContentId(lContentId);
					System.out.println(lFileSize);
					GamesSubTagsAndFileSizeScore lUserContentInfo = mGamesSubTagsAndFileSizeScoreService
							.FileSizeExists(parVisitorId, lFileSize);
					if (lUserContentInfo != null) {
						mGamesSubTagsAndFileSizeScoreService.UpdateFileSizeScore(parVisitorId, lFileSize);
					} // End of if
					else {

						mGamesSubTagsAndFileSizeScoreService.addNewFileSize(parVisitorId, lFileSize);
						mGamesSubTagsAndFileSizeScoreService.UpdateFileSizeScore(parVisitorId, lFileSize);
					} // End of else

				} // End of for

			} // End of if
			else {
				continue;
			} // End of else
			if (mCategoryStatus > 0) {
				System.out.println("Succesfullly updated" + " " + lCategoryName + " " + "category score for visitrID:"
						+ parVisitorId);

			} // End of if
			else {
				System.out.println("Error occured while updating" + " " + lCategoryName + " "
						+ "category score for visitrID:" + parVisitorId);
			} // End of else

		} // End of if
		return "UserContentInfo";

	}// End of getCatScore method

	/**
	 * This method is used to display games recommendation form
	 * 
	 * @return String(view),getSubTagsScore view
	 */
	@RequestMapping(value = "/gamesRecommendationBasedOnMostVisitedSubTags", method = RequestMethod.GET)
	public String dispalyVisitorFrom() {
		return "getSubTagsScore";
	}// End of dispalyVisitorFrom method

	/**
	 * This method is used to transfer visited sub tags to view part
	 * 
	 * @return ModelAndView,gamesRecommendationBasedOnMostVisitedSubTags view
	 */
	@RequestMapping(value = "/gamesRecommendationBasedOnMostVisitedSubTags", method = RequestMethod.POST)
	public ModelAndView gamesCategoryNameRecommendation(@RequestParam("visitorId") String parVisitorId,
			Model parModel) {
		List lGameInfoList = new ArrayList();
		List<GamesSubTagsAndFileSizeScore> lGameSubTagsSCore = mGamesSubTagsAndFileSizeScoreService
				.getGamesSubTagsScore(parVisitorId);
		Map<String, Object> lGameInfoAndSubTagsmap = new HashMap<String, Object>();
		List lSubTagsList = mGamesSubTagsAndFileSizeScoreService.gamesSubTagsRecommendationByVisitorId(parVisitorId);
		for (Iterator iterator = lSubTagsList.iterator(); iterator.hasNext();) {
			String lsubTagName = (String) iterator.next();

			List<GameInfo> lGameInfo = mGameInfoService.getGameNameBySubTags(lsubTagName);
			lGameInfoList.add(lGameInfo);
		} // End of for
		parModel.addAttribute("visitorID", parVisitorId);
		lGameInfoAndSubTagsmap.put("Subtags", lGameSubTagsSCore);
		lGameInfoAndSubTagsmap.put("GameInfo", lGameInfoList);

		return new ModelAndView("gamesRecommendationBasedOnMostVisitedSubTags", "GameInfoAndSubTagsmap",
				lGameInfoAndSubTagsmap);
	}// End of gamesCategoryNameRecommendation method

	/**
	 * This method is used to transfer visited file size to view part
	 * 
	 * @return ModelAndView,gamesRecommendationBasedOnMostVisitedSubTags view
	 */
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
	}// End of gamesRecommendationBasedOnFileSize method

	/**
	 * This method is used to display games recommendation form
	 * 
	 * @return ModelAndView,gamesRecommendationBasedOnFileSizeVisitorForm view
	 */
	@RequestMapping(value = "/gamesRecommendationBasedOnFileSize", method = RequestMethod.GET)
	public String gamesRecommendationBasedOnFileSizeVisitorForm() {
		return "gamesRecommendationBasedOnFileSizeVisitorForm";

	}// End of gamesRecommendationBasedOnFileSizeVisitorForm method

}// End of GamesSubTagsAndFileSizeScoreController class
