package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.incito.logistics.pages.MyOrdersPage;
import com.incito.logistics.util.SeleniumUtil;

public class MyOrdersPageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class.getName());
	/**等待我的订单页面元素加载*/
	public static void waitForMyOrdersPageToLoad(SeleniumUtil seleniumUtil,int timeOut){
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
	
	/**检查我的订单页面上的文本*/
	public static void checkMyOrdersPageText(SeleniumUtil seleniumUtil){
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyOrdersPage.MOP_BUTTON_SEARCH).getText().trim(), "搜索");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyOrdersPage.MOP_BUTTON_ADSEARCH).getText().trim(), "高级搜索");
		int size = seleniumUtil.findElementBy(MyOrdersPage.MOP_SPAN_TABS).findElements(By.tagName("span")).size();
		String tabs[] = {"近三个月的订单","已预订","待收款","配货中","运输中","到达收货地","待评价","交易成功","交易关闭","三个月前订单"};
		for (int i = 0; i < size; i++) {
			seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(MyOrdersPage.MOP_SPAN_TABS).findElements(By.tagName("span")).get(i).getText(), tabs[i]);
		}
		
	}
	/**检查快速搜索的订单*/
	public static void checkQuickSearchOrder(SeleniumUtil seleniumUtil, String ...qucikSearchInfos){
			seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(MyOrdersPage.MOP_INPUT_ORDERNO, "value"), qucikSearchInfos[0]);
			String orderno = seleniumUtil.getText(MyOrdersPage.MOP_TEXT_ORDERNO);
			String[] s = orderno.split("：");
			seleniumUtil.isTextCorrect(s[1], qucikSearchInfos[0]);

	}
	
	
	
	
	
	
	

}
