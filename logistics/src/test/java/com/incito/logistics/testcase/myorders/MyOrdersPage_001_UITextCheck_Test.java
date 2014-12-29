package com.incito.logistics.testcase.myorders;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：我的订单UI、文本测试
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.plugins.father.MyOrdersFather;

public class MyOrdersPage_001_UITextCheck_Test extends MyOrdersFather {
	@Test
	public void myOrdersUiTest(ITestContext context) {
		MyOrdersFather.myOrdersParpare(context, seleniumUtil);
	}
}
