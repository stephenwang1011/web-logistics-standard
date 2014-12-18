package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下,未认证用户 点击我的订单，成功进入我的订单页面
 * 
 * */
public class HomePage_127_Login_UnattestedUserMyOrdersTabClick_Test extends HomeUnattestedFather {
	@Test
	public void loginUnattestedUserMyOrdersTabClick(ITestContext context) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_MYORDER);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		MyOrdersPageHelper.checkMyOrdersPageText(seleniumUtil);
	}
}
