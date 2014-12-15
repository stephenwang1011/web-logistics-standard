package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 登录情况下，未认证的用户去查看首页的车源信息，车牌号都应该加上了*号
 * 
 * */
public class HomePage_116_Login_UnauthenticationUserCheckHomeCars_Test extends BaseParpare {
	@Test
	public void unauthenticationUserCheckHomeCars(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		String unauthusername = PropertiesDataProvider.getTestData(configFilePath, "unauthusername");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, unauthusername, password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.checkUnauthenticationUserHomeCars(seleniumUtil);


	}

}
