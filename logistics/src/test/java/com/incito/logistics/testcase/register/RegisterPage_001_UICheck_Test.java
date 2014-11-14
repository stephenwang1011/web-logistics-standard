package com.incito.logistics.testcase.register;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;

/**
 * @author xy-incito-wk
 * @Description 注册页面上的文本检查
 * 
 * */
public class RegisterPage_001_UICheck_Test extends BaseParpare {
	@Test
	public void registerPageUiTest(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_REG);
		RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
		RegisterPageHelper.checkRegisterPageText(seleniumUtil);

	}

}
