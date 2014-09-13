package com.incito.logistics.testcase.register;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.util.PropertiesDataProvider;

/**
 * @author xy-incito-wangkai
 * @Description 注册失败：只输入用户名和密码2
 * */
public class RegisterPage_07_Fail_UsernameAndRepassword_Test extends BaseParpare {

	@Test
	public void registerFailTest_UsernameAndRepassword(ITestContext context) {
		String configFilePath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String register_username = PropertiesDataProvider.getTestData(configFilePath, "register_username");
		String register_repassword = PropertiesDataProvider.getTestData(configFilePath, "register_repassword");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_REG);
		RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
		for (By by : bys) {
			seleniumUtil.clear(seleniumUtil.findElementBy(by));
		}
		seleniumUtil.type(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME), register_username);
		seleniumUtil.type(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_REPASSWD), register_repassword);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegisterPagePrompt_UsernameAndRepassword(timeOut, seleniumUtil);
	}

}
