package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * 
 * @author xy-incito-wk
 * @description 查找货源页面帮助类
 */
public class FindGoodsPageHelper {
	public static Logger logger = Logger.getLogger(AddUserInfoPagerHelper.class.getName());
	/** 等待找货源页面元素加载出来 */
	public static void waitAddUserInfoPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking addUserInfo page elements");
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_BUTTON_PUBLICDOODS);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_FROMCITY);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_TARGETCITY);

		logger.info("Check addUserInfo page elements completed");

	}
}
