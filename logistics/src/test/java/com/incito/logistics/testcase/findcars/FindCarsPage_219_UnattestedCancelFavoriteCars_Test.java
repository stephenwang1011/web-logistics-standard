package com.incito.logistics.testcase.findcars;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证的用户，收藏的车源，在公共车源列表中取消收藏车源，不会弹出确认取消收藏的提示框
 * */
public class FindCarsPage_219_UnattestedCancelFavoriteCars_Test extends FindCarsUnattestedFather {

	@Test(dataProvider = "data")
	public void unattestedCancelFavoriteCars(ITestContext context, Map<String, String> data) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.cancelFavCarsByLicense(seleniumUtil, FindCarsPage.FCP_BUTTON_CFAV, data.get("LICENSE"));


	}

}
