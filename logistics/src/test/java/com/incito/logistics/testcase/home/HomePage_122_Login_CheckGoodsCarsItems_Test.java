package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 认证的用户登录之后，检测首页的公共车源和公共货源的 的分别最多条数是8条
 * 
 * */
public class HomePage_122_Login_CheckGoodsCarsItems_Test extends HomeUnattestedFather {
	@Test
	public void unattestedUserCarsCancelFav(ITestContext context) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);
		HomePageHelper.checkCarsGoodsItems(seleniumUtil);
		

	}

}
