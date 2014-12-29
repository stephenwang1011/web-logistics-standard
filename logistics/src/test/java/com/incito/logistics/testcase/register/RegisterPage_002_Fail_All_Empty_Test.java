package com.incito.logistics.testcase.register;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.plugins.father.RegisterFather;

/**
 * @author xy-incito-wk
 * @Description 注册失败：用户名和密码,确认密码都不填写
 * */
public class RegisterPage_002_Fail_All_Empty_Test extends RegisterFather {

	@Test
	public void registerFailTest_All_Empty(ITestContext context) {
		RegisterFather.registerParpare(context, seleniumUtil);
		By[] bys = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };

		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterPageHelper.checkRegistStatus(seleniumUtil);

	}

}