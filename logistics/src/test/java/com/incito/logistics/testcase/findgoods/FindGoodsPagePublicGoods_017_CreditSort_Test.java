package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 找货源-公共货源上，信用等级排序查
 * */
public class FindGoodsPagePublicGoods_017_CreditSort_Test extends FindGoodsFather {
	@Test
	public void publicCreditSort(ITestContext context) {
		FindGoodsFather.findGoodsParpare(context, seleniumUtil, true);
		FindGoodsPageHelper.checkCarsSort(seleniumUtil, "信用评级", timeOut);
	}
}
