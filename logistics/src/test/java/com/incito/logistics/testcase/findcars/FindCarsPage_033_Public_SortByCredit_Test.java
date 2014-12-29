package com.incito.logistics.testcase.findcars;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsFather;

/**
 * @author xy-incito-wy
 * @Description 按照信用等级排序车源
 * */
public class FindCarsPage_033_Public_SortByCredit_Test extends FindCarsFather {

	@Test
	public void publicSortByCredit(ITestContext context) {
		FindCarsFather.FindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.checkCarsSort(seleniumUtil, "信用等级", timeOut);
	}
}
