package com.incito.logistics.testcase.myorders;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：已登录的情况下，未认证的用户登录，我的订单无数据的提示信息
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.MyOrdersPage;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.MyOrdersFather;

public class MyOrdersPage_102_UnattestedUserNoInfo_Test extends MyOrdersFather {
	@Test
	public void myOrdersUiTest(ITestContext context) {
		MyOrdersFather.UnattestedMyOrdersParpare(context, seleniumUtil);
		
		MyOrdersPageHelper.myOrdersNoInfo(seleniumUtil, MyOrdersPage.MOP_TEXT_NOINFO);;
	}
}
