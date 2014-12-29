package com.incito.logistics.testcase.findcars;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.FindCarsFather;

/**
 * @author xy-incito-wy
 * @Description 按照信用等级排序车源
 * */
public class FindCarsPage_035_Public_SortByCarWeight_Test extends FindCarsFather {

	@Test
	public void publicSortByCarWeight(ITestContext context) {
		FindCarsFather.FindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.checkCarsSort(seleniumUtil, "载重", timeOut);
	}
}
