package com.incito.logistics.testcase.register;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.base.BaseParpare;
import com.incito.logistics.pages.HomePage;
import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.HomePageHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.util.GetTestData;

/**
 * @author xy-incito-wangkai
 * @Description 注册失败：只输入用户名不输入密码 点击登陆会提示“密码长度为6-20个字符”
 * */
public class RegisterPage_4_Fail_Username_Test extends BaseParpare {

	@Test
	public void registerFailTest_Username(ITestContext context) {
		String configFilePath = context.getCurrentXmlTest().getParameter("userInfoPath");
		String register_username = GetTestData.getTestData(configFilePath, "register_username");
		int timeOut = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeOut"));

		HomePageHelper.waitHomePageToLoad(timeOut, seleniumUtil);
		HomePageHelper.enterPage(seleniumUtil, HomePage.HP_BUTTON_REG);
		RegisterPageHelper.waitRegisterPageToLoad(timeOut, seleniumUtil);
		seleniumUtil.clear(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME));
		seleniumUtil.type(seleniumUtil.findElementBy(RegisterPage.RP_INPUT_USERNAME), register_username);
		seleniumUtil.click(seleniumUtil.findElementBy(RegisterPage.RP_BUTTON_REGISTER));
		RegisterPageHelper.checkRegisterPagePrompt(timeOut, seleniumUtil);
	}

}
