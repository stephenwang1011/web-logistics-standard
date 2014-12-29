package com.incito.logistics.testcase.mygoods;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.plugins.father.MyGoodsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：我的货源界面检查
 * */
public class MyGoodsPage_001_UITextCheck_Test extends MyGoodsFather {

	@Test
	public void uITextCheck(ITestContext context) {
		MyGoodsFather.myGoodsParpare(context, seleniumUtil);

	}

}
