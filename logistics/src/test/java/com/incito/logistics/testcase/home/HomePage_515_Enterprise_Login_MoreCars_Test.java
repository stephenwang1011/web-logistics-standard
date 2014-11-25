package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

	/**
	 * @author xy-incito-wy
	 * @Description 登录情况下点击公共车源上的 "更多>>" 进入找车源页面
	 * 
	 * */
	public class HomePage_515_Enterprise_Login_MoreCars_Test extends BaseParpare {
	@Test
	public void clickMoreCarsForEnterprise(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		String enterprise_username = PropertiesDataProvider.getTestData(configFilePath, "enterprise_username");
		String enterprise_password = PropertiesDataProvider.getTestData(configFilePath, "enterprise_password");
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);

		LoginPageHelper.login(seleniumUtil, enterprise_username, enterprise_password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);

		seleniumUtil.click(seleniumUtil.findElementsBy(HomePage.HP_LINK_MORE).get(0));
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);

		}

	}


