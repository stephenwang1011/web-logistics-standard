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
 * @Description 注册失败：确认密码和密码相同
 * */
public class RegisterPage_008_Fail_PasswordAndRepassword_Test extends RegisterFather {

	@Test(dataProvider="data")
	public void registerFailTest_PasswordAndRepassword(ITestContext context,Map<String,String> data) {
		RegisterFather.registerParpare(context, seleniumUtil);
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };
		final String PASSWORD="PASSWORD";
		final String REPASSWORD="REPASSWORD";
		
		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_PASSWD, data, PASSWORD);
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_REPASSWD, data, REPASSWORD);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);
	}
	


}
