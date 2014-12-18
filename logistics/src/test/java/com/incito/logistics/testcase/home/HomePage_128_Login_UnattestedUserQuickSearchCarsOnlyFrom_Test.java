package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下,未认证用户 进行快速查找车源操作，只输入出发地，筛选后正确跳转到找车源页面
 * 
 * */
public class HomePage_128_Login_UnattestedUserQuickSearchCarsOnlyFrom_Test extends HomeUnattestedFather {
	@Test(dataProvider="data")
	public void loginUnattestedUserQuickSearchCarsOnlyFrom(ITestContext context,Map<String,String> data) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_QUICK_FINDCARS);
		HomePageHelper.typeQuickSearchInfo(seleniumUtil, data.get("FROM"),data.get("TO"),data.get("NO"),data.get("QUICKSEARCHTYPE"));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH2);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
		FindCarsPageHelper.checkCityName(seleniumUtil, data.get("FROM"),data.get("TO"));
		FindCarsPageHelper.checkCurrentCarLocation(seleniumUtil, data.get("FROM"));

	}

}
