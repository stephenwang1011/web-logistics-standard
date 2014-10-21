package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;

import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 我的货源页面帮助类
 * */
public class MyGoodsPageHelper {
	public static Logger logger = Logger.getLogger(MyGoodsPageHelper.class.getName());

	/** 等待首页上元素显示出来 */
	public static void waitMyGoodsPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {

		logger.info("Start checking my goods page elements");
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_BUTTON_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_BUTTON_ADSEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_GOODSNO);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_ORIGINALCITY);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_TARGETCITY);
		seleniumUtil.click(seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_ADSEARCH));
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_RADIOBOX_GOODSTYPE);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_STARTDATE);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_ENDDATE);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_INPUT_GOODSNAME);
		seleniumUtil.waitForElementToLoad(timeOut, MyGoodsPage.MGP_SELECT_GOODSUNIT);

		logger.info("Check home my goods page elements completed");

	}
}