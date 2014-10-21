package com.incito.logistics.pages.pageshelper;

import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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
	public static void waitFindGoodsPageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking FindGoods page elements");
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_BUTTON_PUBLICDOODS);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_FROMCITY);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_TARGETCITY);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_STARTCARLONG);
		seleniumUtil.waitForElementToLoad(timeOut, FindGoodsPage.FGP_INPUT_ENDTCARLONG);
		logger.info("Check FindGoods page elements completed");

	}

	/**
	 * 在查找货源上输入搜索条件
	 * 
	 * @param seleniumUtil
	 * @param goodsType
	 * @param goodsDate
	 * @param info
	 */
	public static void typeFindGoodsInfo(SeleniumUtil seleniumUtil, String... info) {
		// 填充发货地
		String jsFrom = "document.getElementsByName('localcity')[0].setAttribute('value','" + info[0].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(jsFrom);
		// 填充收货地
		String jsTo = "document.getElementsByName('targetcity')[0].setAttribute('value','" + info[1].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(jsTo);
		// 填写最低车长
		seleniumUtil.type(seleniumUtil.findElementBy(FindGoodsPage.FGP_INPUT_STARTCARLONG), info[2].toString());
		// 填写最长车长
		seleniumUtil.type(seleniumUtil.findElementBy(FindGoodsPage.FGP_INPUT_ENDTCARLONG), info[3].toString());
	}

	/** 从找货源进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));

	}

	/** 检查搜索界面的是否包含发货地或者收货地搜索结果 */
	public static void checkFindGoodsPrompt_Location(SeleniumUtil seleniumUtil, Map<String, String> data) {
		logger.info("Start checking checkFindGoodsPrompt_Location page text");
		seleniumUtil.isContains(seleniumUtil.findElementsBy(FindGoodsPage.FGP_DISPLAY_SEARCH).get(0).getAttribute("title"), data.get("FGP_INPUT_GOODSORIGINALCITY"));
		logger.info("Check checkFindGoodsPrompt_Location page text completed");
	}

	/** 检查搜索界面的是否包含搜索结果 */
	public static void checkFindGoodsPrompt_CarLong(SeleniumUtil seleniumUtil, Map<String, String> data) {
		logger.info("Start checking checkFindGoodsPrompt_CarLong page text");
		String info = seleniumUtil.findElementsBy(FindGoodsPage.FGP_SECOND_INFO).get(0).getText().trim();

		StringTokenizer info2 = new StringTokenizer(info, "，");
		String info3 = null;
		while (info2.hasMoreTokens()) {
			String temp = info2.nextToken();
			if (temp.contains("车辆要求")) {
				info3 = temp.trim();
			}
		}
		StringTokenizer info4 = new StringTokenizer(info3, "：");
		String info5 = null;
		while (info4.hasMoreTokens()) {
			info5 = info4.nextToken().trim();
		}
		String need = info5.substring(0, info5.length() - 1);

		int carlong = Integer.parseInt(need);
		int startcarlong = Integer.parseInt(data.get("FGP_INPUT_STARTCARLONG"));
		if (startcarlong < carlong) {
			System.out.println("搜索的车长满足最小要求");
		}
		logger.info("Check checkFindGoodsPrompt_CarLong page text completed");
	}

}
