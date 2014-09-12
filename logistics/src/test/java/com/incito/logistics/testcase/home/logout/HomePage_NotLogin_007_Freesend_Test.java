package com.incito.logistics.testcase.home.logout;

/**
 *@author  xy-incito
 *@Description 测试用例：未登录情况下点击发布货源 弹出登陆界面
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class HomePage_NotLogin_007_Freesend_Test extends BaseParpare {
	@Test
	public void freeSend(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_BUTTON_FREESEND));
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);
	}

}
