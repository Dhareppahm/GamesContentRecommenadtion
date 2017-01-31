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
public class GameInfoRestApiCallController {
	String mGbDeviceId;
	String mGbAppVersionCode;
	String mUrlString;
	Logger mlogger = Logger.getLogger("GAMEINFO");
	@Autowired
	private GameInfoService mGameInfoService;

	@RequestMapping(value = "/displayGameInfo", method = RequestMethod.GET)
	public String dispalyGameInfo() {
		return "DisplayGameInfo";
	}

	@RequestMapping(value = "/fetchAndSaveGameInfo", method = RequestMethod.GET)
	public String fetchAndSaveGameInfo() {
		return "FetchAndSaveGameInfo";
	}

	@RequestMapping(value = "/displayGameInfo", method = RequestMethod.POST)
	public ModelAndView dispalyGameData(@RequestParam("contentId") String parContId) {
		List<GameInfo> lGameInfo = mGameInfoService.dispalyGameInfoByContentId(parContId);
		return new ModelAndView("GameInformation", "gameInfo", lGameInfo);
	}

	@RequestMapping(value = "/fetchAndSaveGameInfo", method = RequestMethod.POST)
	public String fetchAndSaveGameData(@RequestParam("contentId") String parContId) {

		String lFileName = "RestCalInformation.properties";
		JSONParser lParser = new JSONParser();
		Properties lProp = new Properties();
		InputStream lInput = null;
		lInput = GameInfoRestApiCallController.class.getClassLoader().getResourceAsStream(lFileName);
		try {

			if (lInput == null) {
				System.out.println("Sorry, unable to find " + lFileName);
				return null;

			}

			lProp.load(lInput);
			mGbDeviceId = lProp.getProperty("gbDeviceId");
			mGbAppVersionCode = lProp.getProperty("gbAppVersionCode");
			mUrlString = lProp.getProperty("restCalURL");
			System.out.println(mGbDeviceId);
			System.out.println(mGbAppVersionCode);

			System.out.println(mUrlString);

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

		GameInfo lGameInfo = new GameInfo();
		/* REST call to fetch JSON properties */
		try {
			URL lUrl = new URL(mUrlString);
			HttpURLConnection conn = (HttpURLConnection) lUrl.openConnection();

			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			System.out.println(parContId);
			conn.setRequestProperty("GB_DEVICE_ID", mGbDeviceId);
			conn.setRequestProperty("GB_APP_VERSION_CODE", mGbAppVersionCode);
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			Object lOb = lParser.parse(br);
			JSONObject lObject = (JSONObject) lOb;
			JSONObject lItemObj = (JSONObject) lObject.get("data");

			Object contentIdObj = lItemObj.get("content_id");
			long contentId = (long) contentIdObj;
			lGameInfo.setmContentId(String.valueOf(contentId));

			Object contentNameObj = lItemObj.get("content_name");
			String contentName = (String) contentNameObj;
			lGameInfo.setmContentName(contentName);

			Object contentTypeIdObj = lItemObj.get("content_type_id");
			long contentTypeId = (long) contentTypeIdObj;
			lGameInfo.setmContentTypeId(String.valueOf(contentTypeId));

			Object groupIdObj = lItemObj.get("group_id");
			String groupId = (String) groupIdObj;
			lGameInfo.setmGroupId(groupId);

			Object categoryIdObj = lItemObj.get("category_id");
			String categoryId = (String) categoryIdObj;
			lGameInfo.setmCategoryId(categoryId);

			Object categoryNameObj = lItemObj.get("category_name");
			String categoryName = (String) categoryNameObj;
			lGameInfo.setmCategoryName(categoryName);

			Object downloadsObj = lItemObj.get("downloads");
			String downloads = (String) downloadsObj;
			lGameInfo.setmTotalDownloads(downloads);

			Object fileSizeObj = lItemObj.get("file_size");
			String fileSize = (String) fileSizeObj;
			lGameInfo.setmFileSize(fileSize);

			Object manifestPackageNameObj = lItemObj.get("manifest_package_name");
			String manifestPackageName = (String) manifestPackageNameObj;
			lGameInfo.setmManifestPackageName(manifestPackageName);

			Object contentDownloadUrlObj = lItemObj.get("content_download_url");
			String contentDownloadUrl = (String) contentDownloadUrlObj;
			lGameInfo.setmContentDownloadUrl(contentDownloadUrl);

			Object metaTagsObj = lItemObj.get("meta_tags");
			String metaTags = (String) metaTagsObj;
			lGameInfo.setmMetaTags(metaTags);

			Object contentRatingObj = lItemObj.get("content_rating");
			String contentRating = (String.valueOf(contentRatingObj));
			lGameInfo.setmContentRating(contentRating);

			Object contentReviewTotalObj = lItemObj.get("content_review_total");
			long contentReviewTotal = (long) contentReviewTotalObj;
			lGameInfo.setmContentReviewTotal(String.valueOf(contentReviewTotal));
			
			Object contentThumbnailUrlObj=lItemObj.get("content_thumbnail_url");
			String contentThumbnailUrl=(String)contentThumbnailUrlObj;
			lGameInfo.setmContentThumbnailUrl(contentThumbnailUrl);
			mGameInfoService.saveGameInfo(lGameInfo);

			conn.disconnect();

		}

		catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return "FetchAndSaveGameInfo";
	}

}
