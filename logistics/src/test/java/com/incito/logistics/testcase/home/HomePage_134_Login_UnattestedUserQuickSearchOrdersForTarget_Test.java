package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 未认证用户，进行快速查找订单的操作，未认证用户应该有此权限
 * 
 * */
public class HomePage_134_Login_UnattestedUserQuickSearchOrdersForTarget_Test extends HomeUnattestedFather {
	@Test(dataProvider="data")
	public void loginUnattestedUserQuickSearchOrdersForTarget(ITestContext context,Map<String,String> data) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.typeQuickSearchInfo(seleniumUtil, data.get("FROM"),data.get("TO"),data.get("NO"),data.get("QUICKSEARCHTYPE"));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH1);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		//MyOrdersPageHelper.checkQuickSearchOrder(seleniumUtil, data.get("NO"));
		


	}

}
