package com.incito.logistics.testcase.mygoods;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.MyGoodsPageHelper;
import com.incito.logistics.util.ExcelDataProvider;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wk
 * @Description 测试用例：查找我的货源-只输入发布的结束时间
 * */
public class MyGoodsPage_714_Enterprise_PlatformOrdersGoods_EndDateDataOnlyInputSearch_Test extends BaseParpare {

	@Test(dataProvider = "data")
	public void endDateDataOnlyInputSearch(ITestContext context, Map<String, String> data) {
		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String username = PropertiesDataProvider.getTestData(userInfoPath, "enterprise_username");
		String password = PropertiesDataProvider.getTestData(userInfoPath, "enterprise_password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, username, password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_MYGOODS);
		MyGoodsPageHelper.waitMyGoodsPageToLoad(timeOut, seleniumUtil);
		MyGoodsPageHelper.enterPage(seleniumUtil, MyGoodsPage.MGP_TAB_PLATFORMORDERSGOODS_EP);
		MyGoodsPageHelper.enterPage(seleniumUtil, MyGoodsPage.MGP_BUTTON_ADSEARCH);

		MyGoodsPageHelper.typeGoodsInfo(seleniumUtil, data.get("MGP_INPUT_GOODSNO"),data.get("MGP_INPUT_ORIGINALCITY"),
				data.get("MGP_INPUT_TARGETCITY"),data.get("MGP_INPUT_GOODSNAME"),data.get("MGP_WEIGHT_VOLUME"),
				data.get("MGP_START_WEIGHT_VOLUME"),data.get("MGP_END_WEIGHT_VOLUME"),data.get("MGP_INPUT_STARTDATE"),data.get("MGP_INPUT_ENDDATE"));
		MyGoodsPageHelper.checkGoodsSendDate(seleniumUtil, MyGoodsPage.MGP_DIV_GOODSTIME_EP, data.get("MGP_INPUT_STARTDATE"),data.get("MGP_INPUT_ENDDATE"));
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
