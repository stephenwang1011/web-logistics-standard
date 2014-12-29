package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 进行快速查找订单
 * 
 * */
public class HomePage_113_Login_QuickSearchOrdersForEmpty_Test extends HomeAttestedFather {
	@Test
	public void quickSearchOrdersForEmpty(ITestContext context) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);

		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH1);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);

	}
}
