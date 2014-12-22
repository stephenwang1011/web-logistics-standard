package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证用户，在找车源-公共车源页面进行收藏车源的操作，可以收藏成功
 * */
public class FindCarsPage_217_UnattestedFavoriteCarsWithNoSearch_Test extends FindCarsUnattestedFather {

	@Test(dataProvider = "data")
	public void unattestedFavoriteCarsWithNoSearch(ITestContext context,Map<String,String> data) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.favCarsByLicense(seleniumUtil, FindCarsPage.FCP_BUTTON_FAV, data.get("LICENSE"));
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.isFavCarExistByLicense(seleniumUtil, data.get("LICENSE"));

	}

}
