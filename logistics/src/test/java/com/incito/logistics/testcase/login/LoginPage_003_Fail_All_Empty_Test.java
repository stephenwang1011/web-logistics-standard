package com.incito.logistics.testcase.login;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.AlertPageHelper;
import com.incito.logistics.plugins.father.LoginFather;

/**
 * @author xy-incito-wy
 * @Description 登陆失败：用户名和密码都不填写
 * */
public class LoginPage_003_Fail_All_Empty_Test extends LoginFather {

	@Test
	public void loginFailTest_All_Empty(ITestContext context) {
		LoginFather.loginParpare(context, seleniumUtil);
		seleniumUtil.click(seleniumUtil.findElementBy(LoginPage.LP_BUTTON_LOGIN));
		AlertPageHelper.checkAlertInfo(seleniumUtil, waitMillisecondsForAlert);

	}
}