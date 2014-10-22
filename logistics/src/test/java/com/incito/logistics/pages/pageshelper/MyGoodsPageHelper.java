package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

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
	/**在找货源界面输入相关货源信息以便查询*/
	public static void typeGoodsInfo(SeleniumUtil seleniumUtil,String ...info){
		//货源编号
		seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_GOODSNO), info[0].toString());
		// 填充发货地
		String jsFrom = "document.getElementsByName('localcity')[0].setAttribute('value','" + info[1].toString() + "');";
		seleniumUtil.executeJS(jsFrom);
		// 填充收货地
		String jsTo = "document.getElementsByName('targetcity')[0].setAttribute('value','" + info[2].toString() + "');";
		seleniumUtil.executeJS(jsTo);
		//点击高级搜索
		seleniumUtil.click(seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_ADSEARCH));
		//货物名称
		String goodsName = "document.getElementsByName('goodsnames')[0].setAttribute('value','" + info[3].toString() + "');";
		seleniumUtil.executeJS(goodsName);
		//体积还是重量
		seleniumUtil.selectByText(MyGoodsPage.MGP_SELECT_GOODSUNIT,  info[4].toString());
		if(info[4].toString().equals("体积")){
		
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTVOLUME), info[5].toString());
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_ENDVOLUME), info[6].toString());
		}else if(info[4].toString().equals("重量")){
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_STARTWEIGHT), info[5].toString());
			seleniumUtil.type(seleniumUtil.findElementBy(MyGoodsPage.MGP_INPUT_ENDWEIGHT), info[6].toString());
	
		}
		//开始时间
		String startDate = "document.getElementsByName('startgoodstime')[0].setAttribute('value','" + info[7].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(startDate);
		//结束时间
		String endDate = "document.getElementsByName('endgoodstime')[0].setAttribute('value','" + info[8].toString() + "');";
		((JavascriptExecutor) seleniumUtil.driver).executeScript(endDate);	
			
		//点击搜索
		seleniumUtil.click(seleniumUtil.findElementBy(MyGoodsPage.MGP_BUTTON_SEARCH));
		}
		
		
	/**从我的货源界面点击相关按钮*/
	public static void enterPage(SeleniumUtil seleniumUtil,By by){
		
		seleniumUtil.click(seleniumUtil.findElementBy(by));
		
	}
	
	/**检查货源的第一行的数据：发货地和收货地*/
	public static void checkGoodsAddress(SeleniumUtil seleniumUtil,By by,String ...goodsAdd){
		String address = seleniumUtil.findElementBy(by).getAttribute("title");
					address = address.replaceAll(" ", "");
		String add[] = address.split("至");
		String original = add[0],targetcity = add[1];
		seleniumUtil.isContains(original, goodsAdd[0]);
		seleniumUtil.isContains(targetcity, goodsAdd[1]);
	}
	
}