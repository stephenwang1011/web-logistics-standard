package com.incito.logistics.testcase.sendgoods;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.SendGoodsForEnterprisePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.SendGoodsForEnterprisePageHelper;
import com.incito.logistics.pages.pageshelper.SendGoodsSuccessPageHelper;
import com.incito.logistics.util.ExcelDataProvider;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源，所有的输入合法有效，然后点击发布按钮确认是否发布成功(重量)
 * */
public class SendGoodsPage_542_Enterprise_AllValidDataForWeightToCars_Test extends BaseParpare {

	@Test(dataProvider = "data")
	public void sendAllValidDataForWeightToCarsSuccessTest(ITestContext context, Map<String, String> data) {
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
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_FREESEND);

		SendGoodsForEnterprisePageHelper.typeGoodsInfo(seleniumUtil, "发布到车队", SendGoodsForEnterprisePage.SGP_RADIOBOX_LIGHTGOODS,SendGoodsForEnterprisePage.SGP_NUKNOW_BY,data.get("SGP_INPUT_GOODSORIGINALCITY"), 
				data.get("SGP_INPUT_GOODSRECEIPTCITY"), data.get("SGP_INPUT_GOODSNAME"),data.get("SGP_INPUT_GOODSDETAILS"),data.get("SGP_INPUT_VOLUME"), data.get("SGP_INPUT_COUNT"), data.get("SGP_INPUT_CARLENGTH"), 
				data.get("SGP_INPUT_CARTYPE"), data.get("SGP_INPUT_SENDERSTREET"), data.get("SGP_INPUT_SENDERNAME"), data.get("SGP_INPUT_SENDERTEL"), data.get("SGP_INPUT_SENDERCOMPANY"), data.get("SGP_INPUT_RECEIPTNAME"), data.get("SGP_INPUT_RECEIPTTEL"), 
				data.get("SGP_INPUT_RECEIPTCOMPANY"),data.get("SGP_INPUT_INSTRUCTION"), data.get("SGP_RADIOBOX_YESORNO"), data.get("SGP_INPUT_RECEIPTSTREET"));
		SendGoodsForEnterprisePageHelper.enterPage(seleniumUtil, SendGoodsForEnterprisePage.SGP_BUTTON_SEND);
		SendGoodsSuccessPageHelper.waitSendGoodsSuccessPageToLoadForEnterprise(timeOut, seleniumUtil);
		SendGoodsSuccessPageHelper.checkSendGoodsPageTextForEnterprise(seleniumUtil);

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
