package com.incito.logistics.plugins.father;

import org.testng.ITestContext;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.UserPasswordPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.UserPasswordPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * */
public class UserPasswordAttestRejectFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;
	protected static String modifyusername3 = "";
	protected static String modifypassword3= "";

	public static void userPasswordParpare(ITestContext context, SeleniumUtil seleniumUtil) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		modifyusername3 = PropertiesDataProvider.getTestData(configFilePath, "modifyusername3");
		modifypassword3 = PropertiesDataProvider.getTestData(configFilePath, "modifypassword3");
	
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, modifyusername3,modifypassword3);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_NOAUTHOR);
		UserPasswordPageHelper.enterPage(seleniumUtil, UserPasswordPage.USP_BUTTON_CHANGEPASSWD);
		UserPasswordPageHelper.waitUserPasswordPageToLoad(seleniumUtil, timeOut);
		UserPasswordPageHelper.checkUserPasswordPageText(seleniumUtil);
	}
}
