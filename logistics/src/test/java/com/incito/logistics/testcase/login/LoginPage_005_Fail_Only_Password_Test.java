package com.incito.logistics.testcase.login;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.AlertPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 登陆失败-不输入用户名，只输入密码
 * */
public class LoginPage_005_Fail_Only_Password_Test extends BaseParpare {

	@Test
	public void loginFailTest_Password(ITestContext context) {
		String configFilePath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int waitMillisecondsForAlert = Integer.valueOf(context.getCurrentXmlTest().getParameter("waitMillisecondsForAlert"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, password, LoginPage.LP_INPUT_PASSCODE);
		AlertPageHelper.checkAlertInfo(seleniumUtil, waitMillisecondsForAlert);
	}

}
