package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wk
 * @Description 找货源-公共货源上，默认排序检查
 * */
public class FindGoodsPagePrivateGoods_016_DefaultSort_Test extends FindGoodsFather {
	@Test
	public void privateDefaultSort(ITestContext context) {
		FindGoodsFather.FindGoodsParpare(context, seleniumUtil);
		
		FindGoodsPageHelper.checkCarsSort(seleniumUtil, "默认排序", timeOut);
	}
}
