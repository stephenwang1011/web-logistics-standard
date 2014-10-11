package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.LoginPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

/**
 * @author xy-incito-wy
 * @Description 测试用例：未登录情况下点击公共车源和货源上的 "更多>>" 按钮弹出登陆页面
 * 
 * */
public class HomePage_009_NotLogin_More_Test extends BaseParpare {
	@Test
	public void clickMore(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		int size = seleniumUtil.findElementsBy(HomePage.HP_LINK_MORE).size();

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		for (int i = 0; i < size; i++) {
			seleniumUtil.click(seleniumUtil.findElementsBy(HomePage.HP_LINK_MORE).get(i));
			LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
			LoginPageHelper.checkLoginPageText(seleniumUtil);
			LoginPageHelper.enterPage(seleniumUtil, LoginPage.LP_BUTTON_CLOSE);
			if (i < 1) {
				seleniumUtil.pause(sleepTime);
			}
		}

	}

}
