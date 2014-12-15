package com.incito.logistics.testcase.home;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;
import com.incito.logistics.pages.pageshelper.MyOrdersPageHelper;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 进行快速查找订单
 * 
 * */
public class HomePage_113_Login_QuickSearchOrdersForEmpty_Test extends BaseParpare {
	@Test
	public void quickSearchOrdersForEmpty(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		String username = PropertiesDataProvider.getTestData(configFilePath, "username");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, username, password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_SEARCH1);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		MyOrdersPageHelper.waitForMyOrdersPageToLoad(seleniumUtil, timeOut);

		


	}
}
