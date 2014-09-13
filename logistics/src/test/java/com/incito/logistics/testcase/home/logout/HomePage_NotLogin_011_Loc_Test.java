package com.incito.logistics.testcase.home.logout;

/**
 *@author  xy-incito
 *@Description 测试用例：未登录情况下点击公共车源的定位按钮 弹出登陆页面
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class HomePage_NotLogin_011_Loc_Test extends BaseParpare {
	@Test
	public void clickLoc(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		seleniumUtil.mouseMoveToElement(HomePage.HP_AREAR_CARS1);
		seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_CARS1_LOC));
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);

	}

}
