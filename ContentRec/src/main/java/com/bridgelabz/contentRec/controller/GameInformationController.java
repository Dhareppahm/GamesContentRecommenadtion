/*
* @Author:Dhareppa Metri
* File:GameInfoRestApiCallController.java
* Purpose:Controller class for to fetch game information through REST API call.
**/
package com.bridgelabz.contentRec.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.contentRec.model.GameInfo;
import com.bridgelabz.contentRec.services.GameInfoService;

@Controller
public class GameInformationController {
	String mGbDeviceId;
	String mGbAppVersionCode;
	String mUrlString;
	Logger mLogger = Logger.getLogger("GAMEINFORMATIONCONTROLLER");
	@Autowired
	private GameInfoService mGameInfoService;

	/**
	 * This method is used to display game information form
	 * 
	 * @return ModelAndView ,DisplayGameInfo view
	 */
	@RequestMapping(value = "/displayGameInfo", method = RequestMethod.GET)
	public ModelAndView dispalyGameInfo() {
		return new ModelAndView("DisplayGameInfo");
	}// End of dispalyGameInfo method

	/**
	 * This method is used to display game information form
	 * 
	 * @return ModelAndView,FetchAndSaveGameInfo view
	 */
	@RequestMapping(value = "/fetchAndSaveGameInfo", method = RequestMethod.GET)
	public ModelAndView fetchAndSaveGameInfo() {
		return new ModelAndView("FetchAndSaveGameInfo");
	}// End of fetchAndSaveGameInfo method

	/**
	 * This method is used to transfer game information view part
	 * 
	 * @return ModelAndView,GameInformation view
	 */
	@RequestMapping(value = "/displayGameInfo", method = RequestMethod.POST)
	public ModelAndView dispalyGameData(@RequestParam("contentId") String parContId) {
		List<GameInfo> lGameInfo = mGameInfoService.getGameInfoByContentId(parContId);
		return new ModelAndView("GameInformation", "gameInfo", lGameInfo);
	}// End of dispalyGameData method

	/**
	 * This method is used to fetch game information from the rest call
	 * 
	 * @param String,
	 *            is the first parameter for this method contains content Id
	 * @return ModelAndView,FetchAndSaveGameInfo view
	 */
	@RequestMapping(value = "/fetchAndSaveGameInfo", method = RequestMethod.POST)
	public ModelAndView fetchAndSaveGameData(@RequestParam("contentId") String parContId) {

		String lFileName = "RestCalInformation.properties";
		JSONParser lParser = new JSONParser();
		Properties lProp = new Properties();
		InputStream lInput = null;
		lInput = GameInformationController.class.getClassLoader().getResourceAsStream(lFileName);
		try {

			if (lInput == null) {
				System.out.println("Sorry, unable to find " + lFileName);
				return null;

			} // End of if

			lProp.load(lInput);
			mGbDeviceId = lProp.getProperty("gbDeviceId");
			mGbAppVersionCode = lProp.getProperty("gbAppVersionCode");
			mUrlString = lProp.getProperty("restCalURL");
			System.out.println(mGbDeviceId);
			System.out.println(mGbAppVersionCode);
			System.out.println(mUrlString);

		} // End of try
		catch (IOException e1) {
			e1.printStackTrace();
		} // End of catch
		finally {
			if (lInput != null) {
				try {
					lInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				} // End of catch
			} // End of if
		} // End of finally

		GameInfo lGameInfo = new GameInfo();
		try {
			String uurl = "http://wap.mauj.com/BETAAPI/GAMESBOND_V2/?method=contentDetail&params={%22contentid%22:"
					+ parContId + ",%22additionalParam%22:{%22reviews%22:{%22start%22:0,%22limit%22:10}}}";
			URL lUrl = new URL(uurl);
			HttpURLConnection lConn = (HttpURLConnection) lUrl.openConnection();
			mLogger.info("Method : fetchAndSaveGameData " + uurl);
			lConn.setRequestMethod("GET");
			lConn.setRequestProperty("Accept", "application/json");
			System.out.println(parContId);
			lConn.setRequestProperty("GB_DEVICE_ID", mGbDeviceId);
			lConn.setRequestProperty("GB_APP_VERSION_CODE", mGbAppVersionCode);
			lConn.setRequestProperty("User-Agent", "Mozilla/5.0");

			if (lConn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + lConn.getResponseCode());
			} // End of if

			BufferedReader lBufferReader = new BufferedReader(new InputStreamReader((lConn.getInputStream())));

			Object lObject = lParser.parse(lBufferReader);
			JSONObject lJsonObject = (JSONObject) lObject;
			JSONObject lItemObj = (JSONObject) lJsonObject.get("data");

			Object lContentIdObj = lItemObj.get("content_id");
			long lContentId = (long) lContentIdObj;
			lGameInfo.setmContentId(String.valueOf(lContentId));

			Object lContentNameObj = lItemObj.get("content_name");
			String lContentName = (String) lContentNameObj;
			lGameInfo.setmContentName(lContentName);

			Object lContentTypeIdObj = lItemObj.get("content_type_id");
			long lContentTypeId = (long) lContentTypeIdObj;
			lGameInfo.setmContentTypeId(String.valueOf(lContentTypeId));

			Object lGroupIdObj = lItemObj.get("group_id");
			String lGroupId = (String) lGroupIdObj;
			lGameInfo.setmGroupId(lGroupId);

			Object lCategoryIdObj = lItemObj.get("category_id");
			String lCategoryId = (String) lCategoryIdObj;
			lGameInfo.setmCategoryId(lCategoryId);

			Object lCategoryNameObj = lItemObj.get("category_name");
			String lCategoryName = (String) lCategoryNameObj;
			lGameInfo.setmCategoryName(lCategoryName);

			Object lDownloadsObj = lItemObj.get("downloads");
			String lDownloads = (String) lDownloadsObj;
			lGameInfo.setmTotalDownloads(lDownloads);

			Object lFileSizeObj = lItemObj.get("file_size");
			String lFileSize = (String) lFileSizeObj;
			lGameInfo.setmFileSize(lFileSize);

			Object lManifestPackageNameObj = lItemObj.get("manifest_package_name");
			String lManifestPackageName = (String) lManifestPackageNameObj;
			lGameInfo.setmManifestPackageName(lManifestPackageName);

			Object lContentDownloadUrlObj = lItemObj.get("content_download_url");
			String lContentDownloadUrl = (String) lContentDownloadUrlObj;
			lGameInfo.setmContentDownloadUrl(lContentDownloadUrl);

			Object lMetaTagsObj = lItemObj.get("meta_tags");
			String lMetaTags = (String) lMetaTagsObj;
			lGameInfo.setmMetaTags(lMetaTags);

			Object lContentRatingObj = lItemObj.get("content_rating");
			String lContentRating = (String.valueOf(lContentRatingObj));
			lGameInfo.setmContentRating(lContentRating);

			Object lContentReviewTotalObj = lItemObj.get("content_review_total");
			long lContentReviewTotal = (long) lContentReviewTotalObj;
			lGameInfo.setmContentReviewTotal(String.valueOf(lContentReviewTotal));

			Object lContentThumbnailUrlObj = lItemObj.get("content_thumbnail_url");
			String lContentThumbnailUrl = (String) lContentThumbnailUrlObj;
			lGameInfo.setmContentThumbnailUrl(lContentThumbnailUrl);
			mGameInfoService.saveGameInfo(lGameInfo);
			lConn.disconnect();

		} // End of try

		catch (MalformedURLException e) {

			e.printStackTrace();
		} // End of catch
		catch (IOException e) {

			e.printStackTrace();
		} // End of catch
		catch (ParseException e) {

			e.printStackTrace();
		} // End of catch

		return new ModelAndView("FetchAndSaveGameInfo");
	}// End of fetchAndSaveGameData method

}// End of GameInformationController class
