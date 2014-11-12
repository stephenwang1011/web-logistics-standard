package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;

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
	
}
