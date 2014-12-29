package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;

/**
 * @author xy-incito-wk
 * @Description 登录情况下 进行快速查找货源操作，输入发货地和收货地
 * 
 * */
public class HomePage_110_Login_QuickSearchGoods_Test extends HomeAttestedFather {
	@Test(dataProvider = "data")
	public void fromToQuickSearchGoods(ITestContext context, Map<String, String> data) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);

		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_QUICK_FINDGOODS);

		HomePageHelper.typeQuickSearchInfo(seleniumUtil, data.get("GOODSFROM"), data.get("GOODSTO"), data.get("NO"), data.get("QUICKSEARCHTYPE"));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH3);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
		FindGoodsPageHelper.checkGoodsAddress(seleniumUtil, FindGoodsPage.FGP_DISPLAY_SEARCH, data.get("GOODSFROM"), data.get("GOODSTO"));
	}
}
