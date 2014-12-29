package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 找货源-公共货源上，按重量排序货源
 * */
public class FindGoodsPagePublicGoods_019_CarWeightSort_Test extends FindGoodsFather {
	@Test
	public void publicCarWeightSort(ITestContext context) {
		FindGoodsFather.FindGoodsParpare(context, seleniumUtil);
		FindGoodsPageHelper.checkCarsSort(seleniumUtil, "重量", timeOut);
	}
}
