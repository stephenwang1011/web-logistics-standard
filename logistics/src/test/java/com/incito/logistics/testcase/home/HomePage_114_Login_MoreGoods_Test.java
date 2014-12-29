package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.FindGoodsPageHelper;
import com.incito.logistics.plugins.father.HomeAttestedFather;

/**
 * @author xy-incito-wy
 * @Description 登录情况下点击公共货源上的 "更多>>" 进入找货源页面
 * 
 * */
public class HomePage_114_Login_MoreGoods_Test extends HomeAttestedFather {
	@Test
	public void clickMoreGoods(ITestContext context) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);

		seleniumUtil.click(seleniumUtil.findElementsBy(HomePage.HP_LINK_MORE).get(1));
		FindGoodsPageHelper.waitFindGoodsPageToLoad(timeOut, seleniumUtil);

	}

}
