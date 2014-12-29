package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：进入找车源页面，在列表收藏一条车源，然后在我的车源中检查是不是收藏成功
 * */
public class FindCarsPage_015_FavoriteCarsWithNoSearch_Test extends FindCarsFather {

	@Test(dataProvider = "data")
	public void favoriteCarsWithNoSearch(ITestContext context,Map<String,String> data) {
		FindCarsFather.FindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.favCarsByLicense(seleniumUtil, FindCarsPage.FCP_BUTTON_FAV, data.get("LICENSE"));
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.isFavCarExistByLicense(seleniumUtil, data.get("LICENSE"));
	}
}
