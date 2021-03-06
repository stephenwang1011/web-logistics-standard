package com.incito.logistics.plugins.father;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.UserBaseInfoPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.UserBaseInfoPagerHelper;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * */
public class UserBaseInfoUnattestedFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;

	/** 为找车源模块，未认证用户的登录操作以及相关数据准备 **/
	public static void userBaseInfoParpare(ITestContext context, SeleniumUtil seleniumUtil, boolean flag) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		String unattestedUserName = PropertiesDataProvider.getTestData(configFilePath, "registered_username");
		String unattestedPassword = PropertiesDataProvider.getTestData(configFilePath, "registered_password");
		By[] bys = { UserBaseInfoPage.BUIP_INPUT_QQ_REVISE, UserBaseInfoPage.BUIP_INPUT_EMAIL_REVISE };
		
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, unattestedUserName, unattestedPassword);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_NOAUTHOR);
		UserBaseInfoPagerHelper.enterPage(seleniumUtil, UserBaseInfoPage.UBIP_TAB_BASEINFO);
		if (flag) {
			UserBaseInfoPagerHelper.enterPage(seleniumUtil, UserBaseInfoPage.BUIP_BUTTON_REVISE);
			seleniumUtil.waitForElementToLoad(timeOut, UserBaseInfoPage.UBIP_TITLE_USERINFO);
			
			String birthday = "document.getElementsByName('birthday')[0].setAttribute('value','');";
			((JavascriptExecutor) seleniumUtil.driver).executeScript(birthday);
			for (int i = 0; i < bys.length; i++) {
				seleniumUtil.clear(seleniumUtil.findElementBy(bys[i]));
			}
		}
	}
}
