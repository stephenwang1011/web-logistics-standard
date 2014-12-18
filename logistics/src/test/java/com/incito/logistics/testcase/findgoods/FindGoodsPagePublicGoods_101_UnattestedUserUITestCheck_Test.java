package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.FindGoodsUnatestedFather;

/**
 * @author xy-incito-wk
 * @Description 测试用例：已登录的情况下，未认证的用户登录，我的货源UI和文字检验
 * */
public class FindGoodsPagePublicGoods_101_UnattestedUserUITestCheck_Test extends FindGoodsUnatestedFather {
	@Test
	public void UITestCheck(ITestContext context) {
		FindGoodsUnatestedFather.UnattestedFindGoodsParpare(context, seleniumUtil);

		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
