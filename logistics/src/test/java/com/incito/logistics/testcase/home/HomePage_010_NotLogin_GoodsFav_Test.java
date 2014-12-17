package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

/**
 * @author xy-incito-wy
 * @Description 测试用例：未登录情况下点击公共货源的收藏按钮 弹出登陆页面
 * 
 * */
public class HomePage_010_NotLogin_GoodsFav_Test extends BaseParpare {
	@Test
	public void clickFavButton(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int indexGoods = Integer.valueOf(context.getCurrentXmlTest().getParameter("indexGoods"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_ARERA_ITEMS, HomePage.HP_BUTTON_FAV, indexGoods);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);
		LoginPageHelper.enterPage(seleniumUtil, LoginPage.LP_BUTTON_CLOSE);

	}

}
