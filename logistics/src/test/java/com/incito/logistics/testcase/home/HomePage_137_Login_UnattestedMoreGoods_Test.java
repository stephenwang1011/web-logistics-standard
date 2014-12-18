package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.HomeUnattestedFather;

	/**
	 * @author xy-incito-wy
	 * @Description 登录情况下,未认证用户点击公共货源上的 "更多>>" 进入找货源页面
	 * 
	 * */
	public class HomePage_137_Login_UnattestedMoreGoods_Test extends HomeUnattestedFather {
	@Test
	public void loginUnattestedMoreGoods(ITestContext context) {
		HomeUnattestedFather.homeUnauthenticationParpare(context, seleniumUtil);
		seleniumUtil.click(seleniumUtil.findElementsBy(HomePage.HP_LINK_MORE).get(1));
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);

		}

	}


