package com.incito.logistics.testcase.myorders;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：我的订单UI、文本测试
 *
 * */
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.MyOrdersPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;
import com.incito.logistics.util.ExcelDataProvider;
import com.incito.logistics.util.PropertiesDataProvider;

public class MyOrdersPage_503_Enterprise_SendTo_Test extends BaseParpare {
	@Test(dataProvider = "data")
	public void SendFrom(ITestContext context, Map<String, String> data) {
		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String username = PropertiesDataProvider.getTestData(userInfoPath, "enterprise_username");
		String password = PropertiesDataProvider.getTestData(userInfoPath, "enterprise_password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, username, password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_MYORDER);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		MyOrdersPageHelper.enterPage(seleniumUtil, MyOrdersPage.MOP_TAB_MYCARS);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		MyOrdersPageHelper.enterPage(seleniumUtil, MyOrdersPage.MOP_RADIO_MYGOODS);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		
		MyOrdersPageHelper.typeOrdersInfo(seleniumUtil, 
				data.get("MOP_INPUT_SENDFROMCITY"), data.get("MOP_INPUT_SENDTOCITY"),
				data.get("MOP_INPUT_ORDERSTIME_START"), data.get("MOP_INPUT_ORDERSTIME_END"),
				data.get("MOP_INPUT_ORDERSNUM"), data.get("MOP_INPUT_GOODSNAME"),
				data.get("MOP_INPUT_DRIVER"), data.get("MOP_INPUT_RECEIVER"),
				data.get("MOP_INPUT_HARVESTCOMPANY"));
		MyOrdersPageHelper.enterPage(seleniumUtil, MyOrdersPage.MOP_BUTTON_SEARCH);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);
		MyOrdersPageHelper.checkMyOrdersAddress(seleniumUtil, MyOrdersPage.MOP_EP_TEXT_ORDERSINFOES,  MyOrdersPage.MOP_EP_TEXT_ADDRESS,
				data.get("MOP_INPUT_SENDFROMCITY"), data.get("MOP_INPUT_SENDTOCITY"));
	}
	
	@DataProvider(name = "data")
	public Iterator<Object[]> dataFortestMethod() throws IOException {
		String moduleName = null; // 模块的名字
		String caseNum = null; // 用例编号
		String className = this.getClass().getName();
		int dotIndexNum = className.indexOf("."); // 取得第一个.的index
		int underlineIndexNum = className.indexOf("_"); // 取得第一个_的index

		if (dotIndexNum > 0) {
			moduleName = className.substring(30, className.lastIndexOf(".")); // 取到模块的名称
		}

		if (underlineIndexNum > 0) {
			caseNum = className.substring(underlineIndexNum + 1, underlineIndexNum + 4); // 取到用例编号
		}
		// 将模块名称和用例的编号传给 ExcelDataProvider ，然后进行读取excel数据
		return new ExcelDataProvider(moduleName, caseNum);
	}
}
