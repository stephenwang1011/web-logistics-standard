package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsUnatestedFather;

/**
 * 
 * @author xy-incito-wk
 * @Description 测试用例：已登录的情况下，未认证的用户登录，收藏当前页面的搜索货源
 */
public class FindGoodsPagePrivateGoods_102_UnattestedUserAddMyFavoriteGoods_Test extends FindGoodsUnatestedFather {
	@Test
	public void FindGoodsPagePublicGoodsInfoCheck(ITestContext context) {
		FindGoodsUnatestedFather.UnattestedFindGoodsParpare(context, seleniumUtil);
		
		FindGoodsPageHelper.publicGoodsChangeFavoGoods(seleniumUtil, FindGoodsPage.FGP_GOODS_BUTTON_MYFAVO);
	}
}