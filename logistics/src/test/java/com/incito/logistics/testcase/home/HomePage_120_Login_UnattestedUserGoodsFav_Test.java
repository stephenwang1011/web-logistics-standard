package com.incito.logistics.testcase.home;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下，未认证的用户去点击公共货源上的收藏按钮，应该收藏成功并且在找货源-我的收藏中有刚才收藏的货源
 * 
 * */
public class HomePage_120_Login_UnattestedUserGoodsFav_Test extends HomeUnattestedFather {
	@Test
	public void unattestedUserGoodsFav(ITestContext context) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.favOnPubGoods(seleniumUtil, timeOut, sleepTime);


	}

}
