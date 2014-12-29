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
 * @Description 注册失败：只输入用户名和密码1
 * */
public class RegisterPage_006_Fail_UsernameAndPassword_Test extends RegisterFather {

	@Test(dataProvider="data")
	public void registerFailTest_UsernameAndPassword(ITestContext context,Map<String,String> data) {
		RegisterFather.registerParpare(context, seleniumUtil);
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };
		final String USERNAME="USERNAME";
		final String PASSWORD="PASSWORD";
		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_USERNAME, data, USERNAME);
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_PASSWD, data, PASSWORD);

		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);
	}
}
