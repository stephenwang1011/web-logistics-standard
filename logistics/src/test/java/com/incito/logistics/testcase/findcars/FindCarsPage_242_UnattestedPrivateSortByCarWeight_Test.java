package com.incito.logistics.testcase.findcars;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证用户，进入找车源-我的收藏中，按照载重排序车源
 * */
public class FindCarsPage_242_UnattestedPrivateSortByCarWeight_Test extends FindCarsUnattestedFather {

	@Test
	public void unattestedPrivateSortByCarWeight(ITestContext context) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.checkCarsSort(seleniumUtil, "载重", timeOut);


	}

}
