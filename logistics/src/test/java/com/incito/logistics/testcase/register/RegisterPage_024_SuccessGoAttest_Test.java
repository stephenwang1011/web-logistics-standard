package com.incito.logistics.testcase.register;

/**
 *@author  xy-incito-wy
 *@Description 测试用例：成功注册
 * */
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.incito.logistics.pages.RegisterPage;
import com.incito.logistics.pages.RegisterSuccessPage;
import com.incito.logistics.pages.pageshelper.AddUserInfoPagerHelper;
import com.incito.logistics.pages.pageshelper.RegisterPageHelper;
import com.incito.logistics.pages.pageshelper.RegisterSuccessPageHelper;
import com.incito.logistics.plugins.father.RegisterFather;

public class RegisterPage_024_SuccessGoAttest_Test extends RegisterFather {

	@Test(dataProvider="data")
	public void successGoHome_(ITestContext context,Map<String,String> data) {
		RegisterFather.registerParpare(context, seleniumUtil);
		final String USERNAME = "USERNAME";
		final String PASSWORD = "PASSWORD";
		final String REPASSWORD = "REPASSWORD";
		By bys[] = { RegisterPage.RP_INPUT_USERNAME, RegisterPage.RP_INPUT_PASSWD, RegisterPage.RP_INPUT_REPASSWD };



		RegisterPageHelper.checkRegisterPageText(seleniumUtil);
		for (By by : bys) {
			RegisterPageHelper.clearText(seleniumUtil, by);
		}	
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_USERNAME, data, USERNAME);
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_PASSWD, data, PASSWORD);
		RegisterPageHelper.typeRegisterUserInfo(seleniumUtil, RegisterPage.RP_INPUT_REPASSWD, data, REPASSWORD);
		RegisterPageHelper.checkAgreement(seleniumUtil, timeOut);
		RegisterPageHelper.enterPage(seleniumUtil, RegisterPage.RP_BUTTON_REGISTER);
		RegisterSuccessPageHelper.waitForRegisterSuccessPageToLoad(seleniumUtil, timeOut);
		RegisterSuccessPageHelper.checkRegisterSuccessPageText(seleniumUtil, timeOut);
		RegisterSuccessPageHelper.enterPage(seleniumUtil, RegisterSuccessPage.RSP_BUTTON_ATTESTINFO);
		RegisterPageHelper.checkUserInfo(timeOut, sleepTime, seleniumUtil, USERNAME, data);
		AddUserInfoPagerHelper.waitAddUserInfoPageToLoad(timeOut, seleniumUtil);
		AddUserInfoPagerHelper.checkAddUserInfoPageText(seleniumUtil);

	}

	
}
