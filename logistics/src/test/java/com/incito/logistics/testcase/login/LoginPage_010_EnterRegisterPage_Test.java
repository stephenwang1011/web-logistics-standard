package com.incito.logistics.testcase.login;

/**
 *@author  xy-incito-wy
 *@Description 在登陆页面上点击注册按钮，成功进入注册页面
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.plugins.father.LoginFather;

public class LoginPage_010_EnterRegisterPage_Test extends LoginFather {

	@Test
	public void enterRegisterPage(ITestContext context) {
		LoginFather.loginParpare(context, seleniumUtil);
		LoginPageHelper.enterPage(seleniumUtil, LoginPage.LP_BUTTON_REGISTER);
		RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
	}

}
