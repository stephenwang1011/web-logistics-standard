package com.incito.logistics.pages.pageshelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 我的货源页面帮助类
 * */
public class MyGoodsPageHelper {
	public static Logger logger = Logger.getLogger(MyGoodsPageHelper.class.getName());

	/** 等待页面上元素显示出来 */
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

	/** 在找货源界面输入相关货源信息以便查询 */
	public static void typeGoodsInfo(SeleniumUtil seleniumUtil, String... info) {
		// 货源编号
		seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_GOODSNO), info[0].toString());
		// 填充发货地
		String jsFrom = "document.getElementsByName('localcity')[0].setAttribute('value','" + info[1].toString() + "');";
		seleniumUtil.executeJS(jsFrom);
		// 填充收货地
		String jsTo = "document.getElementsByName('targetcity')[0].setAttribute('value','" + info[2].toString() + "');";
		seleniumUtil.executeJS(jsTo);
		// 点击高级搜索
		seleniumUtil.click(seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_ADSEARCH));
		// 货物名称
		String goodsName = "document.getElementsByName('goodsnames')[0].setAttribute('value','" + info[3].toString() + "');";
		seleniumUtil.executeJS(goodsName);
		// 体积还是重量
		seleniumUtil.selectByText(MyGoodsPage.MGP_SELECT_GOODSUNIT, info[4].toString());
		if (info[4].toString().equals("体积")) {
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTVOLUME), info[5].toString());
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_ENDVOLUME), info[6].toString());
		} else if (info[4].toString().equals("重量")) {
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTWEIGHT), info[5].toString());
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_ENDWEIGHT), info[6].toString());

		}
		// 开始时间
		String startDate = "document.getElementsByName('startgoodstime')[0].setAttribute('value','" + info[7].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(startDate);
		// 结束时间
		String endDate = "document.getElementsByName('endgoodstime')[0].setAttribute('value','" + info[8].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(endDate);

		// 点击搜索
		seleniumUtil.click(seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_SEARCH));
	}

	/** 从我的货源界面点击相关按钮 */
	public static void enterPage(SeleniumUtil seleniumUtil, By by) {

		seleniumUtil.click(seleniumUtil.findElementBy(by));

	}

	/** 检查货源的第一行的数据：发货地和收货地 */
	public static void checkGoodsAddress(SeleniumUtil seleniumUtil, By by, String... goodsAdd) {
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}
		String address = seleniumUtil.findElementBy(by).getAttribute("title");
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

	/** 检查货源信息的第二行信息:货物名称 */
	public static void checkGoodsName(SeleniumUtil seleniumUtil, By by, String... secondInfos) {
		int items = seleniumUtil.findElementsBy(by).size(); // 这个items指的是查询出来有多少条货源
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}
		for (int i = 0; i < items; i++) {// 循环每个货源
			String goodsname = null;
			String second = seleniumUtil.findElementsBy(by).get(i).findElements(By.tagName("p")).get(1).getText(); // 取得第二行的货源信息
			String[] secondArray = second.split("，");
			int temp = secondArray[0].indexOf("（");
			if (temp != -1) {
				goodsname = secondArray[0].substring(0, secondArray[0].indexOf("（") - 1);
			} else {
				goodsname = secondArray[0].substring(0, secondArray[0].indexOf(" "));
			}
			seleniumUtil.isContains(secondInfos[0], goodsname);

		}

	}

	/** 检查货源信息的第二行信息:吨位或者体积 */
	public static void checkGoodsWeightOrVolume(SeleniumUtil seleniumUtil, By by, String... secondInfos) {

		int items = seleniumUtil.findElementsBy(by).size(); // 这个items指的是查询出来有多少条货源
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}

		for (int i = 0; i < items; i++) {// 循环每个货源
			double goodsWorV = 0; // 重量或者体积
			String second = seleniumUtil.findElementsBy(by).get(i).findElements(By.tagName("p")).get(1).getText(); // 取得第二行的货源信息
			String[] secondArray = second.split("，");
			if (secondInfos[0].equals("重量")) {
				goodsWorV = Double.parseDouble(secondArray[2].replaceAll("吨", ""));// 取得每个货源的重量数
				if (secondInfos[1].equals("") && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is bigger than input weight num [" + secondInfos[2] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is bigger than input weight num [" + secondInfos[2] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

				if (secondInfos[1] != "" && secondInfos[2].equals("")) {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

				if (secondInfos[1] != "" && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]) && goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the weight in web page is [" + goodsWorV + "] and is not in the  input weight num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] T");
						Assert.fail("Found the weight in web page is [" + goodsWorV + "] and is smaller than input weight num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] T");
					}
					logger.info("The weight of the " + (i + 1) + "th goods info is [" + goodsWorV + "] T");
				}

			}

			if (secondInfos[0].equals("体积")) {

				goodsWorV = Double.parseDouble(secondArray[2].replaceAll("方", ""));// 取得每个货源的重量数
				if (secondInfos[1].equals("") && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV <= Double.parseDouble(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is bigger than input volume num [" + secondInfos[2] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is bigger than input volume num [" + secondInfos[2] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

				if (secondInfos[1] != "" && secondInfos[2].equals("")) {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

				if (secondInfos[1] != "" && secondInfos[2] != "") {
					try {
						Assert.assertTrue(goodsWorV >= Double.parseDouble(secondInfos[1]) && goodsWorV <= Integer.valueOf(secondInfos[2]));
					} catch (AssertionError e) {
						logger.error("Found the volume in web page is [" + goodsWorV + "] and is not in the  input volume num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] m³");
						Assert.fail("Found the volume in web page is [" + goodsWorV + "] and is smaller than input volume num [" + secondInfos[1] + "] and [" + secondInfos[2] + "] m³");
					}
					logger.info("The volume of the " + (i + 1) + "th goods info is [" + goodsWorV + "] m³");
				}

			}

		}

	}

	/** 检查货物的发布时间 
	 * @throws ParseException */
	public static void checkGoodsSendDate(SeleniumUtil seleniumUtil, By by, String... headInfos)  {
	     DateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int items = seleniumUtil.findElementsBy(by).size(); // 这个items指的是查询出来有多少条货源
		if (seleniumUtil.findElementsBy(by).get(0).getText().equals("没有搜索到相应的数据")) {
			logger.warn("No data found with this filters!");
			return;
		}

		for (int i = 0; i < items; i++) {
			String header = seleniumUtil.findElementsBy(by).get(i).findElements(By.tagName("div")).get(2).getText();
			// 取得发布时间的 字符串
			header = header.substring(header.indexOf("：") + 1, header.length());
			if (headInfos[0].equals("") && headInfos[1] != "") {
				try{
				try {
					Assert.assertTrue(formater.parse(headInfos[1]).getTime()>=formater.parse(header).getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}catch(AssertionError e){
					logger.error("您选择的货源发布的结束时间是："+headInfos[1]+" 该货源的详情中的时间是：["+header+"] ，该时间不在您的筛选条件时间内");
					Assert.fail("您选择的货源发布的结束时间是："+headInfos[1]+" 该货源的详情中的时间是：["+header+"] ，该时间不在您的筛选条件时间内");
				}
				logger.info("您选择的货源发布的结束时间是："+headInfos[1]+" 该货源的详情中的时间是：["+header+"] ，该时间符合筛选条件");
			}
			if (headInfos[1].equals("") && headInfos[0] != "") {
				try{
				try {
					Assert.assertTrue(formater.parse(headInfos[0]).getTime()<=formater.parse(header).getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}catch(AssertionError e){
					logger.error("您选择的货源发布的开始时间是："+headInfos[0]+" 该货源的详情中的时间是：["+header+"] ，该时间小于您的筛选条件时间");
					Assert.fail("您选择的货源发布的开始时间是："+headInfos[0]+" 该货源的详情中的时间是：["+header+"] ，该时间小于您的筛选条件时间");
				}
				logger.info("您选择的货源发布的开始时间是："+headInfos[0]+" 该货源的详情中的时间是：["+header+"] ，该时间符合筛选条件");
			}
			if (headInfos[0]!="" && headInfos[1] != "") {
				try{
				try {
					Assert.assertTrue(formater.parse(headInfos[0]).getTime()<=formater.parse(header).getTime()&&formater.parse(headInfos[1]).getTime()>=formater.parse(header).getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}catch(AssertionError e){
					logger.error("您选择的货源发布的开始时间是："+headInfos[0]+",您选择的货源的结束时间是："+headInfos[1]+" 该货源的详情中的时间是：["+header+"] ，该时间不在开始和结束时间之间");
					Assert.fail("您选择的货源发布的开始时间是："+headInfos[0]+",您选择的货源的结束时间是："+headInfos[1]+" 该货源的详情中的时间是：["+header+"] ，该时间不在开始和结束时间之间");
				}
				logger.info("您选择的货源发布的开始时间是："+headInfos[0]+",您选择的货源的结束时间是："+headInfos[1]+" 该货源的详情中的时间是：["+header+"] ，该时间在开始和结束时间之间");
			
			}

		}

	}

}
