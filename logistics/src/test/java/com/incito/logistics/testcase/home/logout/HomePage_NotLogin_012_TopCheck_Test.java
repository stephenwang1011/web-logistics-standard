package com.incito.logistics.testcase.home.logout;

/**
 *@author  xy-incito-wy
 *@Description 测试用例：顶部天气，城市，日期检查点
 *
 * */
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;

public class HomePage_NotLogin_012_TopCheck_Test extends BaseParpare {
	@Test
	public void topCheck(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		isInFrameDisplay(timeOut);
		isContainInFrame();
		isOutFrameDisplay(timeOut);
		isContainOutFrame();

	}

	// 检查页面元素是不是显示出来
	public void isInFrameDisplay(int timeOut) {
		// 跳入指定的frame中
		seleniumUtil.switchFrame(seleniumUtil.findElementBy(HomePage.HP_FRAME));
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_CITY);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_WEATHER);
	}

	public void isOutFrameDisplay(int timeOut) {
		// 跳出frame
		seleniumUtil.outFrame();
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_DATE);
	}

	// 检查web页面上的文本内容是不是和需求文档定义的一致LP_INPUT_AUTO
	public void isContainInFrame() {
		seleniumUtil.assertTrue(seleniumUtil.findElementBy(HomePage.HP_TEXT_WEATHER), "今");
		seleniumUtil.assertTrue(seleniumUtil.findElementBy(HomePage.HP_TEXT_WEATHER), "明");
		seleniumUtil.isTextCorrect(seleniumUtil.findElementBy(HomePage.HP_TEXT_CITY).getText(), "襄阳");

	}

	public void isContainOutFrame() {
		seleniumUtil.assertTrue(seleniumUtil.findElementBy(HomePage.HP_TEXT_DATE), "月");
		seleniumUtil.assertTrue(seleniumUtil.findElementBy(HomePage.HP_TEXT_DATE), "日");
		seleniumUtil.assertTrue(seleniumUtil.findElementBy(HomePage.HP_TEXT_DATE), "（星期");
	}

}
