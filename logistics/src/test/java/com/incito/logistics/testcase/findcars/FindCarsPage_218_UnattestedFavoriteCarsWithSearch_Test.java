package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证用户，在找车源页面进行车源搜索，然后搜索的车源中收藏 某条车源，可以收藏成功
 * */
public class FindCarsPage_218_UnattestedFavoriteCarsWithSearch_Test extends FindCarsUnattestedFather {

	@Test(dataProvider = "data")
	public void unattestedFavoriteCarsWithSearch(ITestContext context, Map<String, String> data) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.typeCarsInfo(seleniumUtil, data.get("FCP_INPUT_FROM"), data.get("FCP_INPUT_TO"), 
				data.get("FCP_INPUT_STARTCARLEN"), data.get("FCP_INPUT_ENDCARLEN"), data.get("FCP_INPUT_CARTYPE"), data.get("FCP_INPUT_STARTWEIGHT"), 
				data.get("FCP_INPUT_ENDWEIGHT"), data.get("FCP_INPUT_STARTVOLUME"),  data.get("FCP_INPUT_ENDVOLUME"));
		FindCarsPageHelper.favCarsByLicense(seleniumUtil, FindCarsPage.FCP_BUTTON_FAV, data.get("LICENSE"));
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.isFavCarExistByLicense(seleniumUtil, data.get("LICENSE"));

	}


}
