package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 进行快速查找车源操作，只输入出发地
 * 
 * */
public class HomePage_105_Login_QuickSearchCars_Test extends HomeAttestedFather {
	@Test(dataProvider="data")
	public void fromOnlyQuickSearchCars(ITestContext context,Map<String,String> data) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_QUICK_FINDCARS);
		
		HomePageHelper.typeQuickSearchInfo(seleniumUtil, data.get("FROM"),data.get("TO"),data.get("NO"),data.get("QUICKSEARCHTYPE"));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH2);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
		FindCarsPageHelper.checkCityName(seleniumUtil, data.get("FROM"),data.get("TO"));
		FindCarsPageHelper.checkCurrentCarLocation(seleniumUtil, data.get("FROM"));

	}

}
