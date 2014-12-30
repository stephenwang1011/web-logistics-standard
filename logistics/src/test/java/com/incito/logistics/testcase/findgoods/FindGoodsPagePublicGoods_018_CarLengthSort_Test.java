package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 找货源-公共货源上，按车长排序货源
 * */
public class FindGoodsPagePublicGoods_018_CarLengthSort_Test extends FindGoodsFather {
	@Test
	public void publicCarLengthSort(ITestContext context) {
		FindGoodsFather.findGoodsParpare(context, seleniumUtil, true);
		FindGoodsPageHelper.checkCarsSort(seleniumUtil, "车长", timeOut);
	}
}
