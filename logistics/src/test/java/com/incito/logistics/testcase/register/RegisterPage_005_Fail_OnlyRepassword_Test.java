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
 * @Description 注册失败：不输入用户名，只输入确认密码
 * */
public class RegisterPage_005_Fail_OnlyRepassword_Test extends RegisterFather {

	@Test(dataProvider="data")
	public void registerFailTest_Repassword(ITestContext context,Map<String,String> data) {
		RegisterFather.registerParpare(context, seleniumUtil);
		final String PASSWORD = "PASSWORD";
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };


		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_REPASSWD, data, PASSWORD);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);
	}
	

}
