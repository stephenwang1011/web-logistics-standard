package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsUnatestedFather;

/**
 * 
 * @author xy-incito-wk
 * @Description 测试用例：已登录的情况下，未认证的用户登录，点击公共货源下，找货源模块，公共货源上的按照车重排序
 */
public class FindGoodsPagePublicGoods_119_UnattestedUserCarWeightSort_Test extends FindGoodsUnatestedFather {
	@Test
	public void FindGoodsPagePublicGoodsInfoCheck(ITestContext context) {
		FindGoodsUnatestedFather.UnattestedFindGoodsParpare(context, seleniumUtil);
		
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_ADVANCESEARCH);
		FindGoodsPageHelper.checkCarsSort(seleniumUtil, "重量", timeOut);
	}
}