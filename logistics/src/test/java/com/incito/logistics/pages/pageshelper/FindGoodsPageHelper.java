package com.incito.logistics.pages.pageshelper;

import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

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

	/** 检查货源的第一行的数据：发货地和收货地 */
	public static void checkGoodsAddress(SeleniumUtil seleniumUtil, By by, String... goodsAdd) {
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}
		String address = seleniumUtil.findElementBy(by).findElement(By.xpath("//div[1]/div[1]/div[1]/span[1]")).getAttribute("title");
		address = address.replaceAll(" ", "");
		String add[] = address.split("至");
		String original = add[0], targetcity = add[1];
		if (goodsAdd[0].equals("") == false) {
			seleniumUtil.isContains(original, goodsAdd[0]);
		}
		if (goodsAdd[1].equals("") == false) {
			seleniumUtil.isContains(targetcity, goodsAdd[1]);
		}
	}

	/** 检查货源信息的第二行信息:车长 */
	public static void checkCarLength(SeleniumUtil seleniumUtil, By by, String... secondInfos) {
		// 这个items指的是查询出来有多少条货源
		int items = seleniumUtil.findElementsBy(by).size();
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			// 如果按照筛选条件查不到数据的时候给一个提示并退出此方法
			logger.warn("根据您的筛选条件，无法查找出数据！");
			return;
		}

		for (int i = 0; i < items; i++) {// 循环每个货源-只对针对当前页面的
			double carLong = 0; // 车长
			String second = seleniumUtil.findElementsBy(By.cssSelector("div.goods-info-row2")).get(i).getText(); // 取得第二行的货源信息
			String[] secondArray = second.split("，");
			for (String temp : secondArray) {
				if (temp.trim().contains("车辆要求")) {
					String[] temp1 = temp.split("：");
					carLong = Double.parseDouble(temp1[1].replaceAll("米", ""));// 取得车长

					if (secondInfos[1].equals("") && secondInfos[0] != "") {
						try {
							Assert.assertTrue(carLong >= Double.parseDouble(secondInfos[0]));
						} catch (AssertionError e) {
							logger.error("Found the length of car in web page is [" + carLong + "] and is less than input length num [" + secondInfos[0] + "] T");
							Assert.fail("Found the weight of car in web page is [" + carLong + "] and is less than input length num [" + secondInfos[0] + "] T");
						}
						logger.info("The length of the " + (i + 1) + "the goods'car info is [" + carLong + "] T");
					}

					if (secondInfos[0].equals("") && secondInfos[1] != "") {
						try {
							Assert.assertTrue(carLong <= Double.parseDouble(secondInfos[1]));
						} catch (AssertionError e) {
							logger.error("Found the length of car in web page is [" + carLong + "] and is longer than input length num [" + secondInfos[1] + "] T");
							Assert.fail("Found the weight in web page is [" + carLong + "] and is longer than input length num [" + secondInfos[1] + "] T");
						}
						logger.info("The length of the " + (i + 1) + "the goods'car info is [" + carLong + "] T");
					}

					if (secondInfos[0] != "" && secondInfos[1] != "") {
						try {
							Assert.assertTrue(Double.parseDouble(secondInfos[1]) <= carLong && carLong >= Double.parseDouble(secondInfos[1]));
						} catch (AssertionError e) {
							logger.error("Found the length of car in web page is [" + carLong + "] and is not in input length num [" + secondInfos[0] + "] and [" + secondInfos[1] + "] T");
							Assert.fail("Found the weight in web page is [" + carLong + "] and is not in input length num [" + secondInfos[0] + "] and [" + secondInfos[1] + "] T");
						}
						logger.info("The length of the " + (i + 1) + "the goods'car info is [" + carLong + "] T");
					}
				}
			}
		}

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

		Float carlong = Float.valueOf(need);
		Float startcarlong = Float.valueOf(data.get("FGP_INPUT_STARTCARLONG"));
		if (startcarlong <= carlong) {
			System.out.println("搜索的车长满足最小要求");
		}
		logger.info("Check checkFindGoodsPrompt_CarLong page text completed");
	}

}
