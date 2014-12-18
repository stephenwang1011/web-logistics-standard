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
 * @Description 登录情况下 未认证用户进行快速查找车源操作，输入出发地和目的地，点击查询按钮后页面跳转到找车源页面并且查询出了正确的数据
 * 
 * */
public class HomePage_130_Login_UnattestedUserQuickSearchCarsAll_Test extends HomeUnattestedFather {
	@Test(dataProvider="data")
	public void loginUnattestedUserQuickSearchCarsAll(ITestContext context,Map<String,String> data) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_QUICK_FINDCARS);
		HomePageHelper.typeQuickSearchInfo(seleniumUtil, data.get("FROM"),data.get("TO"),data.get("NO"),data.get("QUICKSEARCHTYPE"));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH2);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
		FindCarsPageHelper.checkCityName(seleniumUtil, data.get("FROM"),data.get("TO"));
		FindCarsPageHelper.checkCurrentCarLocation(seleniumUtil, data.get("FROM"));
		FindCarsPageHelper.checkTargetCity(seleniumUtil, data.get("TO"));

	}

}
