package com.incito.logistics.pages.pageshelper;

import org.openqa.selenium.By;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.util.SeleniumUtil;

public class HomePageHelper {
	/**等待页面上某个重要元素显示出来*/
	public static void  waitHomePageToLoad(int timeOut,SeleniumUtil seleniumUtil){
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_BUTTON_LOGIN);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_BUTTON_REG);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_BUTTON_FREESEND);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_TAB_FINDCARS);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_HOME);
		//seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_PERSONCEN);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_FINDCARDS);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_FINDGOODS);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_MYORDER);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_MYGOODS);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_MYCARDS);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_TAB_TRACKGOODS);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_TAB_FINDCARS);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_INPUT_ORDERNO);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LEFT_TITLE);
		//seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_CHANGEANOTHER);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_TEXT_FOOTER);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_AREAR_CARS1);
		seleniumUtil.waitForElementToLoad(timeOut,HomePage.HP_LINK_MORE);
	}
	
	/**检查首页上的文本*/
	public static void checkHomePageText(SeleniumUtil seleniumUtil){
		seleniumUtil.isTextEquals( seleniumUtil.getTitle(), "logistics - 物流管理");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_BUTTON_LOGIN).getText(),"登录");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_BUTTON_REG).getText(),"注册");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_BUTTON_FREESEND).getText(),"免费发布货源");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_TAB_FINDCARS).getText(),"找车源");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_TAB_TRACKGOODS).getText(),"物流跟踪");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_LEFT_TITLE).getText(),"智慧物流"+"\n"+"全球领先的物流信息平台");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_LINK_HOME).getText(),"首页");
		//seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_LINK_PERSONCEN).getText(),"个人中心");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_LINK_FINDCARDS).getText(),"找车源");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_LINK_FINDGOODS).getText(),"找货源");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_LINK_MYORDER).getText(),"我的订单");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_LINK_MYGOODS).getText(),"我的货源");
		seleniumUtil.isTextEquals(seleniumUtil.findElementBy(HomePage.HP_LINK_MYCARDS).getText(),"我的车队");
		FooterPageHelper.checkRegisterPageText(seleniumUtil);
			
	}
	
	/**从首页进入指定的页面-根据元素定位来确定什么页面*/
	public static void enterPage(SeleniumUtil seleniumUtil,By elementLocator){
		seleniumUtil.click(seleniumUtil.findElementBy(elementLocator));
		
	}
	

}
