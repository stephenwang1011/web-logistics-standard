package com.incito.logistics.testcase.personcenter;

/**
 *@author  xy-incito-wk
 *@Description 测试用例：已登录的情况下，未认证的用户登录，我的订单UI、文本测试
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.pages.pageshelper.PersonCenterPageHelper;
import com.incito.logistics.plugins.father.PensonCenterUnatestedFather;

public class PensonCenterPage_001_UnattestedUserUITextCheck_Test extends PensonCenterUnatestedFather {
	@Test
	public void personCenterUiTest(ITestContext context) {
		PensonCenterUnatestedFather.UnattestedPensonCenterParpare(context, seleniumUtil);
		PersonCenterPageHelper.checkPersonCenterPageText(seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
