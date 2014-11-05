package com.incito.logistics.pages.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.sikuli.script.Screen;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.util.SeleniumUtil;

public class HomePageHelper {
	public static Logger logger = Logger.getLogger(HomePageHelper.class.getName());


	/** 等待首页上元素显示出来 */
	public static void waitHomePageToLoad(int timeOut, SeleniumUtil seleniumUtil) {
		logger.info("Start checking home page elements");
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_LOGIN);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_REG);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_FREESEND);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TAB_FINDCARS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_HOME);
		// seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_PERSONCEN);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_FINDCARDS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_FINDGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_MYORDER);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_MYGOODS);
		// seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_MYCARDS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TAB_TRACKGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TAB_FINDCARS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_INPUT_ORDERNO);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LEFT_TITLE);
		// seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_CHANGEANOTHER);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_FOOTER);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_ARERA_CARDSANDGOODS);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_MORE);
		logger.info("Check home page elements completed");
	}

	
	/** 检查首页上的文本 */
	public static void checkHomePageText(SeleniumUtil seleniumUtil) {
		logger.info("Start checking home page text");
	
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_BUTTON_LOGIN).getText(), "登录");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_BUTTON_REG).getText(), "注册");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TAB_FINDCARS).getText(), "找车源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TAB_TRACKGOODS).getText(), "物流跟踪");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LEFT_TITLE).getText(), "智慧物流" + "\n" + "全球领先的物流信息平台");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_HOME).getText(), "首页");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_PERSONCEN).getText(),"个人中心");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_FINDCARDS).getText(), "找车源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_FINDGOODS).getText(), "找货源");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_MYORDER).getText(), "我的订单");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_MYGOODS).getText(), "我的货源");
		// seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_LINK_MYCARDS).getText(),
		// "我的车队");
		FooterPageHelper.checkFooterPageText(seleniumUtil);
		logger.info("Check home page text completed");

	}

	/** 从首页进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By elementLocator) {
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));

	}

	/** 从首页进入指定的页面-根据元素定位来确定什么页面 */
	public static void enterPage(SeleniumUtil seleniumUtil, By bys, By by, int index) {
		seleniumUtil.click(seleniumUtil.getOneElement(bys, by, index));
	}

	/** 在首页暂停一会儿 */
	public static void holdOn(SeleniumUtil seleniumUtil, int sleepTime) {
		seleniumUtil.pause(sleepTime);
	}
	
	/**检查首页的相关UI界面*/
	public static void checkUI(SeleniumUtil seleniumUtil){
		Screen  s = new Screen();
		String screenWidth = String.valueOf(SeleniumUtil.getScreenWidth());
		logger.info("当前屏幕的宽度是："+screenWidth);
		if(screenWidth.equals("1366.0")){
		logger.info("开始检查首页的UI");
		seleniumUtil.isImgExist(s, "/res/img/home/1366_768/logo.png");
		seleniumUtil.isImgExist(s, "/res/img/home/1366_768/tabs.png");
		logger.info("检查首页的UI完成");
		}
		if(screenWidth.equals("1024.0")){
		logger.info("开始检查首页的UI");
		seleniumUtil.isImgExist(s, "/res/img/home/1024_768/logo.png");
		seleniumUtil.isImgExist(s, "/res/img/home/1024_768/tabs.png");
		logger.info("检查首页的UI完成");
		}
	}

}
