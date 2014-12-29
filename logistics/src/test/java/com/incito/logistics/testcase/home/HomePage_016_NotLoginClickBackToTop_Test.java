package com.incito.logistics.testcase.home;


import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeNotLoginFather;
/**
 *@author  xy-incito-wy
 *@Description 测试用例：未登录情况下点击返回到顶部按钮，能正常返回到顶部
 *
 * */
public class HomePage_016_NotLoginClickBackToTop_Test extends HomeNotLoginFather {
	@Test
	public void notLoginClickBackToTop(ITestContext context) {
		HomeNotLoginFather.homeNotLoginParpare(context, seleniumUtil);
		HomePageHelper.backToTopCheck(seleniumUtil, timeOut);
		

	}

}
