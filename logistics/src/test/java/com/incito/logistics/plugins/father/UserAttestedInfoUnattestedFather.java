package com.incito.logistics.plugins.father;

import org.openqa.selenium.By;
import org.testng.ITestContext;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.UserAttestedInfoPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.UserAttestedInfoPagerHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wy
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * */
public class UserAttestedInfoUnattestedFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;

	/** 为找车源模块，未认证用户的登录操作以及相关数据准备 **/
	public static void userUnatestedInfoParpare(ITestContext context, SeleniumUtil seleniumUtil) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		String registered_username = PropertiesDataProvider.getTestData(configFilePath, "registered_username");
		String registered_password = PropertiesDataProvider.getTestData(configFilePath, "registered_password");
		By[] bys = { UserAttestedInfoPage.UAIP_INPUT_NAME, UserAttestedInfoPage.UAIP_INPUT_TEL,
				UserAttestedInfoPage.UAIP_INPUT_PHOTO, UserAttestedInfoPage.UAIP_INPUT_CHIT,
				UserAttestedInfoPage.UAIP_INPUT_IDCARD, UserAttestedInfoPage.UAIP_INPUT_COMPANY,
				UserAttestedInfoPage.UAIP_INPUT_ADDRESS };

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, registered_username, registered_password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_FREESEND);
		UserAttestedInfoPagerHelper.waitUserAttestedInfoPageToLoad(timeOut, seleniumUtil);
		for (By by : bys) {
			seleniumUtil.clear(seleniumUtil.findElementBy(by));
		}
		seleniumUtil.selectByIndex(UserAttestedInfoPage.UAIP_SELECT_PROVINCE, 0);
	}
}
