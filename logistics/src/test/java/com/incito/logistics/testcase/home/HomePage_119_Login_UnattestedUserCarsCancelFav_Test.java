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
 * @Description 接着用例118，登录情况下，未认证的用户去点击取消收藏按钮,，应该取消收藏成功，同时在找车源我的收藏模块中不存在此车源
 * 
 * */
public class HomePage_119_Login_UnattestedUserCarsCancelFav_Test extends HomeUnattestedFather {
	@Test(dataProvider="data")
	public void unattestedUserCarsCancelFav(ITestContext context,Map<String,String> data) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		HomePageHelper.clickFavButtonByLicenseAndDriver(data.get("License"),data.get("Driver"), seleniumUtil,HomePage.HP_BUTTON_CFAV);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_LINK_FINDCARS);
		FindCarsPageHelper.waitFindCarsPageToLoad(timeOut, seleniumUtil);
		FindCarsPageHelper.enterPage(seleniumUtil, FindCarsPage.FCP_TAB_FAV);
		FindCarsPageHelper.doesCarsFavInMyFav(seleniumUtil,data.get("License"),data.get("Driver"));

	}

}
