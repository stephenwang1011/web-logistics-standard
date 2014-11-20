package com.incito.logistics.pages.pageshelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.pages.MyOrdersPage;
import com.incito.logistics.util.SeleniumUtil;

/**
 * 
 * @author Think
 * 注释：现在没有将搜索结果中没有数据的写进来
 */
public class MyOrdersPageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class.getName());

	/** 等待我的订单页面元素加载 */
	public static void waitForMyOrdersPageToLoad(SeleniumUtil seleniumUtil, int timeOut) {
		logger.info("Start checking my order page web element");
		seleniumUtil.waitForElementToLoad(timeOut, MyOrdersPage.MOP_INPUT_FROM);
		seleniumUtil.waitForElementToLoad(timeOut, MyOrdersPage.MOP_INPUT_TO);
		seleniumUtil.waitForElementToLoad(timeOut, MyOrdersPage.MOP_INPUT_STARTTIME);
		seleniumUtil.waitForElementToLoad(timeOut, MyOrdersPage.MOP_INPUT_ENDTIME);
		seleniumUtil.waitForElementToLoad(timeOut, MyOrdersPage.MOP_BUTTON_SEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, MyOrdersPage.MOP_BUTTON_ADSEARCH);
		seleniumUtil.waitForElementToLoad(timeOut, MyOrdersPage.MOP_SPAN_TABS);
		logger.info("Checking my order page web element complete");
	}

	/** 检查我的订单页面上的文本 */
	public static void checkMyOrdersPageText(SeleniumUtil seleniumUtil) {
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyOrdersPage.MOP_BUTTON_SEARCH).getText().trim(), "搜索");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyOrdersPage.MOP_BUTTON_ADSEARCH).getText().trim(), "高级搜索");
		int size = seleniumUtil.findElementBy(MyOrdersPage.MOP_SPAN_TABS).findElements(By.tagName("span")).size();
		String tabs[] = { "近三个月的订单", "已预订", "待收款", "配货中", "运输中", "到达收货地", "待评价", "交易成功", "交易关闭", "三个月前订单" };
		for (int i = 0; i < size; i++) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyOrdersPage.MOP_SPAN_TABS).findElements(By.tagName("span")).get(i).getText(), tabs[i]);
		}
	}

	/** 检查快速搜索的订单 */
	public static void checkQuickSearchOrder(SeleniumUtil seleniumUtil, String... qucikSearchInfos) {
		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(MyOrdersPage.MOP_INPUT_ORDERNO, "value"), qucikSearchInfos[0]);
		String orderno = seleniumUtil.getText(MyOrdersPage.MOP_TEXT_ORDERNO);
		String[] s = orderno.split("：");
		seleniumUtil.isTextCorrect(s[1], qucikSearchInfos[0]);
	}

	/** 从当前页面进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
	}

	public static void typeOrdersInfo(SeleniumUtil seleniumUtil, String... info) {
		// 填充发货地
		String jsFrom = "document.getElementsByName('originalcity')[0].setAttribute('value','" + info[0].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(jsFrom);
		// 填充收货地
		String jsTo = "document.getElementsByName('receiptcity')[0].setAttribute('value','" + info[1].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(jsTo);
		// 开始时间
		if (info[2].toString() != "") {
			String startDate = "document.getElementsByName('startime')[0].setAttribute('value','" + info[2].toString().substring(0, info[2].toString().indexOf(" ")) + "');";
			((JavascriptExecutor) seleniumUtil.driver).executeScript(startDate);
		}
		// 结束时间
		if (info[3] != "") {
			String endDate = "document.getElementsByName('endtime')[0].setAttribute('value','" + info[3].toString().substring(0, info[3].toString().indexOf(" ")) + "');";
			((JavascriptExecutor) seleniumUtil.driver).executeScript(endDate);
		}
		// 填写订单编号
		if (info[4].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(MyOrdersPage.MOP_INPUT_ORDERNO), info[4].toString());
		}
		// 货物名称
		if (info[5].toString() != "") {
			String goodsName = "document.getElementsByName('goodsnames')[0].setAttribute('value','" + info[5].toString() + "');";
			seleniumUtil.executeJS(goodsName);
		}
		// 填写承运司机
		if (info[6].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTVOLUME), info[6].toString());
		}
		// 填收货人
		if (info[7].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTVOLUME), info[7].toString());
		}
		// 填写收货公司
		if (info[8].toString() != "") {
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTVOLUME), info[8].toString());
		}
	}

	/** 检查货源的第一行的数据：发货地和收货地 */
	public static void checkMyOrdersAddress(SeleniumUtil seleniumUtil, By byOrdersInfoes, By byAddress, String... myOrders) {
		try {
			// 这个items指的是查询出来有多少条货源
			int items = seleniumUtil.findElementsBy(byOrdersInfoes).size();
			for (int i = 0; i < items; i++) {// 循环每个订单：只对针对当前页面的
				String address = seleniumUtil.findElementsBy(byAddress).get(i).getText();
				address = address.replaceAll(" ", "");
				String add[] = address.split("到");
				String original = add[0], targetcity = add[1];
				logger.info("您搜索结果的第" + (i + 1) + "货源信息为：");
				if (myOrders[0].equals("") == false) {
					seleniumUtil.isContains(original, myOrders[0]);
				}
				if (myOrders[1].equals("") == false) {
					seleniumUtil.isContains(targetcity, myOrders[1]);
				}
			}
		} catch (Exception e) {
			logger.info("没有我的订单的信息！！！");
			if (seleniumUtil.findElementBy(MyOrdersPage.MOP_TEXT_NOINFO).getText().equals("没有搜索到相应的数据")) {
				logger.warn("No data found with this filters!");
				return;
			}
		}
	}

	/**
	 * 检查订单的发布时间
	 * 
	 * @throws ParseException
	 */
	public static void checkOrdersSendDate(SeleniumUtil seleniumUtil, By byOrdersDate, String... headInfos) {
		// try {
		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int items = seleniumUtil.findElementsBy(byOrdersDate).size(); // 这个items指的是查询出来有多少条货源
		for (int i = 0; i < items; i++) {
			String header = seleniumUtil.findElementsBy(byOrdersDate).get(i).getText();
			// 取得发布时间的 字符串
			header = header.substring(header.indexOf("：") + 1, header.length());
			if (headInfos[0].equals("") && headInfos[1] != "") {
				try {
					try {
						Assert.assertTrue(formater.parse(headInfos[1]).getTime() >= formater.parse(header).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (AssertionError e) {
					logger.error("您选择的订单发布的结束时间是：" + headInfos[1] + " 该订单的详情中的时间是：[" + header + "] ，该时间不在您的筛选条件时间内");
					Assert.fail("您选择的订单发布的结束时间是：" + headInfos[1] + " 该订单的详情中的时间是：[" + header + "] ，该时间不在您的筛选条件时间内");
				}
				logger.info("您选择的订单发布的结束时间是：" + headInfos[1] + " 该订单的详情中的时间是：[" + header + "] ，该时间符合筛选条件");
			}
			if (headInfos[1].equals("") && headInfos[0] != "") {
				try {
					try {
						Assert.assertTrue(formater.parse(headInfos[0]).getTime() <= formater.parse(header).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (AssertionError e) {
					logger.error("您选择的订单发布的开始时间是：" + headInfos[0] + " 该订单的详情中的时间是：[" + header + "] ，该时间小于您的筛选条件时间");
					Assert.fail("您选择的订单发布的开始时间是：" + headInfos[0] + " 该订单的详情中的时间是：[" + header + "] ，该时间小于您的筛选条件时间");
				}
				logger.info("您选择的订单发布的开始时间是：" + headInfos[0] + " 该订单的详情中的时间是：[" + header + "] ，该时间符合筛选条件");
			}
			if (headInfos[0] != "" && headInfos[1] != "") {
				try {
					try {
						Assert.assertTrue(formater.parse(headInfos[0]).getTime() <= formater.parse(header).getTime() && formater.parse(headInfos[1]).getTime() >= formater.parse(header).getTime());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (AssertionError e) {
					logger.error("您选择的订单发布的开始时间是：" + headInfos[0] + ",您选择的订单的结束时间是：" + headInfos[1] + " 该订单的详情中的时间是：[" + header + "] ，该时间不在开始和结束时间之间");
					Assert.fail("您选择的订单发布的开始时间是：" + headInfos[0] + ",您选择的订单的结束时间是：" + headInfos[1] + " 该订单的详情中的时间是：[" + header + "] ，该时间不在开始和结束时间之间");
				}
				logger.info("您选择的订单发布的开始时间是：" + headInfos[0] + ",您选择的订单的结束时间是：" + headInfos[1] + " 该订单的详情中的时间是：[" + header + "] ，该时间在开始和结束时间之间");
			}
		}
		/*
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); if
		 * (seleniumUtil.findElementsBy(MyGoodsPage.MGP_ITEM_GOODS
		 * ).get(0).getText().equals("没有搜索到相应的数据")) {
		 * logger.warn("No data found with this filters!"); return; } }
		 */
	}

	public static void checkOdersNum(SeleniumUtil seleniumUtil, By byOrdersNum, String... odersNum) {
		String header = seleniumUtil.findElementBy(byOrdersNum).getText();
		header = header.replaceAll(" ", "");
		header = header.substring(header.indexOf("：") + 1, header.length());
		try {
			Assert.assertTrue(header.equals(odersNum[0]));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("您所查找的订单编号为：" + odersNum[0] + "，没有查找到！！！");
			Assert.fail("您所查找的订单编号为：" + odersNum[0] + "，没有查找到！！！" );
		}
		logger.info("您所查找的订单编号为：" + odersNum[0] + "，查找到了。" );
	}
}
