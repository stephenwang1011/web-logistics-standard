package com.incito.logistics.testcase.mygoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.MyGoodsPage;
import com.incito.logistics.pages.pageshelper.MyGoodsPageHelper;
import com.incito.logistics.plugins.father.MyGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：已登录的情况下，未认证的用户登录，我的货源界面无数据的提示信息
 * */
public class MyGoodsPage_102_UnattestedUserNoInfo_Test extends MyGoodsFather {
	@Test
	public void uITextCheck(ITestContext context) {
		MyGoodsFather.UnattestedMyOrdersParpare(context, seleniumUtil);

		MyGoodsPageHelper.myGoodsNoInfo(seleniumUtil, MyGoodsPage.MGP_TEXT_NOINFO);
	}
}
