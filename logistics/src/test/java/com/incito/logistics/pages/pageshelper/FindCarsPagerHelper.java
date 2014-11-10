package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.util.SeleniumUtil;

public class FindCarsPagerHelper {
	public static Logger logger = Logger.getLogger(FindCarsPagerHelper.class.getName());
	// 等待页面上某个重要元素显示出来
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
	/**检查文本是不是正确*/
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

}
