package com.bridgelabz.contentRec.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import com.bridgelabz.contentRec.model.UserContentInfo;
import com.bridgelabz.contentRec.services.GameInfoService;
import com.bridgelabz.contentRec.services.UserContentInfoService;
import com.bridgelabz.contentRec.services.VisitorsInfoService;

@Controller
public class UserContentInfoController {
	@Autowired
	VisitorsInfoService mVisitorsInfoService;

	@Autowired
	GameInfoService mGameInfoService;

	@Autowired
	UserContentInfoService mUserContentInfoService;
	int mCategoryStatus;

	@RequestMapping(value = "/userContentInfo", method = RequestMethod.GET)
	public String userContentInfo() {
		return "UserContentInfo";

	}

	@RequestMapping(value = "/userContentInfo", method = RequestMethod.POST)
	public String getCatScore(@RequestParam("visitorId") String parVisitorId) {

		Properties lProp = new Properties();
		String lFileName = "CategoryList.properties";

		InputStream lInput = null;
		lInput = UserContentInfoController.class.getClassLoader().getResourceAsStream(lFileName);
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
				UserContentInfo lCatScore = mUserContentInfoService.CatgeoryExists(parVisitorId, lCategoryName);
				if (lCatScore != null) {
					mCategoryStatus = mUserContentInfoService.UpdateCategoryScore(parVisitorId, lCategoryName);

				} else {
					mUserContentInfoService.addNewCategory(parVisitorId, lCategoryName);
					mCategoryStatus = mUserContentInfoService.UpdateCategoryScore(parVisitorId, lCategoryName);
				}

				List lContentIdList = mVisitorsInfoService.getContentIdByVisitorId(parVisitorId);

				for (Iterator iterator2 = lContentIdList.iterator(); iterator2.hasNext();) {
					String lContentId = (String) iterator2.next();

					String lSubCategoryTagList = mGameInfoService.getSubCategoryTagsByContentId(lContentId);
					String[] subTags = lSubCategoryTagList.split(",");
					for (int i = 0; i < subTags.length; i++) {
						UserContentInfo userContentInfo = mUserContentInfoService.SubCatgeoryTagExists(parVisitorId,
								subTags[i]);
						if (userContentInfo != null) {
							mUserContentInfoService.UpdateSubCategoryTagScore(parVisitorId, subTags[i]);
						} else {
							mUserContentInfoService.addNewSubCategoryTag(parVisitorId, subTags[i],lContentId);
							int mCategorySubTagStatus = mUserContentInfoService.UpdateSubCategoryTagScore(parVisitorId,
									subTags[i]);
						}
					}
					String lFileSize = mGameInfoService.getFileSizeByContentId(lContentId);
					System.out.println(lFileSize);
					UserContentInfo lUserContentInfo = mUserContentInfoService.FileSizeExists(parVisitorId, lFileSize);
					if (lUserContentInfo != null) {
						mUserContentInfoService.UpdateFileSizeScore(parVisitorId, lFileSize);
					} else {

						mUserContentInfoService.addNewFileSize(parVisitorId, lFileSize);
						mUserContentInfoService.UpdateFileSizeScore(parVisitorId, lFileSize);
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
		List<UserContentInfo> lGameSubTagsSCore = mUserContentInfoService.getGamesSubTagsScore(parVisitorId);
		Map<String, Object> lGameInfoAndSubTagsmap = new HashMap<String, Object>();
		List lSubTagsList = mUserContentInfoService.gamesSubTagsRecommendationByVisitorId(parVisitorId);
		for (Iterator iterator = lSubTagsList.iterator(); iterator.hasNext();) {
			String lsubTagName = (String) iterator.next();

			List<GameInfo> lGameInfo = mGameInfoService.getGameNameBySubTags(lsubTagName);
			lGameInfoList.add(lGameInfo);

/*			for (int k = 0; k < lGameInfo.size(); k++) {
				String lContetnName = lGameInfo.get(k).getmContentName();
				System.out.println("Object-->" + lContetnName);
				// lGameInfoList.add(lGameInfo);
				for (int i = 0; i < lGameInfoList.size(); i++) {

					List<GameInfo> game = (List<GameInfo>) lGameInfoList.get(i);
					String lContentNameInList = game.get(i).getmContentName();
					System.out.println("List-->" + lContentNameInList);

					if (lContetnName.equals(lContentNameInList)) {
						lFlag = 1;

					} else {
						continue;
					}
					if (lFlag != 1) {
						System.out.println("Added");
						lGameInfoList.add(lGameInfo);
					}
				}

			}*/
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
		List<UserContentInfo> lGameFileSizeScore = mUserContentInfoService
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
