package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证用户登录之后检查首页公共车源和货源的条数 最多为8条
 * 
 * */
public class HomePage_123_Login_UnattestedUserGoodsCarsItems_Test extends HomeUnattestedFather {
	@Test
	public void unattestedUserGoodsCarsItems(ITestContext context) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.checkCarsGoodsItems(seleniumUtil);
	}

}
