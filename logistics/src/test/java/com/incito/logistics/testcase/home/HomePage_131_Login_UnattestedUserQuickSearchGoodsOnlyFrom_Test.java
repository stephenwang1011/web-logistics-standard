package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 未认证用户进行快速查找货源操作，只输入发货地，点击查询按钮之后，页面跳转到找货源页面并且查询出了正确的数据
 * 
 * */
public class HomePage_131_Login_UnattestedUserQuickSearchGoodsOnlyFrom_Test extends HomeUnattestedFather {
	@Test(dataProvider="data")
	public void loginUnattestedUserQuickSearchGoodsOnlyFrom(ITestContext context,Map<String,String> data) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_QUICK_FINDGOODS);
		HomePageHelper.typeQuickSearchInfo(seleniumUtil, data.get("GOODSFROM"),data.get("GOODSTO"),data.get("NO"),data.get("QUICKSEARCHTYPE"));
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH3);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
		FindGoodsPageHelper.checkGoodsAddress(seleniumUtil, FindGoodsPage.FGP_DISPLAY_SEARCH, 
				data.get("GOODSFROM"),data.get("GOODSTO"));

	}

}
