package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 点击我的订单，成功进入我的订单页面
 * 
 * */
public class HomePage_104_Login_MyOrdersTabClick_Test extends HomeAttestedFather {
	@Test
	public void loginMyOrdersTabClick(ITestContext context) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_MYORDER);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		MyOrdersPageHelper.checkMyOrdersPageText(seleniumUtil);

	}
}
