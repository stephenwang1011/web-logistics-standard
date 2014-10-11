package com.incito.logistics.testcase.login;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.AlertPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

/**
 * @author xy-incito-wy
 * @Description 登陆失败：用户名和密码都不填写
 * */
public class LoginPage_003_Fail_All_Empty_Test extends BaseParpare {

	@Test
	public void loginFailTest_All_Empty(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int waitMillisecondsForAlert = Integer.valueOf(context.getCurrentXmlTest().getParameter("waitMillisecondsForAlert"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		seleniumUtil.click(seleniumUtil.findElementBy(LoginPage.LP_BUTTON_LOGIN));
		AlertPageHelper.checkAlertInfo(seleniumUtil, waitMillisecondsForAlert);

	}
}