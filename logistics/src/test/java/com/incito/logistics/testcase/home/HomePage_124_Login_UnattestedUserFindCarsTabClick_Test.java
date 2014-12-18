package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下,未认证用户 点击找车源，成功进入找车源页面
 * 
 * */
public class HomePage_124_Login_UnattestedUserFindCarsTabClick_Test extends HomeUnattestedFather {
	@Test
	public void loginUnattestedUserFindCarsTabClick(ITestContext context) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDCARS);
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
		FindCarsPageHelper.checkFindCarsPageText(timeOut, seleniumUtil);
	}
}
