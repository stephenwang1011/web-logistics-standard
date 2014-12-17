package com.incito.logistics.testcase.mygoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.MyGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：我的货源界面检查
 * */
public class MyGoodsPage_101_UnattestedUserUITextCheck_Test extends MyGoodsFather {
	@Test
	public void uITextCheck(ITestContext context) {
		MyGoodsFather.UnattestedMyOrdersParpare(context, seleniumUtil);
		
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
