package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 未认证用户进行快速查找订单操作，输入一个不合法的订单编号，点击查询会弹出提示语
 * 
 * */
public class HomePage_135_Login_UnattestedQuickSearchOrdersForIncorrect_Test extends HomeUnattestedFather {
	@Test(dataProvider="data")
	public void loginUnattestedQuickSearchOrdersForIncorrect(ITestContext context,Map<String,String> data) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.typeQuickSearchInfo(seleniumUtil, data.get("FROM"),data.get("TO"),data.get("NO"),data.get("QUICKSEARCHTYPE"));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH1);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.checkIncorrectOrderInfo(seleniumUtil);
		


	}

}
