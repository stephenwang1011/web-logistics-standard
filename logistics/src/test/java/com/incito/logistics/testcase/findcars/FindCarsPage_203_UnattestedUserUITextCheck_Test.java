package com.incito.logistics.testcase.findcars;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FindCarsPageHelper;
import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.FindCarsUnattestedFather;

/**
 * @author xy-incito-wy
 * @Description 未认证的用户登录以后，检查找车源页面的UI
 * */
public class FindCarsPage_203_UnattestedUserUITextCheck_Test extends FindCarsUnattestedFather {

	@Test
	public void unattestedUserUITextCheck_(ITestContext context) {
		FindCarsUnattestedFather.unattestedFindCarsParpare(context, seleniumUtil);
		FindCarsPageHelper.checkFindCarsPageText(timeOut, seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);

	}

}
