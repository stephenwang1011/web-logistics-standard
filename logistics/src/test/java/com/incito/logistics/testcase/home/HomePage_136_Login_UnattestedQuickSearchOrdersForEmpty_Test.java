package com.incito.logistics.testcase.home;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 未认证用户进行快速查找订单，但是不输任何内容点击查询，未认证用户有权操作
 * 
 * */
public class HomePage_136_Login_UnattestedQuickSearchOrdersForEmpty_Test extends HomeUnattestedFather {
	@Test
	public void loginUnattestedQuickSearchOrdersForEmpty(ITestContext context) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH1);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);

		


	}
}
