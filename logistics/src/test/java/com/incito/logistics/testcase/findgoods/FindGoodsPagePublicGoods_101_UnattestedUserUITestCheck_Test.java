package com.incito.logistics.testcase.findgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.FindGoodsFather;

/**
 * @author xy-incito-wk
 * @Description 测试用例：未认证的用户登录，查找货源界面检查
 * */
public class FindGoodsPagePublicGoods_101_UnattestedUserUITestCheck_Test extends FindGoodsFather {
	@Test
	public void UITestCheck(ITestContext context) {
		FindGoodsFather.UnattestedFindGoodsParpare(context, seleniumUtil);

		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
