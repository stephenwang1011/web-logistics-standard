package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wk
 * @Description 测试用例：在我的收藏页面取消当前页面的所有收藏
 * */
public class FindGoodsPagePrivateGoods_021_CancelMyFavoriteGoods_Test extends FindGoodsFather {
	@Test
	public void CancelMyFavoriteGoods(ITestContext context) {
		FindGoodsFather.findGoodsParpare(context, seleniumUtil, false);
		
		FindGoodsPageHelper.FavoGoodsChangepublicGoods(seleniumUtil, FindGoodsPage.FGP_GOODS_BUTTON_CANCELMYFAVO);
	}
}
