package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 找货源-公共货源上，按体积排序我的货源
 * */
public class FindGoodsPagePublicGoods_020_CarVolumeSort_Test extends FindGoodsFather {
	@Test
	public void publicCarVolumeSort(ITestContext context) {
		FindGoodsFather.FindGoodsParpare(context, seleniumUtil);
		FindGoodsPageHelper.checkCarsSort(seleniumUtil, "体积", timeOut);
	}
}
