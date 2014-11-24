package com.incito.logistics.testcase.home;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.LoginPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wy
 * @Description 测试用例：企业版账户登录成功以后再次检查 顶部天气，城市，日期等是否显示出来
 * 
 * */
public class HomePage_501_Login_Enterprise_TopCheck_Test extends BaseParpare {
	@Test
	public void enterpriseTopCheck(ITestContext context) {
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		String configFilePath = String.valueOf(context.getCurrentXmlTest().getParameter("userInfoPath"));
		String enterprise_username = PropertiesDataProvider.getTestData(configFilePath, "enterprise_username");
		String enterprise_password = PropertiesDataProvider.getTestData(configFilePath, "enterprise_password");
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));
				
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_LOGIN);
		LoginPageHelper.login(seleniumUtil, enterprise_username, enterprise_password);
		HomePageHelper.holdOn(seleniumUtil, sleepTime);
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
