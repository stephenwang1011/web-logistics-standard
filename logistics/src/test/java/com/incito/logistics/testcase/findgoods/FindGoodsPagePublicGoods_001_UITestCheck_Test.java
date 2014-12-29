package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wk
 * @Description 测试用例：查找货源界面检查
 * */
public class FindGoodsPagePublicGoods_001_UITestCheck_Test extends FindGoodsFather {
	@Test
	public void UITestCheck(ITestContext context) {
		FindGoodsFather.FindGoodsParpare(context, seleniumUtil);

		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
