package com.incito.logistics.testcase.home;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.FindCarsPage;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下，未认证的用户去点击收藏按钮，应该收藏成功并且在找车源-我的收藏中有刚才收藏的车源
 * 
 * */
public class HomePage_118_Login_UnattestedUserCarsFav_Test extends HomeUnattestedFather {
	@Test(dataProvider="data")
	public void unattestedUserCarsFav(ITestContext context,Map<String,String> data) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.clickFavButtonByLicenseAndDriver(data.get("License"),data.get("Driver"), seleniumUtil,HomePage.HP_BUTTON_FAV);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDCARS);
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.doesCarsFavInMyFav(seleniumUtil,data.get("License"),data.get("Driver"));

	}

}
