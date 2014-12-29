package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 进行快速查找订单
 * 
 * */
public class HomePage_112_Login_QuickSearchOrdersForIncorrect_Test extends HomeAttestedFather {
	@Test(dataProvider="data")
	public void quickSearchOrdersForIncorrect(ITestContext context,Map<String,String> data) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);
		
		HomePageHelper.typeQuickSearchInfo(seleniumUtil, data.get("FROM"),data.get("TO"),data.get("NO"),data.get("QUICKSEARCHTYPE"));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH1);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.checkIncorrectOrderInfo(seleniumUtil);
	}
}
