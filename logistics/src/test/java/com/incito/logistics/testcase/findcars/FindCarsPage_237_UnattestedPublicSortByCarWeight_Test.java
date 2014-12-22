package com.incito.logistics.testcase.findcars;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证用户，进入找车源-公共车源中，按照载重排序车源
 * */
public class FindCarsPage_237_UnattestedPublicSortByCarWeight_Test extends FindCarsUnattestedFather {

	@Test
	public void publicSortByCarWeight(ITestContext context) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.checkCarsSort(seleniumUtil, "载重", timeOut);


	}

}
