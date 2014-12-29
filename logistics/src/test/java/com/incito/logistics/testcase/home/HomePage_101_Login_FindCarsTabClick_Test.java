package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下 点击找车源，成功进入找车源页面
 * 
 * */
public class HomePage_101_Login_FindCarsTabClick_Test extends HomeAttestedFather {
	@Test
	public void loginFindCarsTabClick(ITestContext context) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDCARS);
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
		FindCarsPageHelper.checkFindCarsPageText(timeOut, seleniumUtil);
	}
}
