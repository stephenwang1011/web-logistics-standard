package com.incito.logistics.testcase.sendgoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.SendGoodsPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.pages.pageshelper.SendGoodsPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;


/**
 * @author xy-incito-wy
 * @Description 测试用例：发布货源，不输入任何内容点击发布按钮
 * */
public class SendGoodsPage_005_All_Empty_Data_Fail_Test extends BaseParpare {

	@Test
	public void sendAllEmptyDataFailTest(ITestContext context) {
		String userInfoPath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String username = PropertiesDataProvider.getTestData(userInfoPath, "username");
		String password = PropertiesDataProvider.getTestData(userInfoPath, "password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.login(seleniumUtil, username, password);
		LoginPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, username);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_FREESEND);
		SendGoodsPageHelper.waitSendGoodsPageToLoad(timeOut, seleniumUtil);
		SendGoodsPageHelper.checkSendGoodsPageText(seleniumUtil);
		SendGoodsPageHelper.enterPage(seleniumUtil, SendGoodsPage.SGP_BUTTON_SEND);
		SendGoodsPageHelper.checkSendGoodsFailedStatus(seleniumUtil);
		
	}
}
