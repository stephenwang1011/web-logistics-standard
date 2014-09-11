package com.incito.logistics.testcase.home;

/**
 *@author  xy-incito
 *@Description 测试用例：未登录情况下点击公共货源的收藏按钮 弹出登陆页面
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;

public class HomePage_NotLogin_13_GoodFav_Test extends BaseParpare {
	@Test
	public void clickFav(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		seleniumUtil.mouseMoveToElement(HomePage.HP_ARERA_GOODS1);
		isBcolorChange();
		seleniumUtil.click(seleniumUtil.findElementBy(HomePage.HP_GOODS1_FAV));
		LoginPageHelper.waitLoginPageToLoad(timeOut, seleniumUtil);
		LoginPageHelper.checkLoginPageText(seleniumUtil);

	}

	// 通过获得css的值background-color来判断背景颜色是不是变了 粉色的背景演示是rgba(255, 238, 229, 1)
	public void isBcolorChange() {
		seleniumUtil.sleep(800);
		seleniumUtil.isTextCorrect(seleniumUtil.getCSSValue(seleniumUtil.findElementBy(HomePage.HP_AREAR_CARS1), "background-color"), "rgba(255, 238, 229, 1)");
	}

}
