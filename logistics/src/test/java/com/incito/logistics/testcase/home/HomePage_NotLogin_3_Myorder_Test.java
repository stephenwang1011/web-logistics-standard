package com.incito.logistics.testcase.home;

/**
 *@author xy-incito
 *@Description 主页未登录的情况下 点击“我的订单” 应该弹出登陆界面
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class HomePage_NotLogin_3_Myorder_Test extends BaseParpare {
	@Test
	public void myOdders(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_LINK_MYORDER));
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);
		seleniumUtil.click(seleniumUtil.findElementBy(LoginPage.LP_BUTTON_CLOSE));

	}

}
