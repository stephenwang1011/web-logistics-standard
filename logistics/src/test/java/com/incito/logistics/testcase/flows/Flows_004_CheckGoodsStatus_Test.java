package com.incito.logistics.testcase.flows;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.MyGoodsPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 检查web端的 该货源的状态 是不是变成以交易的状态，同时 查看订单按钮应该显示出来
 * */
public class Flows_004_CheckGoodsStatus_Test extends BaseParpare {

	@Test
	public void getGoodsID(ITestContext context) {
		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String username = PropertiesDataProvider.getTestData(userInfoPath, "username");
		String password = PropertiesDataProvider.getTestData(userInfoPath, "password");
		String GoodsInfo = context.getCurrentXmlTest().getParameter("GoodsInfo");
		String goodsno = PropertiesDataProvider.getTestData(GoodsInfo, "goodsno");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, username, password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_MYGOODS);
		MyGoodsPageHelper.waitMyGoodsPageToLoad(timeOut, seleniumUtil);
		MyGoodsPageHelper.checkGoodsStatus(seleniumUtil, goodsno, timeOut);

	
	}
	


}
