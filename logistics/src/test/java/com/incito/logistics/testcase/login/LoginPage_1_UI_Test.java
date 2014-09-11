package com.incito.logistics.testcase.login;

/**
 *@author  xy-incito
 *@Description 测试用例：登陆界面UI测试
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class LoginPage_1_UI_Test extends BaseParpare {
	@Test
	public void uiTest(ITestContext context) {
		// 从testng的配置文件（xml）中读取等待页面超时的时间
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil); // home的帮助页，调用一个等待页面加载的时间方法
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN); // 然后从home帮助页面调用一个进入页面的方法
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil); // 再然后登陆的帮助页面去调用一个等待登陆页面加载的方法
		LoginPageHelper.checkLoginPageText(seleniumUtil); // 登陆页面出来以后，登陆帮助类去调用检查UI的方法去检查登陆页面上的UI
		LoginPageHelper.checkInputData(seleniumUtil); // 最后登陆帮助类上调用检查文本输入是否显示正确的方法

	}

}
