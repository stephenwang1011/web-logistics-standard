package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下，未认证用户点击公共车源上的 "更多>>" 进入找车源页面
 * 
 * */
public class HomePage_138_Login_UnattestedMoreCars_Test extends HomeUnattestedFather {
	@Test
	public void loginUnattestedMoreCars(ITestContext context) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);

		seleniumUtil.click(seleniumUtil.findElementsBy(HomePage.HP_LINK_MORE).get(0));
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
	}

}
