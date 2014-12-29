package com.incito.logistics.testcase.myorders;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：我的订单UI、文本测试
 *
 * */
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.MyOrdersPage;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.plugins.father.MyOrdersFather;

public class MyOrdersPage_005_OrdersDateStart_Test extends MyOrdersFather {
	@Test(dataProvider = "data")
	public void searchOrdersDateStart(ITestContext context, Map<String, String> data) {
		MyOrdersFather.myOrdersParpare(context, seleniumUtil);
		
		MyOrdersPageHelper.typeOrdersInfo(seleniumUtil, 
				data.get("MOP_INPUT_SENDFROMCITY"), data.get("MOP_INPUT_SENDTOCITY"),
				data.get("MOP_INPUT_ORDERSTIME_START"), data.get("MOP_INPUT_ORDERSTIME_END"),
				data.get("MOP_INPUT_ORDERSNUM"), data.get("MOP_INPUT_GOODSNAME"),
				data.get("MOP_INPUT_DRIVER"), data.get("MOP_INPUT_RECEIVER"),
				data.get("MOP_INPUT_HARVESTCOMPANY"));
		MyOrdersPageHelper.enterPage(seleniumUtil, MyOrdersPage.MOP_BUTTON_SEARCH);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		MyOrdersPageHelper.checkOrdersSendDate(seleniumUtil, MyOrdersPage.MOP_TEXT_ORDERDATE,
				data.get("MOP_INPUT_ORDERSTIME_START"), data.get("MOP_INPUT_ORDERSTIME_END"));
	}
	
}
