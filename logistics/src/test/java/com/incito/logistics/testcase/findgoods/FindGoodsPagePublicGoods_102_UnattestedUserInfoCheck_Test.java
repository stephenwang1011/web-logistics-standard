package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindGoodsPage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.FindGoodsUnatestedFather;

/**
 * 
 * @author xy-incito-wk
 * @Description 测试用例：已登录的情况下，未认证的用户登录，点击公共货源，隐藏信息中只有认证之后才能看到的信息，隐藏信息的检查
 */
public class FindGoodsPagePublicGoods_102_UnattestedUserInfoCheck_Test extends FindGoodsUnatestedFather {
	@Test
	public void FindGoodsPagePublicGoodsInfoCheck(ITestContext context) {
		FindGoodsUnatestedFather.unattestedFindGoodsParpare(context, seleniumUtil);
		
		FindGoodsPageHelper.unattestedUserChecked(seleniumUtil, FindGoodsPage.FGP_DISPLAY_SEARCH, FindGoodsPage.FGP_HIDE_ATTESTED);
	}
}