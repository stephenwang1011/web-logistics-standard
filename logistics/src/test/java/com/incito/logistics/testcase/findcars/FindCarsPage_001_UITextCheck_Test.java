package com.incito.logistics.testcase.findcars;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.pageshelper.FooterPageHelper;
import com.incito.logistics.plugins.father.FindCarsFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：找车源，UI文本检查
 * */
public class FindCarsPage_001_UITextCheck_Test extends FindCarsFather {

	@Test
	public void findCarsPageUiTextCheck(ITestContext context) {
		FindCarsFather.FindCarsParpare(context, seleniumUtil);
		FooterPageHelper.checkFooterPageText(seleniumUtil);
	}
}
