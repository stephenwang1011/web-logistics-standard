package com.incito.logistics.testcase.mygoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.MyGoodsUnatestedFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：已登录的情况下，未认证的用户登录，我的货源界面检查
 * */
public class MyGoodsPage_101_UnattestedUserUITextCheck_Test extends MyGoodsUnatestedFather {
	@Test
	public void uITextCheck(ITestContext context) {
		MyGoodsUnatestedFather.UnattestedMyOrdersParpare(context, seleniumUtil);
		
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
