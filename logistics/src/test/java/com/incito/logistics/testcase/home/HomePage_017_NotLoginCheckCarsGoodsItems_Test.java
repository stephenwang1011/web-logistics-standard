package com.incito.logistics.testcase.home;


import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeNotLoginFather;
/**
 *@author  xy-incito-wy
 *@Description 测试用例：未登录情况下 检查首页的公共车源和公共货源是不是最多有8条
 *
 * */
public class HomePage_017_NotLoginCheckCarsGoodsItems_Test extends HomeNotLoginFather {
	@Test
	public void notLoginCheckGoodsCarsItems(ITestContext context) {

		HomeNotLoginFather.homeNotLoginParpare(context, seleniumUtil);
		HomePageHelper.checkCarsGoodsItems(seleniumUtil);
		

	}

}
