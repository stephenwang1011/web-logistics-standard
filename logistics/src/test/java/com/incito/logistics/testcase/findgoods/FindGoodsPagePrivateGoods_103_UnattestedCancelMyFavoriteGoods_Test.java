package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * 
 * @author xy-incito-wk
 * @Description 测试用例：未认证的用户登录，隐藏信息的检验
 */
public class FindGoodsPagePrivateGoods_103_UnattestedCancelMyFavoriteGoods_Test extends FindGoodsFather {
	@Test
	public void FindGoodsPagePublicGoodsInfoCheck(ITestContext context) {
		FindGoodsFather.UnattestedFindGoodsParpare(context, seleniumUtil);
		FindGoodsPageHelper.enterPage(seleniumUtil, FindGoodsPage.FGP_BUTTON_MYFAVORITES);
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);
		
		FindGoodsPageHelper.FavoGoodsChangepublicGoods(seleniumUtil, FindGoodsPage.FGP_GOODS_BUTTON_CANCELMYFAVO);	}
}