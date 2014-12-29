package com.incito.logistics.testcase.home;


import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.plugins.father.HomeNotLoginFather;
/**
 *@author  xy-incito-wy
 *@Description 测试用例：未登录情况下点击查询 弹出登陆页面
 *
 * */
public class HomePage_008_NotLogin_QuickSearchOrder_Test extends HomeNotLoginFather {
	@Test
	public void quickSearch(ITestContext context) {
		HomeNotLoginFather.homeNotLoginParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH1);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);
		LoginPageHelper.enterPage(seleniumUtil, LoginPage.LP_BUTTON_CLOSE);

	}

}
