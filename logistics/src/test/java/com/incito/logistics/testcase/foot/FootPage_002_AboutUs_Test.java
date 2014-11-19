package com.incito.logistics.testcase.foot;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.FootPage;
import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;

/**
 * @author xy-incito-wk
 * @Description 主页未登录的情况下,点击首页底部关于我们
 * 
 * */
public class FootPage_002_AboutUs_Test extends BaseParpare {
	@Test
	public void contactUs(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, FootPage.FP_LINK_ABOUTUS);
		FooterPageHelper.waitTAB_Foot_FourInfoToLoad(timeOut, seleniumUtil);

		FooterPageHelper.checkFootPageText(seleniumUtil, FootPage.FP_HOST_LINK_ABOUTUS);
	}
}
