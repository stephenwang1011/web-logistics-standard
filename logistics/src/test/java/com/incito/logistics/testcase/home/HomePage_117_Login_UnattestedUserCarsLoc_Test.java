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
 * @Description 登录情况下，未认证的用户去点击定位按钮 应该弹出："您还未通过认证，暂时不能查看司机当前位置"
 * 
 * */
public class HomePage_117_Login_UnattestedUserCarsLoc_Test extends BaseParpare {
	@Test
	public void unattestedUserCarsLoc(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		String unauthusername = PropertiesDataProvider.getTestData(configFilePath, "unauthusername");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		int indexGoods = Integer.valueOf(context.getCurrentXmlTest().getParameter("indexGoods"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, unauthusername, password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_ARERA_ITEMS, HomePage.HP_BUTTON_LOC, indexGoods);
		HomePageHelper.checkUnauthenticationUserLoc(seleniumUtil, sleepTime);


	}

}
