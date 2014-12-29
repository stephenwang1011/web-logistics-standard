package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：收藏的车源，在我的车源列表中取消收藏车源，会弹出确认取消收藏的提示框，然后在此提示框上点击取消按钮
 * */
public class FindCarsPage_018_DismissCancelFavoriteCars_Test extends FindCarsFather {

	@Test(dataProvider = "data")
	public void cancelFavoriteCars(ITestContext context, Map<String, String> data) {
		FindCarsFather.FindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.dismissCancelCarsByLicense(seleniumUtil, FindCarsPage.FCP_BUTTON_CFAV, data.get("LICENSE"));
	}
}
