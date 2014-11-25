package com.incito.logistics.testcase.login;

/**
 *@author  xy-incito-wy
 *@Description 测试用例：企业账户退出登陆操作
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

public class LoginPage_502_Enterprise_ExitAfterLogin_Test extends BaseParpare {

	@Test
	public void exitLoginForEnterPriseTest(ITestContext context) {
		String configFilePath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String enterprise_username = PropertiesDataProvider.getTestData(configFilePath, "enterprise_username");
		String enterprise_password = PropertiesDataProvider.getTestData(configFilePath, "enterprise_password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);
		LoginPageHelper.login(seleniumUtil, enterprise_username, enterprise_password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, enterprise_username);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_TEXT_USERINFO);
		seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_BUTTON_EXIT));
	}

}
