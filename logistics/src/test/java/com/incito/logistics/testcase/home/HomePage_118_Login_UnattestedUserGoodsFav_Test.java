package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnauthenticationFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下，未认证的用户去点击收藏按钮，应该收藏成功并且在找车源-我的收藏中有刚才收藏的车源
 * 
 * */
public class HomePage_118_Login_UnattestedUserGoodsFav_Test extends HomeUnauthenticationFather {
	@Test(dataProvider="data")
	public void unauthenticationUserGoodsFav(ITestContext context,Map<String,String> data) {
		HomeUnauthenticationFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.clickFavButtonByLicenseAndDriver(data.get("License"),data.get("Driver"), seleniumUtil);

	}

}
