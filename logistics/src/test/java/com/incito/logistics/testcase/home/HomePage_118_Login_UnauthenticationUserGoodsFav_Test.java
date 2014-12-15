package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 登录情况下，未认证的用户去点击收藏按钮，应该收藏成功并且在找车源-我的收藏中有刚才收藏的车源
 * 
 * */
public class HomePage_118_Login_UnauthenticationUserGoodsFav_Test extends BaseParpare {
	@Test
	public void unauthenticationUserGoodsFav(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		String unauthusername = PropertiesDataProvider.getTestData(configFilePath, "unauthusername");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
		int indexGoods = Integer.valueOf(context.getCurrentXmlTest().getParameter("indexGoods"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.checkHomePageText(seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, unauthusername, password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_ARERA_CARDSANDGOODS, HomePage.HP_BUTTON_FAV, indexGoods);
		HomePageHelper.checkFavButton(seleniumUtil, HomePage.HP_ARERA_CARDSANDGOODS, HomePage.HP_BUTTON_CFAV, indexGoods);


	}

}
