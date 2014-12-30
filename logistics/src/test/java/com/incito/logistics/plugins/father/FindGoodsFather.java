package com.incito.logistics.plugins.father;

import org.testng.ITestContext;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.util.SeleniumUtil;

/**
 * @author xy-incito-wk
 * @description 每个流程 开始之间的一个准备类，主要是做登录准备以及相关数据加载准备
 * */
public class FindGoodsFather extends BaseParpare {
	protected static int timeOut = 0;
	protected static int sleepTime = 0;

	/** 首页上未认证用户的登录操作以及相关数据准备 **/
	public static void FindGoodsParpare(ITestContext context, SeleniumUtil seleniumUtil) {
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		String username = PropertiesDataProvider.getTestData(configFilePath, "registered_username");
		String password = PropertiesDataProvider.getTestData(configFilePath, "registered_password");

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, username, password);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_FINDGOODS);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDGOODS);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
	}
}
