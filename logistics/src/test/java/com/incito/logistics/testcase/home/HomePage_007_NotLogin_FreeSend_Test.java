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
 *@Description 测试用例：未登录情况下点击发布货源 弹出登陆界面
 *
 * */
public class HomePage_007_NotLogin_FreeSend_Test extends HomeNotLoginFather {
	@Test
	public void freeSendTest(ITestContext context) {
		HomeNotLoginFather.homeNotLoginParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_FREESEND);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);
		LoginPageHelper.enterPage(seleniumUtil, LoginPage.LP_BUTTON_CLOSE);
	}

}
