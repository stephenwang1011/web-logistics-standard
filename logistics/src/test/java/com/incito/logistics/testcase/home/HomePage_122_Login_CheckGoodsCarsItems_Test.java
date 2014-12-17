package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 接着用例118，登录情况下，未认证的用户去点击取消收藏按钮,，应该取消收藏成功，同时在找车源我的收藏模块中不存在此车源
 * 
 * */
public class HomePage_122_Login_CheckGoodsCarsItems_Test extends HomeUnattestedFather {
	@Test
	public void unattestedUserCarsCancelFav(ITestContext context) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);
		HomePageHelper.checkCarsGoodsItems(seleniumUtil);
		

	}

}
