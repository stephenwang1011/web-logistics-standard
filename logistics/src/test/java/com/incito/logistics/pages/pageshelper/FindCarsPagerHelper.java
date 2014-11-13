package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.util.SeleniumUtil;

public class FindCarsPagerHelper {
	public static Logger logger = Logger.getLogger(FindCarsPagerHelper.class.getName());

	// 页面上某个重要元素显示出来
	public static void waitFindGoodsPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("开始检查[找车源]页面元素");
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_INPUT_FROM);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_INPUT_TO);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_INPUT_STARTCARLEN);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_INPUT_ENDCARLEN);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_CREDIT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_CARLEN);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_WEIGHT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_ADVSEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_DEFAULT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_CREDIT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_CARLEN);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_WEIGHT);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_BUTTON_VOLUME);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_TAB_PUBLIC);
		seleniumUtil.waitForElementToLoad(timeOut, FindCarsPage.FCP_TAB_FAV);
		logger.info("[找车源]页面元素，检查完毕！");
	}

	/** 检查文本是不是正确 */
	public static void checkFindGoodsPageText(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("开始检查[找车源]文本");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_TAB_PUBLIC).getText().trim(), "公共车源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_TAB_FAV).getText().trim(), "我的收藏");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_SEARCH).getText().trim(), "搜索");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_ADVSEARCH).getText().trim(), "高级搜索");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_DEFAULT).getText().trim(), "默认排序");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_CREDIT).getText().trim(), "信用等级");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_CARLEN).getText().trim(), "车长");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_WEIGHT).getText().trim(), "载重");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_VOLUME).getText().trim(), "车厢容积");
		logger.info("[找车源]页面文本，检查完毕");
	}

	/** 在找车源输入相关信息以便查询 */
	public static void typeCarsInfo(SeleniumUtil seleniumUtil, String... info) {
		// 车辆出发地
		if (info[0].toString() != "") {
			String jsFrom = "document.getElementsByName('carcity')[0].setAttribute('value','" + info[0].toString() + "');";
			seleniumUtil.executeJS(jsFrom);
		}
		// 车辆目的地
		if (info[1].toString() != "") {
			String jsTo = "document.getElementsByName('targetcity')[0].setAttribute('value','" + info[1].toString() + "');";
			seleniumUtil.executeJS(jsTo);
		}
		//车长 -开始
		if (info[2].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_STARTCARLEN),info[2].toString() );
		}
		//车长 - 结束
		if (info[3].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_ENDCARLEN),info[3].toString() );
		}
		
		// 点击高级搜索
		if(info[4].toString()!=""||info[5].toString()!=""||info[6].toString()!=""||info[7].toString()!=""||info[8].toString()!=""){
		seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_ADVSEARCH));

		//车型
		if (info[4].toString() != "") {
			String carType = "document.getElementsByName('cartype')[0].setAttribute('value','" + info[4].toString() + "');";
			seleniumUtil.executeJS(carType);
		}
		//载重 - 开始
		if (info[5].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_STARTWEIGHT),info[5].toString() );
		}
		//载重 - 结束
		if (info[6].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_ENDWEIGHT),info[6].toString() );
		}
		//容积 - 开始
		if (info[7].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_STARTVOLUME),info[7].toString() );
		}
		//容积 - 开始
		if (info[8].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(FindCarsPage.FCP_INPUT_ENDVOLUME),info[8].toString() );
		}
		}
		// 点击搜索
		seleniumUtil.click(seleniumUtil.findElementBy(FindCarsPage.FCP_BUTTON_SEARCH));
	}
	
	/**检查查找出来的车源的  车辆当前城市也就是出发地*/
	public static void checkCurrentCarLocation(SeleniumUtil seleniumUtil,String carFrom){
		seleniumUtil.pause(800);
		try{	
		if(seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")){
			logger.warn("No datas displayed with thes fitters");
			return;
		}}catch(Exception e){
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_SPAN_LOCATOR).size();
			for (int i = 0; i < size; i++) {
				seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(FindCarsPage.FCP_SPAN_LOCATOR).get(i).getText().trim(), carFrom);
			}
			
		}

	}
	
	/**检测车源中的车长是不是符合条件*/
	public static void  checkCarLength(SeleniumUtil seleniumUtil,String ...lenInfos){
		
		seleniumUtil.pause(800);
		try{	
		if(seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")){
			logger.warn("No datas displayed with thes fitters");
			return;
		}}catch(Exception e){
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
	
			for (int i = 0; i < size; i++) {
				String secondInfo =  seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				double autualCarLen = Double.parseDouble(secondInfos[2].substring(3, secondInfos[2].length()-1)); //取得车长
				//开始车长空 结束车长不空
				if(lenInfos[0].equals("")&&lenInfos[1]!=""){
					try {
						Assert.assertTrue(autualCarLen <= Double.parseDouble(lenInfos[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car length in web page is [" + autualCarLen + "] and is bigger than input length num [" + lenInfos[1] + "] m");
						Assert.fail("Found the car length in web page is [" + autualCarLen + "] and is bigger than input length num [" + lenInfos[1] + "] m");
					}
					logger.info("The car length of the " + (i + 1) + "th goods info is [" + autualCarLen + "] m, smaller than "+lenInfos[1]+ " m - Passed");
				}
				//开始车长不为空 结束车长空
				if(lenInfos[0]!=""&&lenInfos[1].equals("")){
					try {
						Assert.assertTrue(autualCarLen >= Double.parseDouble(lenInfos[0]));
					} catch (AssertionError e1) {
						logger.error("Found the car length in web page is [" + autualCarLen + "] and is smaller than input lengthnum [" + lenInfos[0] + "] m");
						Assert.fail("Found the car length in web page is [" + autualCarLen + "] and is smaller than input length num [" + lenInfos[0] + "] m");
					}
					logger.info("The car length of the " + (i + 1) + "th cars info is [" + autualCarLen + "] m,bigger than "+lenInfos[0] +" m - Passed");
				}
				//都不为空
				if(lenInfos[0]!=""&&lenInfos[1]!=""){
					try {
						Assert.assertTrue(autualCarLen >= Double.parseDouble(lenInfos[0]) && autualCarLen <= Double.parseDouble(lenInfos[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car length in web page is [" + autualCarLen + "] and is not in the  input car length num [" + lenInfos[0] + "] and [" + lenInfos[1] + "] ");
						Assert.fail("Found the car length in web page is [" + autualCarLen + "] and is not in the  input car length num [" + lenInfos[0] + "] and [" + lenInfos[1] + "] ");
					}
					logger.info("The car length of the " + (i + 1) + "th cars info is [" + autualCarLen + "] m ,between "+lenInfos[0] +"and "+lenInfos[1]+" m - Passed");
				}
		
			}
			
		}
		
	}
	
	/**检查车型*/
	public static void checkCarType(SeleniumUtil seleniumUtil,String ...carTypes){
		seleniumUtil.pause(800);
		try{	
		if(seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")){
			logger.warn("No datas displayed with thes fitters");
			return;
		}}catch(Exception e){
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
	
			for (int i = 0; i < size; i++) {
				String secondInfo =  seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				String acutalCarType = secondInfos[1];
				seleniumUtil.isContains(carTypes[0],acutalCarType);
		
		
			}
			
		}
		
		
	}
	
	/**检查车源中的吨位*/
	public static void checkCarWeight(SeleniumUtil seleniumUtil,String ...carWeights){
		seleniumUtil.pause(800);
		try{	
		if(seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")){
			logger.warn("No datas displayed with thes fitters");
			return;
		}}catch(Exception e){
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
	
			for (int i = 0; i < size; i++) {
				String secondInfo =  seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				double autualCarWeight = Double.parseDouble(secondInfos[3].substring(3, secondInfos[3].length()-1)); //取得车重
				//开始车长空 结束车长不空
				if(carWeights[0].equals("")&&carWeights[1]!=""){
					try {
						Assert.assertTrue(autualCarWeight <= Double.parseDouble(carWeights[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car weight in web page is [" + autualCarWeight + "] and is bigger than input weight num [" + carWeights[1] + "] T");
						Assert.fail("Found the car weight in web page is [" + autualCarWeight + "] and is bigger than input weight num [" + carWeights[1] + "] T");
					}
					logger.info("The car weight of the " + (i + 1) + "th goods info is [" + autualCarWeight + "] T, smaller than "+carWeights[1]+ " T - Passed");
				}
				//开始车长不为空 结束车长空
				if(carWeights[0]!=""&&carWeights[1].equals("")){
					try {
						Assert.assertTrue(autualCarWeight >= Double.parseDouble(carWeights[0]));
					} catch (AssertionError e1) {
						logger.error("Found the car weight in web page is [" + autualCarWeight + "] and is smaller than input weight num [" + carWeights[0] + "] T");
						Assert.fail("Found the car weight in web page is [" + autualCarWeight + "] and is smaller than input weight num [" + carWeights[0] + "] T");
					}
					logger.info("The car weight of the " + (i + 1) + "th cars info is [" + autualCarWeight + "] T,bigger than "+carWeights[0] +" T - Passed");
				}
				//都不为空
				if(carWeights[0]!=""&&carWeights[1]!=""){
					try {
						Assert.assertTrue(autualCarWeight >= Double.parseDouble(carWeights[0]) && autualCarWeight <= Double.parseDouble(carWeights[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car weight in web page is [" + autualCarWeight + "] and is not in the  input car weight num [" + carWeights[0] + "] and [" + carWeights[1] + "] ");
						Assert.fail("Found the car weight in web page is [" + autualCarWeight + "] and is not in the  input car weight num [" + carWeights[0] + "] and [" + carWeights[1] + "] ");
					}
					logger.info("The car weight of the " + (i + 1) + "th cars info is [" + autualCarWeight + "] T ,between "+carWeights[0] +"and "+carWeights[1]+" T - Passed");
				}
		
			}
			
		}
		
	}
	/**检查体积的方法*/
	public static void checkCarVolume(SeleniumUtil seleniumUtil,String ...carVolumes){
		seleniumUtil.pause(800);
		try{	
		if(seleniumUtil.findElementBy(FindCarsPage.FCP_DIV_MENTION).getText().trim().equals("没有搜索到相应的数据")){
			logger.warn("No datas displayed with thes fitters");
			return;
		}}catch(Exception e){
			logger.info("Found the cars info");
			int size = seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).size();
	
			for (int i = 0; i < size; i++) {
				String secondInfo =  seleniumUtil.findElementsBy(FindCarsPage.FCP_DIV_CARINFO2).get(i).getText();
				String secondInfos[] = secondInfo.split("，");
				double autualCarVolume = Double.parseDouble(secondInfos[4].substring(5, secondInfos[4].length()-1)); //取得车容积
				//开始车长空 结束车长不空
				if(carVolumes[0].equals("")&&carVolumes[1]!=""){
					try {
						Assert.assertTrue(autualCarVolume <= Double.parseDouble(carVolumes[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car volume in web page is [" + autualCarVolume + "] and is bigger than input volume num [" + carVolumes[1] + "] L");
						Assert.fail("Found the car volume in web page is [" + autualCarVolume + "] and is bigger than input volume num [" + carVolumes[1] + "] L");
					}
					logger.info("The car volume of the " + (i + 1) + "th goods info is [" + autualCarVolume + "] L, smaller than "+carVolumes[1]+ " L - Passed");
				}
				//开始车长不为空 结束车长空
				if(carVolumes[0]!=""&&carVolumes[1].equals("")){
					try {
						Assert.assertTrue(autualCarVolume >= Double.parseDouble(carVolumes[0]));
					} catch (AssertionError e1) {
						logger.error("Found the car volume in web page is [" + autualCarVolume + "] and is smaller than input volume num [" + carVolumes[0] + "] L");
						Assert.fail("Found the car volume in web page is [" + autualCarVolume + "] and is smaller than input volume num [" + carVolumes[0] + "] L");
					}
					logger.info("The car volume of the " + (i + 1) + "th cars info is [" + autualCarVolume + "] T,bigger than "+carVolumes[0] +" L - Passed");
				}
				//都不为空
				if(carVolumes[0]!=""&&carVolumes[1]!=""){
					try {
						Assert.assertTrue(autualCarVolume >= Double.parseDouble(carVolumes[0]) && autualCarVolume <= Double.parseDouble(carVolumes[1]));
					} catch (AssertionError e1) {
						logger.error("Found the car volume in web page is [" + autualCarVolume + "] and is not in the  input car volume num [" + carVolumes[0] + "] and [" + carVolumes[1] + "] ");
						Assert.fail("Found the car volume in web page is [" + autualCarVolume + "] and is not in the  input car volume num [" + carVolumes[0] + "] and [" + carVolumes[1] + "] ");
					}
					logger.info("The car weight of the " + (i + 1) + "th cars info is [" + autualCarVolume + "] L ,between "+carVolumes[0] +"and "+carVolumes[1]+" L - Passed");
				}
		
			}
			
		}
		
		
		
	}
	
}
