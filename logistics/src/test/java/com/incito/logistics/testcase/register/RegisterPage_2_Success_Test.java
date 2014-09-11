package com.incito.logistics.testcase.register;

/**
 *@author  xy-incito
 *@Description 测试用例：成功注册
 * */
import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.util.GetTestData;

public class RegisterPage_2_Success_Test extends BaseParpare {

	@Test
	public void RegisterSuccessTest(ITestContext context) {
		String configFilePath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String register_username = GetTestData.getTestData(configFilePath, "register_username");
		String register_password = GetTestData.getTestData(configFilePath, "register_password");
		String register_repassword = GetTestData.getTestData(configFilePath, "register_repassword");
		String keys[] = { register_username, register_password, register_repassword };
		By bys[] = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };

		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		int sleepTime = Integer.valueOf(context.getCurrentXmlTest().getParameter("sleepTime"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_REG);
		RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
		RegisterPageHelper.checkRegisterPageText(seleniumUtil);
		for (By by : bys) {
			seleniumUtil.clear(seleniumUtil.findElementBy(by));
		}
		for (int i = 0; i < keys.length; i++) {
			RegisterPageHelper.registerUserInfo(seleniumUtil, bys[i], keys[i]);
		}
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, register_username);

	}

}
