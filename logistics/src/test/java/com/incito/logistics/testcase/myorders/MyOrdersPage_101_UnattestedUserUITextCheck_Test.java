package com.incito.logistics.testcase.myorders;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：已登录的情况下，未认证的用户登录，我的订单UI、文本测试
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.MyOrdersUnatestedFather;

public class MyOrdersPage_101_UnattestedUserUITextCheck_Test extends MyOrdersUnatestedFather {
	@Test
	public void unattestedUserUITextCheck(ITestContext context) {
		MyOrdersUnatestedFather.UnattestedMyOrdersParpare(context, seleniumUtil);
		MyOrdersPageHelper.checkMyOrdersPageText(seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
