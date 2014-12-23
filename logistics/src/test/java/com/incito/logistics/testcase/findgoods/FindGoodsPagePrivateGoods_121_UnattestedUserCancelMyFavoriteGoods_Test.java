package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsUnatestedFather;

/**
 * 
 * @author xy-incito-wk
 * @Description 测试用例：已登录的情况下，未认证的用户登录，点击我的收藏，取消我的收藏页面中当前所有收藏的货源
 */
public class FindGoodsPagePrivateGoods_121_UnattestedUserCancelMyFavoriteGoods_Test extends FindGoodsUnatestedFather {
	@Test
	public void FindGoodsPagePublicGoodsInfoCheck(ITestContext context) {
		FindGoodsUnatestedFather.UnattestedFindGoodsParpare(context, seleniumUtil);
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);

		FindGoodsPageHelper.FavoGoodsChangepublicGoods(seleniumUtil, FindGoodsPage.FGP_GOODS_BUTTON_CANCELMYFAVO);
	}
}