package com.incito.logistics.testcase.mygoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.MyGoodsPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wk
 * @Description 测试用例：我的货源界面检查
 * */
public class MyGoodsPage_701_Enterprise_PlatformOrdersGoods_UITextCheck_Test extends BaseParpare {

	@Test
	public void uITextCheck(ITestContext context) {
		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String username = PropertiesDataProvider.getTestData(userInfoPath, "enterprise_username");
		String password = PropertiesDataProvider.getTestData(userInfoPath, "enterprise_password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, username, password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_MYGOODS);
		MyGoodsPageHelper.enterPage(seleniumUtil, MyGoodsPage.MGP_TAB_PLATFORMORDERSGOODS_EP);
		MyGoodsPageHelper.enterPage(seleniumUtil, MyGoodsPage.MGP_BUTTON_ADSEARCH);
		MyGoodsPageHelper.waitMyGoodsPageToLoad(timeOut, seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
