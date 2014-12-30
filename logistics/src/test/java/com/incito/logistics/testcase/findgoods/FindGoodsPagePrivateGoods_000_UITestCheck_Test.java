package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wk
 * @Description 测试用例：我的收藏，UI界面检查
 * */
public class FindGoodsPagePrivateGoods_000_UITestCheck_Test extends FindGoodsFather {
	@Test
	public void UITestCheck(ITestContext context) {
		FindGoodsFather.findGoodsParpare(context, seleniumUtil, false);
		
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
