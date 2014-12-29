package com.incito.logistics.testcase.register;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.plugins.father.RegisterFather;

/**
 * @author xy-incito-wk
 * @Description 注册失败：只输入用户名不输入密码 点击登陆会提示“密码长度为6-20个字符”
 * */
public class RegisterPage_003_Fail_OnlyUsername_Test extends RegisterFather {

	@Test(dataProvider = "data")
	public void registerFailTest_Username(ITestContext context,Map<String,String> data) {
		RegisterFather.registerParpare(context, seleniumUtil);
		final String USERNAME = "USERNAME";
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };

		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_USERNAME, data,USERNAME);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);
	}
	
}
