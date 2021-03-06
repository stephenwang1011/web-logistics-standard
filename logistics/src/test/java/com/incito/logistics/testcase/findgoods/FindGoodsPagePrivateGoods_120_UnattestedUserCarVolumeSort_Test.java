package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsUnatestedFather;

/**
 * 
 * @author xy-incito-wk
 * @Description 测试用例：已登录的情况下，未认证的用户登录，点击我的收藏，找货源模块下，公共货源上的按照体重排序
 */
public class FindGoodsPagePrivateGoods_120_UnattestedUserCarVolumeSort_Test extends FindGoodsUnatestedFather {
	@Test
	public void unattestedUserCarVolumeSort(ITestContext context) {
		FindGoodsUnatestedFather.unattestedFindGoodsParpare(context, seleniumUtil);

		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);

		FindGoodsPageHelper.checkCarsSort(seleniumUtil, "体积", timeOut);
	}
}