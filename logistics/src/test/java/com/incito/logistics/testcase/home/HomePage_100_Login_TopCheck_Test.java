package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.HomePage;
import com.incito.logistics.plugins.father.HomeAttestedFather;

/**
 * @author xy-incito-wy
 * @Description 测试用例：登录成功以后再次检查 顶部天气，城市，日期等是否显示出来
 * 
 * */
public class HomePage_100_Login_TopCheck_Test extends HomeAttestedFather {
	@Test
	public void topCheck(ITestContext context) {
		HomeAttestedFather.homeAuthenticationParpare(context, seleniumUtil);
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
