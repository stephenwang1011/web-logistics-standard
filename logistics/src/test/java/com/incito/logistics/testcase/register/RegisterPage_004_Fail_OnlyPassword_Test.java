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
 * @author xy-incito-wk
 * @Description 注册失败：不输入用户名，只输入密码1，点击登陆提示 请输入用户名（但是实际中只提示：用户名称不能全部为数字。后期进行更改）
 * */
// 后期需要更改该测试用例中提示语
public class RegisterPage_004_Fail_OnlyPassword_Test extends BaseParpare {

	@Test
	public void registerFailTest_Password(ITestContext context) {
		String configFilePath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String password = PropertiesDataProvider.getTestData(configFilePath, "password");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_REG);
		RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		seleniumUtil.type(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_PASSWD), password);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegisterPagePrompt_Passwd(timeOut, seleniumUtil);
	}

}
