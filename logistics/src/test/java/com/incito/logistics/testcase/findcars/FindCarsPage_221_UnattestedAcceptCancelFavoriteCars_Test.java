package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证的用户，收藏的车源，在我的车源列表中取消收藏车源，会弹出确认取消收藏的提示框，然后在提示框上点击确认按钮，检查是不是取消成功
 * */
public class FindCarsPage_221_UnattestedAcceptCancelFavoriteCars_Test extends FindCarsUnattestedFather {

	@Test(dataProvider = "data")
	public void unattestedAcceptCancelFavoriteCars(ITestContext context, Map<String, String> data) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.cancelFavCarsByLicense(seleniumUtil, FindCarsPage.FCP_BUTTON_CFAV, data.get("LICENSE"));


	}


}
