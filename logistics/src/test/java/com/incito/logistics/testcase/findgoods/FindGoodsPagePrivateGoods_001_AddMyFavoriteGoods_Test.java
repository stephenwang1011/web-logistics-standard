package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wk
 * @Description 测试用例：在公共货源页面添加当前页面的所有货源为我的收藏
 * */
public class FindGoodsPagePrivateGoods_001_AddMyFavoriteGoods_Test extends FindGoodsFather {
	@Test
	public void AddMyFavoriteGoods(ITestContext context) {
		FindGoodsFather.FindGoodsParpare(context, seleniumUtil);
		
		FindGoodsPageHelper.publicGoodsChangeFavoGoods(seleniumUtil, FindGoodsPage.FGP_GOODS_BUTTON_MYFAVO);
	}
}
