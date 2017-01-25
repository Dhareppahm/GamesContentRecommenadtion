/*
* @Author:Dhareppa Metri
* File:VisitorsInfoController.java
* Purpose:Controller class for to store game visitors information.
**/
package com.bridgelabz.contentRec.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bridgelabz.contentRec.model.VisitorsInfo;
import com.bridgelabz.contentRec.services.VisitorsInfoService;

@Controller
public class VisitorsInfoController {
	@Autowired
	VisitorsInfoService mVisitorsInfoService;

	@RequestMapping(value = "/uploadCSVToDb", method = RequestMethod.GET)
	public String dispalyGameInfo() {
		return "UploadCSV";
	}

	@RequestMapping(value = "/getDataFromCSV", method = RequestMethod.GET)
	public String getDataFromCSV() {
		FileReader lFileReader;
		String[] lData;
		String lTemp = "visitor_id";
		int i;

		try {
			lFileReader = new FileReader("/home/bridgeit/contentDb.csv");
			BufferedReader lBufferedReader = new BufferedReader(lFileReader);
			String lNextRecord;
			lNextRecord = lBufferedReader.readLine();
			lData = lNextRecord.split("\\,");
			for (i = 0; i < lData.length; i++) {
				System.out.print(i + " " + lData[i] + " ");
			}
			while (lNextRecord != null) {
				lData = lNextRecord.split("\\,");
				System.out.println(lNextRecord);
				for (i = 0; i < lData.length; i++) {
					lData[i] = lData[i].replace("\"", "");
				}

				if (!(lData[0].equals(lTemp))) {
					VisitorsInfo vi = new VisitorsInfo();
					vi.setmVisitorId(lData[0]);
					vi.setmContentId(lData[1]);
					vi.setmContentName(lData[2]);
					vi.setmCategoryName(lData[3]);
					vi.setmView(lData[4]);
					vi.setmDownload(lData[5]);
					mVisitorsInfoService.addVisitors(vi);
				}
				lNextRecord = lBufferedReader.readLine();
			}

			lBufferedReader.close();
			lFileReader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return "GetUserHistory";
	}
}
