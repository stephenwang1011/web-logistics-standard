package com.incito.logistics.testcase.register;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.plugins.father.RegisterFather;

/**
 * @author xy-incito-wy
 * @Description 注册页面，输入用户名，密码和确认密码不一致并且勾选同意注册条款的checkbox，点击注册，注册不应该成功
 * */
public class RegisterPage_020_Fail_UsernameAndPasswordDifRepasswordWithAgreementChecked_Test extends RegisterFather {

	@Test(dataProvider = "data")
	public void usernameAndPasswordDifRepasswordWithAgreementChecked_(ITestContext context, Map<String, String> data) {
		RegisterFather.registerParpare(context, seleniumUtil);
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };
		final String USERNAME = "USERNAME";
		final String PASSWORD = "PASSWORD";
		final String REPASSWORD = "REPASSWORD";
		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_USERNAME, data, USERNAME);
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_PASSWD, data, PASSWORD);
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_REPASSWD, data, REPASSWORD);
		RegisterPageHelper.checkAgreement(seleniumUtil, timeOut);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);
	}



}
