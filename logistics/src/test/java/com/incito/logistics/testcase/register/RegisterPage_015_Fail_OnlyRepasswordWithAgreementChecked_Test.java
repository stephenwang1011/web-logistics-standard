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
 * @Description 注册页面，只输入确认密码，用户名和密码都不输入并勾选用户协议checkbox,点击注册按钮，注册不成功
 * */
public class RegisterPage_015_Fail_OnlyRepasswordWithAgreementChecked_Test extends RegisterFather {

	@Test(dataProvider="data")
	public void onlyRepasswordWithAgreementChecked(ITestContext context,Map<String,String> data) {
		RegisterFather.registerParpare(context, seleniumUtil);
		final String REPASSWORD = "REPASSWORD";
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };


		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_REPASSWD, data, REPASSWORD);
		RegisterPageHelper.checkAgreement(seleniumUtil, timeOut);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);
	}
	

}
