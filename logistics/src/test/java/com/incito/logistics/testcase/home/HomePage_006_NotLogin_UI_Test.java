package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.pageshelper.HomePageHelper;

/**
 * @author xy-incito-wy
 * @Description 测试用例：首页UI测试
 * 
 * */
public class HomePage_006_NotLogin_UI_Test extends BaseParpare {
	@Test
	public void uiTest(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.checkLogo();

	}

}
