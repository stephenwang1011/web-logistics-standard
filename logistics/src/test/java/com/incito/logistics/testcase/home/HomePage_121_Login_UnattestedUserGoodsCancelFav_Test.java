package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 接着用例120,在首页直接取消刚才收藏的货源，然后检查 找货源-我的收藏模块中货源应该不存在才对
 * 
 * */
public class HomePage_121_Login_UnattestedUserGoodsCancelFav_Test extends HomeUnattestedFather {
	@Test
	public void unattestedUserCancelGoodsFav(ITestContext context) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.cancelFavOnPubGoods(seleniumUtil, timeOut, sleepTime);


	}


}
